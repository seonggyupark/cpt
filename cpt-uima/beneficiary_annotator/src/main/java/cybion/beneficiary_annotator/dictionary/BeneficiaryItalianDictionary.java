package cybion.beneficiary_annotator.dictionary;

import cybion.annotator_utils.TermsDictionary;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryItalianDictionary implements TermsDictionary {

  private static List<String> terms = new ArrayList<String>();
  
  public BeneficiaryItalianDictionary() {
    terms.add("Benefici");
    terms.add("benefici");
    terms.add("candidati");
    terms.add("candidato");
    terms.add("requisiti");
    terms.add("Requisiti");
    terms.add("Requisito");
    terms.add("Requisito");
  }
  
  public boolean containsTerm(String term) {
    return terms.contains(term);
  }

  public String getLanguage() {
    return "it";
  }

  public List<String> getDictionaryItems() {
    return terms;
  }
}
