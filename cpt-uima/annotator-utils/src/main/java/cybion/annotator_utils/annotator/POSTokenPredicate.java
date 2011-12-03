package cybion.annotator_utils.annotator;

import org.apache.commons.collections.Predicate;
import org.apache.uima.TokenAnnotation;

/**
 * @author tommaso
 */
public class POSTokenPredicate implements Predicate {
  private String pos;

    public POSTokenPredicate(String pos){
      this.pos = pos;
    }

    public boolean evaluate(Object object) {
      boolean isVerbToken = false;
      if (object instanceof TokenAnnotation) {
        String posTag = ((TokenAnnotation) object).getPosTag();
        if (posTag !=null && posTag.equals(this.pos)) {
          isVerbToken = true;
        }
      }
      return isVerbToken;
    }
}
