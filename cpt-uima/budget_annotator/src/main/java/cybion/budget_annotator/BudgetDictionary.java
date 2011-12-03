package cybion.budget_annotator;

import java.util.ArrayList;
import java.util.List;

import cybion.annotator_utils.TermsDictionary;

public class BudgetDictionary implements TermsDictionary {

  private String language;

  private static List<String> terms = new ArrayList<String>();

  public BudgetDictionary(String language) {
    this.language = language;
    terms.add("pound");
    terms.add("euro");
    terms.add("lira");
    terms.add("lire");
    terms.add("dollar");
    terms.add("yen");
    terms.add("award");
    terms.add("budget");
  }

  public boolean containsTerm(String term) {
    return terms.contains(term);
  }

  public List<String> getDictionaryItems() {
    return terms;
  }

  public String getLanguage() {
    return this.language;
  }

}
