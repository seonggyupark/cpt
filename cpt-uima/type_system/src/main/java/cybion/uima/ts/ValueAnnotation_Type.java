/* First created by JCasGen Mon Mar 01 19:28:02 CET 2010 */
package cybion.uima.ts;

import org.apache.uima.cas.Feature;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.tcas.Annotation_Type;

/**
 * Updated by JCasGen Sun May 16 14:13:04 CEST 2010
 *
 * @generated
 */
public class ValueAnnotation_Type extends Annotation_Type {
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
              if (ValueAnnotation_Type.this.useExistingInstance) {
                // Return eq fs instance if already created
                FeatureStructure fs = ValueAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
                if (null == fs) {
                  fs = new ValueAnnotation(addr, ValueAnnotation_Type.this);
                  ValueAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
                  return fs;
                }
                return fs;
              } else return new ValueAnnotation(addr, ValueAnnotation_Type.this);
            }
          };
  /**
   * @generated
   */
  public final static int typeIndexID = ValueAnnotation.typeIndexID;
  /**
   * @generated
   * @modifiable
   */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cybion.uima.ts.ValueAnnotation");

  /**
   * @generated
   */
  final Feature casFeat_value;
  /**
   * @generated
   */
  final int casFeatCode_value;

  /**
   * @generated
   */
  public String getValue(int addr) {
    if (featOkTst && casFeat_value == null)
      jcas.throwFeatMissing("value", "cybion.uima.ts.ValueAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_value);
  }

  /**
   * @generated
   */
  public void setValue(int addr, String v) {
    if (featOkTst && casFeat_value == null)
      jcas.throwFeatMissing("value", "cybion.uima.ts.ValueAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_value, v);
  }


  /**
   * initialize variables to correspond with Cas Type and Features
   *
   * @generated
   */
  public ValueAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl) this.casType, getFSGenerator());


    casFeat_value = jcas.getRequiredFeatureDE(casType, "value", "uima.cas.String", featOkTst);
    casFeatCode_value = (null == casFeat_value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_value).getCode();

  }
}



    