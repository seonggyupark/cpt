/* First created by JCasGen Sun Feb 14 10:24:27 CET 2010 */
package cybion.annotator_utils.jcas.cas;

import org.apache.uima.cas.Feature;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

/**
 * Updated by JCasGen Sun May 16 14:12:53 CEST 2010
 *
 * @generated
 */
public class Entity_Type extends TOP_Type {
  /**
   * @generated
   */
  protected FSGenerator getFSGenerator() {
    return fsGenerator;
  }

  /**
   * @generated
   */
  private final FSGenerator fsGenerator =
          new FSGenerator() {
            public FeatureStructure createFS(int addr, CASImpl cas) {
              if (Entity_Type.this.useExistingInstance) {
                // Return eq fs instance if already created
                FeatureStructure fs = Entity_Type.this.jcas.getJfsFromCaddr(addr);
                if (null == fs) {
                  fs = new Entity(addr, Entity_Type.this);
                  Entity_Type.this.jcas.putJfsFromCaddr(addr, fs);
                  return fs;
                }
                return fs;
              } else return new Entity(addr, Entity_Type.this);
            }
          };
  /**
   * @generated
   */
  public final static int typeIndexID = Entity.typeIndexID;
  /**
   * @generated
   * @modifiable
   */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cybion.annotator_utils.jcas.cas.Entity");

  /**
   * @generated
   */
  final Feature casFeat_text;
  /**
   * @generated
   */
  final int casFeatCode_text;

  /**
   * @generated
   */
  public String getText(int addr) {
    if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "cybion.annotator_utils.jcas.cas.Entity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }

  /**
   * @generated
   */
  public void setText(int addr, String v) {
    if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "cybion.annotator_utils.jcas.cas.Entity");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_occurrencies;
  /**
   * @generated
   */
  final int casFeatCode_occurrencies;

  /**
   * @generated
   */
  public int getOccurrencies(int addr) {
    if (featOkTst && casFeat_occurrencies == null)
      jcas.throwFeatMissing("occurrencies", "cybion.annotator_utils.jcas.cas.Entity");
    return ll_cas.ll_getRefValue(addr, casFeatCode_occurrencies);
  }

  /**
   * @generated
   */
  public void setOccurrencies(int addr, int v) {
    if (featOkTst && casFeat_occurrencies == null)
      jcas.throwFeatMissing("occurrencies", "cybion.annotator_utils.jcas.cas.Entity");
    ll_cas.ll_setRefValue(addr, casFeatCode_occurrencies, v);
  }

  /**
   * @generated
   */
  public int getOccurrencies(int addr, int i) {
    if (featOkTst && casFeat_occurrencies == null)
      jcas.throwFeatMissing("occurrencies", "cybion.annotator_utils.jcas.cas.Entity");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_occurrencies), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_occurrencies), i);
    return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_occurrencies), i);
  }

  /**
   * @generated
   */
  public void setOccurrencies(int addr, int i, int v) {
    if (featOkTst && casFeat_occurrencies == null)
      jcas.throwFeatMissing("occurrencies", "cybion.annotator_utils.jcas.cas.Entity");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_occurrencies), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_occurrencies), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_occurrencies), i, v);
  }


  /**
   * initialize variables to correspond with Cas Type and Features
   *
   * @generated
   */
  public Entity_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl) this.casType, getFSGenerator());


    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_text).getCode();


    casFeat_occurrencies = jcas.getRequiredFeatureDE(casType, "occurrencies", "uima.cas.FSArray", featOkTst);
    casFeatCode_occurrencies = (null == casFeat_occurrencies) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_occurrencies).getCode();

  }
}



    