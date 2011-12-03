package cybion.beneficiary_annotator;

import cybion.annotator_utils.TermsDictionary;
import cybion.beneficiary_annotator.dictionary.BeneficiaryDictionaryProvider;
import org.apache.uima.SentenceAnnotation;
import org.apache.uima.TokenAnnotation;
import org.apache.uima.UIMAFramework;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.util.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tommaso
 */
public class DictionaryBeneficiaryRetriever implements BeneficiaryRetriever {

  private BeneficiaryDictionaryProvider dictionaryProvider;

  public DictionaryBeneficiaryRetriever() {
    dictionaryProvider = new BeneficiaryDictionaryProvider();
  }

  public BeneficiaryDictionaryProvider getDictionaryProvider() {
    return dictionaryProvider;
  }

  /**
   * get beneficiary from the document language specific terms found inside sentences
   *
   * @param cas
   * @return
   */
  public String getBeneficiary(JCas cas) {
    String documentLanguage = cas.getDocumentLanguage();
    List<SentenceAnnotation> candidates = new ArrayList<SentenceAnnotation>();
    if (documentLanguage != null && documentLanguage.length() > 0 && !"x-unspecified".equals(documentLanguage)) {
      TermsDictionary termsDictionary = dictionaryProvider.getDictionary(documentLanguage);

      for (Annotation sentenceAnnotation : cas.getAnnotationIndex(SentenceAnnotation.type)) {
        int i = 0;
        SentenceAnnotation sentence = (SentenceAnnotation) sentenceAnnotation;

        // filter and takes only the token annotations inside the sentence
        AnnotationIndex<Annotation> tokenIndex = cas.getAnnotationIndex(TokenAnnotation.type);
        List<TokenAnnotation> tokens = new ArrayList<TokenAnnotation>();
        for (Annotation ta : tokenIndex) {
          if (ta.getBegin() < sentence.getEnd() && ta.getEnd() > sentence.getBegin()) {
            tokens.add((TokenAnnotation) ta);
          }
        }

        // check if some token contains a beneficiary term
        for (TokenAnnotation tokenAnnotation : tokens) {
          if (termsDictionary.containsTerm(tokenAnnotation.getCoveredText())) {
            UIMAFramework.getLogger().log(Level.INFO, new StringBuffer("found beneficiary token: ").append(tokenAnnotation.getCoveredText()).toString());
            i++;
          }
        }
        if (i > 0) {
          candidates.add(sentence);
        }
      }
    }
    // choose the candidate that does not have "too many" occurencies of the words in the terms
    // dictionary
    String beneficiary = null;
    if (candidates.size() > 1) {
      UIMAFramework.getLogger().log(Level.INFO, new StringBuffer("choosing between beneficiary candidates (").append(candidates.size()).append(")").toString());
      beneficiary = chooseBetweenCandidates(candidates);
    } else if (candidates.size() == 1) {
      beneficiary = candidates.get(0).getCoveredText();
    } else {
      // do nothing
    }
    return beneficiary;
  }

  /**
   * @param candidates
   * @return
   */
  private String chooseBetweenCandidates(List<SentenceAnnotation> candidates) {
    String beneficiary = null;

    //choose the greatest one
    int maxLength = 0;
    for (SentenceAnnotation sentenceAnnotation : candidates) {
      if (sentenceAnnotation.getCoveredText().length() > maxLength) {
        maxLength = sentenceAnnotation.getCoveredText().length();
        beneficiary = sentenceAnnotation.getCoveredText();
      }

    }
    return beneficiary;
  }
}
