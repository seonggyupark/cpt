package cybion.abstract_annotator.dictionary;

import java.util.ArrayList;
import java.util.List;

import cybion.annotator_utils.TermsDictionary;

public class AbstractEnglishDictionary implements TermsDictionary {

  private static final String LANGUAGE = "en";
  
  private List<String> terms = new ArrayList<String>();
  
  public AbstractEnglishDictionary() {
    terms.add("SYNOPSIS");
    terms.add("synopsis");
    terms.add("Synopsis");
    terms.add("Abstract");
    terms.add("abstract");
    terms.add("Objective");
    terms.add("objective");
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
