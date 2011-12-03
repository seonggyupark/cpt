package cybion.abstract_annotator.dictionary;

import java.util.ArrayList;
import java.util.List;

import cybion.annotator_utils.TermsDictionary;

public class AbstractItalianDictionary implements TermsDictionary {

  private static final String LANGUAGE = "it";

  private List<String> terms = new ArrayList<String>();

  public AbstractItalianDictionary() {
    terms.add("Obiettivo");
    terms.add("Obiettivi");
    terms.add("Obbiettivo");
    terms.add("Obbiettivi");
    terms.add("obbiettivo");
    terms.add("obbiettivi");
    terms.add("obiettivo");
    terms.add("obiettivi");
    terms.add("OBIETTIVO");
    terms.add("OBIETTIVI");
    terms.add("OBBIETTIVO");
    terms.add("OBBIETTIVI");
    terms.add("abstract");
    terms.add("Abstract");
    terms.add("introduzione");
    terms.add("Introduzione");
    terms.add("bandisce");
    terms.add("bandiscono");
  }

  public boolean containsTerm(String term) {
    return terms.contains(term);
  }

  public String getLanguage() {
    return LANGUAGE;
  }

  public List<String> getDictionaryItems() {
    return terms;
  }

}
