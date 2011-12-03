package cybion.activity_annotator.dictionary;

import java.util.ArrayList;
import java.util.List;

import cybion.annotator_utils.TermsDictionary;

public class ActivityEnglishDictionary implements TermsDictionary {

  private final static List<String> terms = new ArrayList<String>();

  public ActivityEnglishDictionary() {
    terms.add("activity");
    terms.add("Activity");
    terms.add("activities");
    terms.add("Activities");
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
