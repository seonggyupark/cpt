package cybion.expiration_date_annotator.dictionary;

import cybion.annotator_utils.TermsDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tommaso
 */
public class EDItalianTermsDictionary implements TermsDictionary {

  private final static List<String> terms = new ArrayList<String>();

  public EDItalianTermsDictionary() {
    terms.add("pervenire");
    terms.add("scadenza");
    terms.add("Scadenza");
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
