/* First created by JCasGen Mon Mar 01 19:28:02 CET 2010 */
package cybion.uima.ts;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;
import org.apache.uima.jcas.tcas.Annotation;


/**
 * Updated by JCasGen Sun May 16 14:13:04 CEST 2010
 * XML source: /Users/tommaso/Documents/workspaces/tesi_ws/type_system/src/main/resources/CPT_TSDescriptor.xml
 *
 * @generated
 */
public class ValueAnnotation extends Annotation {
  /**
   * @generated
   * @ordered
   */
  public final static int typeIndexID = JCasRegistry.register(ValueAnnotation.class);
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
   * Never called.  Disable default constructor
   *
   * @generated
   */
  protected ValueAnnotation() {
  }

  /**
   * Internal - constructor used by generator
   *
   * @generated
   */
  public ValueAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }

  /**
   * @generated
   */
  public ValueAnnotation(JCas jcas) {
    super(jcas);
    readObject();
  }

  /**
   * @generated
   */
  public ValueAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }

  /**
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable
   */
  private void readObject() {
  }


  //*--------------*
  //* Feature: value

  /**
   * getter for value - gets
   *
   * @generated
   */
  public String getValue() {
    if (ValueAnnotation_Type.featOkTst && ((ValueAnnotation_Type) jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "cybion.uima.ts.ValueAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ValueAnnotation_Type) jcasType).casFeatCode_value);
  }

  /**
   * setter for value - sets
   *
   * @generated
   */
  public void setValue(String v) {
    if (ValueAnnotation_Type.featOkTst && ((ValueAnnotation_Type) jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "cybion.uima.ts.ValueAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((ValueAnnotation_Type) jcasType).casFeatCode_value, v);
  }
}

    