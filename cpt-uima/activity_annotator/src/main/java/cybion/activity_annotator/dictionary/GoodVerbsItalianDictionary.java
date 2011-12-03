package cybion.activity_annotator.dictionary;

import cybion.annotator_utils.TermsDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tommaso
 */
public class GoodVerbsItalianDictionary implements TermsDictionary {

  private final static List<String> terms = new ArrayList<String>();

  public GoodVerbsItalianDictionary() {
    terms.add("bandisce");
    terms.add("bandiscono");
    terms.add("Bandisce");
    terms.add("Bandiscono");
  }

  public String getLanguage() {
    return "it";
  }

  public boolean containsTerm(String term) {
    return terms.contains(term);
  }

  public List<String> getDictionaryItems() {
    return terms;
  }
}
