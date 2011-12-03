package cybion.beneficiary_annotator;

import org.apache.uima.jcas.JCas;

/**
 * @author tommaso
 */
public interface BeneficiaryRetriever {
  public String getBeneficiary(JCas cas);
}
