package cybion.activity_annotator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ActivityPatternProvider {

  private final Map<String, List<Pattern>> patterns;

  public ActivityPatternProvider() {
    patterns = new HashMap<String, List<Pattern>>();
    addPatterns();
  }

  private void addPatterns() {
    patterns.put("it", getActivityItalianPatterns());
    patterns.put("en", getActivityEnglishPatterns());
  }

  private List<Pattern> getActivityEnglishPatterns() {
    List<Pattern> enPatterns = new ArrayList<Pattern>();
    enPatterns.add(Pattern.compile("(?i)(?u).*(in order to).*(activity).*"));
    return enPatterns;
  }

  private List<Pattern> getActivityItalianPatterns() {
    List<Pattern> itPatterns = new ArrayList<Pattern>();
    itPatterns.add(Pattern.compile("(?i)(?u).*(per).*(sviluppo).*(di|del|della).*"));
    itPatterns.add(Pattern.compile("(?i)(?u).*(per).*(attivita|attività).*"));
    itPatterns.add(Pattern.compile("(?i)(?u).*(al fine di).*(attivita|attività).*"));
    return itPatterns;
  }

  public List<Pattern> getPatterns(String language) {
    return patterns.get(language);
  }

}
