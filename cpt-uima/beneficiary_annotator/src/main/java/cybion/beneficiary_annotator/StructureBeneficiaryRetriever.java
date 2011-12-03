package cybion.beneficiary_annotator;

import org.apache.uima.SentenceAnnotation;
import org.apache.uima.UIMAFramework;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.util.Level;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tommaso
 */
public class StructureBeneficiaryRetriever implements BeneficiaryRetriever {

  private static final String EN_OFFERING_STRUCTURE = ".*(offer|offered).*(to).*";
  private static final String IT_OFFERING_STRUCTURE = ".*(offre|offriamo|offrono).*(a).*";

  public String getBeneficiary(JCas cas) {
    StringBuffer beneficiary = new StringBuffer();

    for (Annotation sentenceAnnotation : cas.getAnnotationIndex(SentenceAnnotation.type)) {
      SentenceAnnotation sentence = (SentenceAnnotation) sentenceAnnotation;
      try {
        Pattern offeringPattern = Pattern.compile(getPatternStringFromLanguage(cas.getDocumentLanguage()));
        Matcher matcher = offeringPattern.matcher(sentence.getCoveredText());
        if (matcher.find(0)) {
          UIMAFramework.getLogger().log(Level.INFO, new StringBuffer("found a beneficiary: ").append(sentence.getCoveredText()).toString());
          beneficiary.append(sentence.getCoveredText()).append("\n");
        }

      } catch (Exception e) {
        // do nothing
      }

    }


    return beneficiary.toString();
  }

  private String getPatternStringFromLanguage(String language) {
    if (language.equals("en"))
      return EN_OFFERING_STRUCTURE;
    else if (language.equals("it"))
      return IT_OFFERING_STRUCTURE;
    else
      throw new RuntimeException("unsupported language");
  }
}
