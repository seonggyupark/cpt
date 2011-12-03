package cybion.beneficiary_annotator.dictionary;

import java.util.ArrayList;
import java.util.List;

import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.TermsDictionary;

public class BeneficiaryDictionaryProvider implements DictionaryProvider {
  private List<TermsDictionary> supportedDictionaries = new ArrayList<TermsDictionary>();

  public BeneficiaryDictionaryProvider() {
    supportedDictionaries.add(new BeneficiaryItalianDictionary());
    supportedDictionaries.add(new BeneficiaryEnglishDictionary());
  }

  public TermsDictionary getDictionary(String language) {
    TermsDictionary termsDictionary = null;
    for (TermsDictionary dictionary : supportedDictionaries) {
      if (dictionary.getLanguage().equals(language)) {
        termsDictionary = dictionary;
        break;
      }
    }
    return termsDictionary;

  }
}
