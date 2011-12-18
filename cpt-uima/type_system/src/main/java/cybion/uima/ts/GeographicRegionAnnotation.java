/* First created by JCasGen Sat Nov 28 18:52:13 CET 2009 */
package cybion.uima.ts;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;
import org.apache.uima.jcas.tcas.Annotation;

/**
 * Updated by JCasGen Sun May 16 14:13:01 CEST 2010
 * XML source: /Users/tommaso/Documents/workspaces/tesi_ws/type_system/src/main/resources/CPT_TSDescriptor.xml
 *
 * @generated
 */
public class GeographicRegionAnnotation extends Annotation {
  /**
   * @generated
   * @ordered
   */
  public final static int typeIndexID = JCasRegistry.register(GeographicRegionAnnotation.class);

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
  protected GeographicRegionAnnotation() {
  }

  /**
   * Internal - constructor used by generator
   *
   * @generated
   */
  public GeographicRegionAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }

  /**
   * @generated
   */
  public GeographicRegionAnnotation(JCas jcas) {
    super(jcas);
    readObject();
  }

  /**
   * @generated
   */
  public GeographicRegionAnnotation(JCas jcas, int begin, int end) {
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