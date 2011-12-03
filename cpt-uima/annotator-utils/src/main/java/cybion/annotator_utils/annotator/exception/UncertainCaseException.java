package cybion.annotator_utils.annotator.exception;

/**
 * Exception risen when annotators don't know what to do
 * @author tommaso
 *
 */
public class UncertainCaseException extends Exception {

  private static final long serialVersionUID = 1L;

  public UncertainCaseException(String message) {
    super(message);
  }

}
