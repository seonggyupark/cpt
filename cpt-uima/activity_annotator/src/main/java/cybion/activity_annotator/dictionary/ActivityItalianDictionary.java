package cybion.activity_annotator.dictionary;

import java.util.ArrayList;
import java.util.List;

import cybion.annotator_utils.TermsDictionary;

public class ActivityItalianDictionary implements TermsDictionary {
  
  private static final List<String> terms = new ArrayList<String>();
  
  public ActivityItalianDictionary() {
    terms.add("attivitˆ");
    terms.add("Attivitˆ");
    terms.add("Attivita");
    terms.add("attivita");
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
