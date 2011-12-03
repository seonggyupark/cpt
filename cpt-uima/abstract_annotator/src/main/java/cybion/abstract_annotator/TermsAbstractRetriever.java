package cybion.abstract_annotator;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.SentenceAnnotation;
import org.apache.uima.TokenAnnotation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.TermsDictionary;
import cybion.uima.ts.AbstractAnnotation;

public class TermsAbstractRetriever {

  private List<SentenceAnnotation> candidates;

  private DictionaryProvider dictionaryProvider;

  public TermsAbstractRetriever(DictionaryProvider dictionaryProvider) {
    this.dictionaryProvider = dictionaryProvider;
    candidates = new ArrayList<SentenceAnnotation>();
  }

  public String retrieveAbstract(JCas cas) {
    StringBuffer buf = new StringBuffer();

    // get the terms dictionary of the proper language
    TermsDictionary dictionary = dictionaryProvider.getDictionary(cas.getDocumentLanguage());

    int max = 0;
    List<Annotation> sentences = AnnotatorUtils.getAnnotations(SentenceAnnotation.type, cas);
    List<Annotation> firstSentenceAnnotations = sentences.subList(0, Double.valueOf(
            sentences.size() * 0.4).intValue());
    for (Annotation annotation : firstSentenceAnnotations) {
      int counter = 0;
      SentenceAnnotation s = (SentenceAnnotation) annotation;
      try {
        // get token inside the current sentence
        for (TokenAnnotation word : AnnotatorUtils.getTokensInsideSentence(s)) {
          // check if the token corresponds to one of the dictionary terms
          if (dictionary.containsTerm(word.getCoveredText())) {
            counter++;
          }
        }
      } catch (Exception e) {
        // do nothing
      }
      // if counter > max -> new maximum found, previous candidates are not good
      if (counter > max) {
        this.candidates.clear();
        this.candidates.add(s);
      } else if (counter > 0 && counter == max) { // sentence with same score as max
        this.candidates.add(s);
      }

    }

    if (!this.candidates.isEmpty()) {

      for (SentenceAnnotation s : this.candidates) {
        System.err.println("appending sentence for abstract");
        AbstractAnnotation abstractAnnotation = new AbstractAnnotation(cas);
        abstractAnnotation.setBegin(s.getBegin());
        abstractAnnotation.setEnd(s.getEnd());
        abstractAnnotation.addToIndexes();
        buf.append(s.getCoveredText());
      }
    }

    return buf.toString();
  }
}
