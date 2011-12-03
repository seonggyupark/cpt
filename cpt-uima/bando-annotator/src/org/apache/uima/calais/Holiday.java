

/* First created by JCasGen Fri Nov 28 11:44:22 CET 2008 */
package org.apache.uima.calais;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Mon Dec 15 00:14:26 CET 2008
 * XML source: /Users/tommaso/Documents/universita/tesi/uima_ws/BandoAnnotator/desc/BandoAEDescriptor.xml
 * @generated */
public class Holiday extends BaseType {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Holiday.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Holiday() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Holiday(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Holiday(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Holiday(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
}

    