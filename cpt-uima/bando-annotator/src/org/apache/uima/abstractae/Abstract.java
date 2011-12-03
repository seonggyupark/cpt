

/* First created by JCasGen Fri Dec 05 07:52:31 CET 2008 */
package org.apache.uima.abstractae;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Dec 05 07:52:31 CET 2008
 * XML source: /Users/tommaso/Documents/universita/tesi/uima_ws/BandoAnnotator/desc/AbstractAnnotatorAEDescriptor.xml
 * @generated */
public class Abstract extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Abstract.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Abstract() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Abstract(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Abstract(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Abstract(JCas jcas, int begin, int end) {
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

    