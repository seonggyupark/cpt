/* First created by JCasGen Sat Nov 28 18:52:13 CET 2009 */
package org.apache.uima.jcas.cas;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;

/**
 * Updated by JCasGen Sun May 16 14:13:05 CEST 2010
 * XML source: /Users/tommaso/Documents/workspaces/tesi_ws/type_system/src/main/resources/CPT_TSDescriptor.xml
 *
 * @generated
 */
public class Entity extends TOP {
  /**
   * @generated
   * @ordered
   */
  public final static int typeIndexID = JCasRegistry.register(Entity.class);

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
  protected Entity() {
  }

  /**
   * Internal - constructor used by generator
   *
   * @generated
   */
  public Entity(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }

  /**
   * @generated
   */
  public Entity(JCas jcas) {
    super(jcas);
    readObject();
  }

  /**
   * <!-- begin-user-doc --> Write your own initialization here <!-- end-user-doc -->
   *
   * @generated modifiable
   */
  private void readObject() {
  }

  //*--------------*
  //* Feature: occurrencies

  /**
   * getter for occurrencies - gets
   *
   * @generated
   */
  public FSArray getOccurrencies() {
    if (Entity_Type.featOkTst && ((Entity_Type) jcasType).casFeat_occurrencies == null)
      jcasType.jcas.throwFeatMissing("occurrencies", "org.apache.uima.jcas.cas.Entity");
    return (FSArray) (jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Entity_Type) jcasType).casFeatCode_occurrencies)));
  }

  /**
   * setter for occurrencies - sets
   *
   * @generated
   */
  public void setOccurrencies(FSArray v) {
    if (Entity_Type.featOkTst && ((Entity_Type) jcasType).casFeat_occurrencies == null)
      jcasType.jcas.throwFeatMissing("occurrencies", "org.apache.uima.jcas.cas.Entity");
    jcasType.ll_cas.ll_setRefValue(addr, ((Entity_Type) jcasType).casFeatCode_occurrencies, jcasType.ll_cas.ll_getFSRef(v));
  }

  /**
   * indexed getter for occurrencies - gets an indexed value -
   *
   * @generated
   */
  public TOP getOccurrencies(int i) {
    if (Entity_Type.featOkTst && ((Entity_Type) jcasType).casFeat_occurrencies == null)
      jcasType.jcas.throwFeatMissing("occurrencies", "org.apache.uima.jcas.cas.Entity");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Entity_Type) jcasType).casFeatCode_occurrencies), i);
    return (TOP) (jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Entity_Type) jcasType).casFeatCode_occurrencies), i)));
  }

  /**
   * indexed setter for occurrencies - sets an indexed value -
   *
   * @generated
   */
  public void setOccurrencies(int i, TOP v) {
    if (Entity_Type.featOkTst && ((Entity_Type) jcasType).casFeat_occurrencies == null)
      jcasType.jcas.throwFeatMissing("occurrencies", "org.apache.uima.jcas.cas.Entity");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Entity_Type) jcasType).casFeatCode_occurrencies), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Entity_Type) jcasType).casFeatCode_occurrencies), i, jcasType.ll_cas.ll_getFSRef(v));
  }


  // *--------------*
  // * Feature: text

  /**
   * getter for text - gets
   *
   * @generated
   */
  public String getText() {
    if (Entity_Type.featOkTst && ((Entity_Type) jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.apache.uima.jcas.cas.Entity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Entity_Type) jcasType).casFeatCode_text);
  }

  /**
   * setter for text - sets
   *
   * @generated
   */
  public void setText(String v) {
    if (Entity_Type.featOkTst && ((Entity_Type) jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.apache.uima.jcas.cas.Entity");
    jcasType.ll_cas.ll_setStringValue(addr, ((Entity_Type) jcasType).casFeatCode_text, v);
  }
}
