/* First created by JCasGen Sun Dec 06 17:19:58 CET 2009 */
package cybion.uima.ts;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;
import org.apache.uima.jcas.tcas.Annotation;

/**
 * Updated by JCasGen Sun May 16 14:12:54 CEST 2010
 * XML source: /Users/tommaso/Documents/workspaces/tesi_ws/type_system/src/main/resources/CPT_TSDescriptor.xml
 *
 * @generated
 */
public class AbstractAnnotation extends Annotation {
  /**
   * @generated
   * @ordered
   */
  public final static int typeIndexID = JCasRegistry.register(AbstractAnnotation.class);

  /**
   * @generated
   * @ordered
   */
  public final static int type = typeIndexID;

  /**
   * @generated
   */
  public int getTypeIndexID() {
    return typeIndexID;
  }

  /**
   * Never called. Disable default constructor
   *
   * @generated
   */
  protected AbstractAnnotation() {
  }

  /**
   * Internal - constructor used by generator
   *
   * @generated
   */
  public AbstractAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }

  /**
   * @generated
   */
  public AbstractAnnotation(JCas jcas) {
    super(jcas);
    readObject();
  }

  /**
   * @generated
   */
  public AbstractAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }

  /**
   * <!-- begin-user-doc --> Write your own initialization here <!-- end-user-doc -->
   *
   * @generated modifiable
   */
  private void readObject() {
  }

}
