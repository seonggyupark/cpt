package cybion.uima.annotator.title;

import cybion.annotator_utils.TermsDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tommaso
 * @version $Id: TitleDictionary.java 720 2010-07-02 10:51:35Z teofili $
 */
public class TitleDictionary implements TermsDictionary {
  private static List<String> terms = new ArrayList<String>();

  public TitleDictionary() {
    terms.add("Identifier");
    terms.add("Title");
    terms.add("Titolo");
    terms.add("Titre");
    terms.add("Refrence de l'appel");
  }

  public boolean containsTerm(String term) {
    return terms.contains(term);
  }

  public String getLanguage() {
    return "*";
  }

  public List<String> getDictionaryItems() {
    return terms;
  }
}
