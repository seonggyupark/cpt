package cybion.annotator_utils.annotator;

import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;

/**
 * given a key it builds a pattern that will match something like *key:*vaue* (caching existing ones)
 * 
 * @author tommaso
 */
public class SimpleStructurePatternProvider {

  private static final String VALUE_PART = "\\s*\\:{0,1}\\s*\\w{1,}\\s*\\r*\\n*";

  private static final String CASE_INSENSITIVE_DIRECTIVES = "(?u)(?i)";

  private Map<String, Pattern> patternCache = new HashMap<String, Pattern>();

  public Pattern buildPattern(String key) {
    Pattern correspondingPattern = patternCache.get(key);
    if (correspondingPattern == null) {
      correspondingPattern = Pattern.compile(new StringBuilder(CASE_INSENSITIVE_DIRECTIVES).append(
              "(").append(key).append(")").append(VALUE_PART).toString());
      patternCache.put(key, correspondingPattern);
    }
    return correspondingPattern;
  }
}
