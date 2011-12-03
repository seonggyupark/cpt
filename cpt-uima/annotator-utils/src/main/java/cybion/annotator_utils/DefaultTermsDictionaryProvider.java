package cybion.annotator_utils;

import java.util.List;

public class DefaultTermsDictionaryProvider implements DictionaryProvider {
  
  private List<TermsDictionary> supportedDictionaries;
  private static final String ALL = "*";

  public DefaultTermsDictionaryProvider(List<TermsDictionary> supportedDictionaries) {
    this.supportedDictionaries = supportedDictionaries;
  }

  public TermsDictionary getDictionary(String language) {
    TermsDictionary termsDictionary = null;
    for (TermsDictionary dictionary : supportedDictionaries) {
      if (dictionary.getLanguage().equals(language) || dictionary.getLanguage().equals(ALL)) {
        termsDictionary = dictionary;
        break;
      }
    }
    return termsDictionary;
  }

}
