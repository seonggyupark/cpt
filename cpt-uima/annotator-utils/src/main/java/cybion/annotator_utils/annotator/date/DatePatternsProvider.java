package cybion.annotator_utils.annotator.date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class DatePatternsProvider {

  private static Pattern italianNumeric = Pattern
          .compile("(0[1-9]|[1-9]|[12][0-9]|3[01])[-/](0[1-9]|1[012]|[1-9])[-/](19|20)\\d{2}");

  private static Pattern englishNumeric = Pattern
          .compile("(19|20)\\d{2}[-/](0[1-9]|1[012]|[1-9])[-/](0[1-9]|[1-9]|[12][0-9]|3[01])");

  private static Pattern ppsPattern = Pattern
          .compile("(lun|mar|mer|gio|ven|sab|dom)\\s(1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31)\\s(Gen|Feb|Mar|Apr|Mag|Giu|Lug|Ago|Set|Ott|Nov|Dic)");

  private static Pattern secondPattern = Pattern
          .compile("\\d{0,2}(st|nd){0,1}\\s*\\,{0,1}\\.{0,1}\\s*("
                  + "(j|J)anuary|(f|F)ebruary|(m|M)arch|(a|A)pril|(m|M)ay|(j|J)une|(j|J)uly|(a|A)ugust|(s|S)eptember|(o|O)ctober|(n|N)ovember|(d|D)ecember|"
                  + "(g|G)ennaio|(f|F)ebbraio|(m|M)arzo|(a|A)prile|(m|M)aggio|(g|G)iugno|(l|L)uglio|(a|A)gosto|(s|S)ettembre|(o|O)ttobre|(n|N)ovembre|(d|D)icembre)\\s*\\,{0,1}\\.{0,1}\\s*\\d{4}");

  private static Pattern dotPatterns = Pattern.compile("\\d{1,2}\\.\\d{1,2}\\.\\d{4}");

  private static List<Pattern> patterns = new ArrayList<Pattern>();

  public static List<Pattern> getDatePatterns() {
    if (patterns.isEmpty()) {
      fillIt();
      patterns = Collections.unmodifiableList(patterns);
    }
    return patterns;
  }

  private static void fillIt() {
    patterns.add(italianNumeric);
    patterns.add(englishNumeric);
    patterns.add(ppsPattern);
    patterns.add(secondPattern);
    patterns.add(dotPatterns);

  }

}
