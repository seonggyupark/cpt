package cybion.abstract_annotator;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.uima.ts.AbstractAnnotation;
import org.apache.uima.SentenceAnnotation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import java.util.ArrayList;
import java.util.List;

public class RecoveryRetriever {

  public RecoveryRetriever() {

  }

  public String retrieveAbstract(JCas cas) throws AssertionError {
    List<Annotation> sentenceAnnotations = AnnotatorUtils.getAnnotations(SentenceAnnotation.type,
            cas);

    // if the document is composed by less than 3 sentences then this approach is not good
    assert sentenceAnnotations.size() > 2;

    // take 33% of document text
    Integer documentTextLength = cas.getDocumentText().length() / 3;

    // get a list of the first annotations
    List<SentenceAnnotation> firstAnnotations = new ArrayList<SentenceAnnotation>();
    for (Annotation annotation : sentenceAnnotations.subList(1, sentenceAnnotations.size() - 1)) {
      // filter out the first sentence
      firstAnnotations.add((SentenceAnnotation) annotation);
      documentTextLength -= annotation.getCoveredText().length();
      if (documentTextLength <= 0) {
        break;
      }
    }

    String recoveryAbstract = "";
    // get the longest one inside the first sentences
    try {
      SentenceAnnotation goodSentence = null;
      for (SentenceAnnotation sentence : firstAnnotations) {
//        if (AnnotatorUtils.getContainedAnnotations(sentence, org.apache.uima.calais.Company.type)
//                .size() > 0 || AnnotatorUtils.getContainedAnnotations(sentence, org.apache.uima.calais.Organization.type)
//                .size() > 0) {
//          recoveryAbstract = sentence.getCoveredText();
//          break;
//        }
//        else

        if (sentence.getCoveredText().length() > recoveryAbstract.length()
                || recoveryAbstract.equals("")) {
          goodSentence = sentence;
        }
      }
      if (goodSentence != null) {
        recoveryAbstract = goodSentence.getCoveredText();
        AbstractAnnotation abstractAnnotation = new AbstractAnnotation(cas);
        abstractAnnotation.setBegin(goodSentence.getBegin());
        abstractAnnotation.setEnd(goodSentence.getEnd());
        abstractAnnotation.addToIndexes();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    assert !recoveryAbstract.equals("") : "recovery did not work for some reason";

    return recoveryAbstract;
  }

}
