package cybion.abstract_annotator.dictionary;

import java.util.ArrayList;
import java.util.List;

import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.TermsDictionary;

public class AbstractDictionaryProvider implements DictionaryProvider {
  private List<TermsDictionary> supportedDictionaries = new ArrayList<TermsDictionary>();
  
  public AbstractDictionaryProvider() {
    supportedDictionaries.add(new AbstractItalianDictionary());
    supportedDictionaries.add(new AbstractEnglishDictionary());
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
