

/* First created by JCasGen Sun Jul 18 18:16:17 CEST 2010 */
package org.apache.uima;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Jul 18 18:16:43 CEST 2010
 * XML source: /Users/tommaso/Documents/workspaces/tesi_ws/language_annotator/desc/EnglishDictionaryDescriptor.xml
 * @generated */
public class DictionaryEntry extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(DictionaryEntry.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected DictionaryEntry() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DictionaryEntry(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DictionaryEntry(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DictionaryEntry(JCas jcas, int begin, int end) {
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

    