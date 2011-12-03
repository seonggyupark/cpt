package cybion.annotator_utils;

import java.util.List;

public interface TermsDictionary {
  
  public String getLanguage();
  
  public boolean containsTerm(String term);
  
  public List<String> getDictionaryItems();

}
