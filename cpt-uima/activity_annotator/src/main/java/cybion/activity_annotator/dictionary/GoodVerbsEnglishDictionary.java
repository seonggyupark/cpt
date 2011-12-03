package cybion.activity_annotator.dictionary;

import cybion.annotator_utils.TermsDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tommaso
 */
public class GoodVerbsEnglishDictionary implements TermsDictionary {

  private final static List<String> terms = new ArrayList<String>();

  public GoodVerbsEnglishDictionary() {
    terms.add("offer");
    terms.add("offers");
    terms.add("promote");
  }

  public String getLanguage() {
    return "en";
  }

  public boolean containsTerm(String term) {
    return terms.contains(term);
  }

  public List<String> getDictionaryItems() {
    return terms;
  }
}
