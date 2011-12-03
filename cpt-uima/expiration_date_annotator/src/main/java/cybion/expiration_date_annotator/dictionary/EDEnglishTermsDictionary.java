package cybion.expiration_date_annotator.dictionary;

import cybion.annotator_utils.TermsDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tommaso
 */
public class EDEnglishTermsDictionary implements TermsDictionary {

  private final static List<String> terms = new ArrayList<String>();

  public EDEnglishTermsDictionary() {
    terms.add("receipt");
    terms.add("deadline");
    terms.add("Deadline");
    terms.add("Expire");
    terms.add("expire");
    terms.add("expiration");
    terms.add("Expiration");
    terms.add("expires");
    terms.add("Expires");

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
