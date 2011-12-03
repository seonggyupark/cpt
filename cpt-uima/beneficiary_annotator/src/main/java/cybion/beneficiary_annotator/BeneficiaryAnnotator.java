package cybion.beneficiary_annotator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.uima.UimaContext;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.annotator.CybionAbstractAnnotator;
import cybion.uima.ts.BandoEntity;

public class BeneficiaryAnnotator extends CybionAbstractAnnotator {

  private DictionaryBeneficiaryRetriever dictionaryBeneficiaryRetriever;

  private StructureBeneficiaryRetriever structureBeneficiaryRetriever;

  private final static String EMPTY_STRING = "";

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    this.dictionaryBeneficiaryRetriever = new DictionaryBeneficiaryRetriever();
    this.structureBeneficiaryRetriever = new StructureBeneficiaryRetriever();
    super.initialize(aContext);

  }

  @Override
  public void extractWithCustomAlgorithm(JCas aJCas) {

    Set<String> beneficiaryCandidates = new HashSet<String>(2);

    // try to get the beneficiary using a dictionary of terms (depending on the documentLanguage)
    String beneficiaryFromDictionary = dictionaryBeneficiaryRetriever.getBeneficiary(aJCas);
    if (beneficiaryFromDictionary != null && !EMPTY_STRING.equals(beneficiaryFromDictionary))
      beneficiaryCandidates.add(beneficiaryFromDictionary);

    // try to get the beneficiary using a set of predefined structures
    String beneficiaryFromStructure = this.structureBeneficiaryRetriever.getBeneficiary(aJCas);
    if (beneficiaryFromStructure != null && !EMPTY_STRING.equals(beneficiaryFromStructure))
      beneficiaryCandidates.add(beneficiaryFromStructure);

    String beneficiary = null;

    // choose between the found beneficiaries
    beneficiary = chooseBetweenBeneficiaries(beneficiaryCandidates);

    if (beneficiary != null) {
      setBeneficiary(aJCas, beneficiary);
    }
  }

  /**
   * 
   * @param beneficiaryCandidates
   * @return
   */
  private String chooseBetweenBeneficiaries(Set<String> beneficiaryCandidates) {
    String beneficiary = null;
    if (beneficiaryCandidates.size() == 1) {
      beneficiary = beneficiaryCandidates.iterator().next();
    } else if (beneficiaryCandidates.size() > 1) {
      this.getContext().getLogger().log(
              Level.INFO,
              new StringBuffer("found ").append(beneficiaryCandidates.size()).append(
                      " beneficiaries").toString());
      StringBuffer compositeBeneficiary = new StringBuffer("");
      for (String foundBeneficiary : beneficiaryCandidates) {
        compositeBeneficiary.append(foundBeneficiary).append("...\n");
      }
      beneficiary = compositeBeneficiary.toString();
    }
    return beneficiary;
  }

  private void setBeneficiary(JCas aJCas, String beneficiary) {
    BandoEntity bandoEntity = AnnotatorUtils.getBandoEntityWithCreation(aJCas);
    bandoEntity.setBeneficiary(beneficiary);
  }

  @Override
  protected Feature getFeature(JCas cas) throws CASException {
    return cas.getRequiredFeature(cas.getCasType(BandoEntity.type), "beneficiary");
  }

  @Override
  protected String[] getFeatureKeys(String language) {
    List<String> dictionaryItems = this.dictionaryBeneficiaryRetriever.getDictionaryProvider()
            .getDictionary(language).getDictionaryItems();
    return dictionaryItems.toArray(new String[dictionaryItems.size()]);
  }

}
