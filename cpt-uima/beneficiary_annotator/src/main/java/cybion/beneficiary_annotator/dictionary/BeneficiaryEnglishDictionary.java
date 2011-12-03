package cybion.beneficiary_annotator.dictionary;

import java.util.ArrayList;
import java.util.List;

import cybion.annotator_utils.TermsDictionary;

public class BeneficiaryEnglishDictionary implements TermsDictionary {

  private static List<String> terms = new ArrayList<String>();
  
  public BeneficiaryEnglishDictionary() {
    terms.add("target");
    terms.add("Target");
  }
  
  public boolean containsTerm(String term) {
    return terms.contains(term);
  }

  public String getLanguage() {
    return "en";
  }

  public List<String> getDictionaryItems() {
    return terms;
  }
}
