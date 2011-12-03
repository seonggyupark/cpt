
/* First created by JCasGen Sun Jul 18 18:16:43 CEST 2010 */
package org.apache.uima;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;

/** 
 * Updated by JCasGen Sun Jul 18 18:16:43 CEST 2010
 * @generated */
public class EnglishDictionaryEntry_Type extends DictionaryEntry_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (EnglishDictionaryEntry_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = EnglishDictionaryEntry_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new EnglishDictionaryEntry(addr, EnglishDictionaryEntry_Type.this);
  			   EnglishDictionaryEntry_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new EnglishDictionaryEntry(addr, EnglishDictionaryEntry_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = EnglishDictionaryEntry.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.apache.uima.EnglishDictionaryEntry");



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public EnglishDictionaryEntry_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

  }
}



    