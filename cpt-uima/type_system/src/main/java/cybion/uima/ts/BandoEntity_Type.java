/* First created by JCasGen Sat Nov 28 18:52:13 CET 2009 */
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
import org.apache.uima.jcas.cas.TOP_Type;

/**
 * Updated by JCasGen Sun May 16 14:12:58 CEST 2010
 *
 * @generated
 */
public class BandoEntity_Type extends TOP_Type {
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
              if (BandoEntity_Type.this.useExistingInstance) {
                // Return eq fs instance if already created
                FeatureStructure fs = BandoEntity_Type.this.jcas.getJfsFromCaddr(addr);
                if (null == fs) {
                  fs = new BandoEntity(addr, BandoEntity_Type.this);
                  BandoEntity_Type.this.jcas.putJfsFromCaddr(addr, fs);
                  return fs;
                }
                return fs;
              } else return new BandoEntity(addr, BandoEntity_Type.this);
            }
          };

  /**
   * @generated
   */
  public final static int typeIndexID = BandoEntity.typeIndexID;

  /**
   * @generated
   * @modifiable
   */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cybion.uima.ts.BandoEntity");

  /**
   * @generated
   */
  final Feature casFeat_abstract;

  /**
   * @generated
   */
  final int casFeatCode_abstract;

  /**
   * @generated
   */
  public String getAbstract(int addr) {
    if (featOkTst && casFeat_abstract == null)
      jcas.throwFeatMissing("abstract", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_abstract);
  }

  /**
   * @generated
   */
  public void setAbstract(int addr, String v) {
    if (featOkTst && casFeat_abstract == null)
      jcas.throwFeatMissing("abstract", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_abstract, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_activity;

  /**
   * @generated
   */
  final int casFeatCode_activity;

  /**
   * @generated
   */
  public String getActivity(int addr) {
    if (featOkTst && casFeat_activity == null)
      jcas.throwFeatMissing("activity", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_activity);
  }

  /**
   * @generated
   */
  public void setActivity(int addr, String v) {
    if (featOkTst && casFeat_activity == null)
      jcas.throwFeatMissing("activity", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_activity, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_beneficiary;

  /**
   * @generated
   */
  final int casFeatCode_beneficiary;

  /**
   * @generated
   */
  public String getBeneficiary(int addr) {
    if (featOkTst && casFeat_beneficiary == null)
      jcas.throwFeatMissing("beneficiary", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_beneficiary);
  }

  /**
   * @generated
   */
  public void setBeneficiary(int addr, String v) {
    if (featOkTst && casFeat_beneficiary == null)
      jcas.throwFeatMissing("beneficiary", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_beneficiary, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_budget;

  /**
   * @generated
   */
  final int casFeatCode_budget;

  /**
   * @generated
   */
  public String getBudget(int addr) {
    if (featOkTst && casFeat_budget == null)
      jcas.throwFeatMissing("budget", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_budget);
  }

  /**
   * @generated
   */
  public void setBudget(int addr, String v) {
    if (featOkTst && casFeat_budget == null)
      jcas.throwFeatMissing("budget", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_budget, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_companies;

  /**
   * @generated
   */
  final int casFeatCode_companies;

  /**
   * @generated
   */
  public int getCompanies(int addr) {
    if (featOkTst && casFeat_companies == null)
      jcas.throwFeatMissing("companies", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getRefValue(addr, casFeatCode_companies);
  }

  /**
   * @generated
   */
  public void setCompanies(int addr, int v) {
    if (featOkTst && casFeat_companies == null)
      jcas.throwFeatMissing("companies", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setRefValue(addr, casFeatCode_companies, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_expirationDate;

  /**
   * @generated
   */
  final int casFeatCode_expirationDate;

  /**
   * @generated
   */
  public String getExpirationDate(int addr) {
    if (featOkTst && casFeat_expirationDate == null)
      jcas.throwFeatMissing("expirationDate", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_expirationDate);
  }

  /**
   * @generated
   */
  public void setExpirationDate(int addr, String v) {
    if (featOkTst && casFeat_expirationDate == null)
      jcas.throwFeatMissing("expirationDate", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_expirationDate, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_fundingPercentage;

  /**
   * @generated
   */
  final int casFeatCode_fundingPercentage;

  /**
   * @generated
   */
  public String getFundingPercentage(int addr) {
    if (featOkTst && casFeat_fundingPercentage == null)
      jcas.throwFeatMissing("fundingPercentage", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_fundingPercentage);
  }

  /**
   * @generated
   */
  public void setFundingPercentage(int addr, String v) {
    if (featOkTst && casFeat_fundingPercentage == null)
      jcas.throwFeatMissing("fundingPercentage", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_fundingPercentage, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_fundingType;

  /**
   * @generated
   */
  final int casFeatCode_fundingType;

  /**
   * @generated
   */
  public String getFundingType(int addr) {
    if (featOkTst && casFeat_fundingType == null)
      jcas.throwFeatMissing("fundingType", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_fundingType);
  }

  /**
   * @generated
   */
  public void setFundingType(int addr, String v) {
    if (featOkTst && casFeat_fundingType == null)
      jcas.throwFeatMissing("fundingType", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_fundingType, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_geographicRegion;

  /**
   * @generated
   */
  final int casFeatCode_geographicRegion;

  /**
   * @generated
   */
  public String getGeographicRegion(int addr) {
    if (featOkTst && casFeat_geographicRegion == null)
      jcas.throwFeatMissing("geographicRegion", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geographicRegion);
  }

  /**
   * @generated
   */
  public void setGeographicRegion(int addr, String v) {
    if (featOkTst && casFeat_geographicRegion == null)
      jcas.throwFeatMissing("geographicRegion", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_geographicRegion, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_language;

  /**
   * @generated
   */
  final int casFeatCode_language;

  /**
   * @generated
   */
  public String getLanguage(int addr) {
    if (featOkTst && casFeat_language == null)
      jcas.throwFeatMissing("language", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_language);
  }

  /**
   * @generated
   */
  public void setLanguage(int addr, String v) {
    if (featOkTst && casFeat_language == null)
      jcas.throwFeatMissing("language", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_language, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_leafLink;

  /**
   * @generated
   */
  final int casFeatCode_leafLink;

  /**
   * @generated
   */
  public String getLeafLink(int addr) {
    if (featOkTst && casFeat_leafLink == null)
      jcas.throwFeatMissing("leafLink", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_leafLink);
  }

  /**
   * @generated
   */
  public void setLeafLink(int addr, String v) {
    if (featOkTst && casFeat_leafLink == null)
      jcas.throwFeatMissing("leafLink", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_leafLink, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_notes;

  /**
   * @generated
   */
  final int casFeatCode_notes;

  /**
   * @generated
   */
  public String getNotes(int addr) {
    if (featOkTst && casFeat_notes == null)
      jcas.throwFeatMissing("notes", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_notes);
  }

  /**
   * @generated
   */
  public void setNotes(int addr, String v) {
    if (featOkTst && casFeat_notes == null)
      jcas.throwFeatMissing("notes", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_notes, v);
  }


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
      jcas.throwFeatMissing("text", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }

  /**
   * @generated
   */
  public void setText(int addr, String v) {
    if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_sector;

  /**
   * @generated
   */
  final int casFeatCode_sector;

  /**
   * @generated
   */
  public String getSector(int addr) {
    if (featOkTst && casFeat_sector == null)
      jcas.throwFeatMissing("sector", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sector);
  }

  /**
   * @generated
   */
  public void setSector(int addr, String v) {
    if (featOkTst && casFeat_sector == null)
      jcas.throwFeatMissing("sector", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_sector, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_subject;

  /**
   * @generated
   */
  final int casFeatCode_subject;

  /**
   * @generated
   */
  public String getSubject(int addr) {
    if (featOkTst && casFeat_subject == null)
      jcas.throwFeatMissing("subject", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_subject);
  }

  /**
   * @generated
   */
  public void setSubject(int addr, String v) {
    if (featOkTst && casFeat_subject == null)
      jcas.throwFeatMissing("subject", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_subject, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_tags;

  /**
   * @generated
   */
  final int casFeatCode_tags;

  /**
   * @generated
   */
  public int getTags(int addr) {
    if (featOkTst && casFeat_tags == null)
      jcas.throwFeatMissing("tags", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getRefValue(addr, casFeatCode_tags);
  }

  /**
   * @generated
   */
  public void setTags(int addr, int v) {
    if (featOkTst && casFeat_tags == null)
      jcas.throwFeatMissing("tags", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setRefValue(addr, casFeatCode_tags, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_title;

  /**
   * @generated
   */
  final int casFeatCode_title;

  /**
   * @generated
   */
  public String getTitle(int addr) {
    if (featOkTst && casFeat_title == null)
      jcas.throwFeatMissing("title", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_title);
  }

  /**
   * @generated
   */
  public void setTitle(int addr, String v) {
    if (featOkTst && casFeat_title == null)
      jcas.throwFeatMissing("title", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_title, v);
  }


  /**
   * @generated
   */
  final Feature casFeat_category;

  /**
   * @generated
   */
  final int casFeatCode_category;

  /**
   * @generated
   */
  public String getCategory(int addr) {
    if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "cybion.uima.ts.BandoEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_category);
  }

  /**
   * @generated
   */
  public void setCategory(int addr, String v) {
    if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "cybion.uima.ts.BandoEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_category, v);
  }


  /**
   * initialize variables to correspond with Cas Type and Features
   *
   * @generated
   */
  public BandoEntity_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl) this.casType, getFSGenerator());


    casFeat_abstract = jcas.getRequiredFeatureDE(casType, "abstract", "uima.cas.String", featOkTst);
    casFeatCode_abstract = (null == casFeat_abstract) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_abstract).getCode();


    casFeat_activity = jcas.getRequiredFeatureDE(casType, "activity", "uima.cas.String", featOkTst);
    casFeatCode_activity = (null == casFeat_activity) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_activity).getCode();


    casFeat_beneficiary = jcas.getRequiredFeatureDE(casType, "beneficiary", "uima.cas.String", featOkTst);
    casFeatCode_beneficiary = (null == casFeat_beneficiary) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_beneficiary).getCode();


    casFeat_budget = jcas.getRequiredFeatureDE(casType, "budget", "uima.cas.String", featOkTst);
    casFeatCode_budget = (null == casFeat_budget) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_budget).getCode();


    casFeat_companies = jcas.getRequiredFeatureDE(casType, "companies", "uima.cas.StringList", featOkTst);
    casFeatCode_companies = (null == casFeat_companies) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_companies).getCode();


    casFeat_expirationDate = jcas.getRequiredFeatureDE(casType, "expirationDate", "uima.cas.String", featOkTst);
    casFeatCode_expirationDate = (null == casFeat_expirationDate) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_expirationDate).getCode();


    casFeat_fundingPercentage = jcas.getRequiredFeatureDE(casType, "fundingPercentage", "uima.cas.String", featOkTst);
    casFeatCode_fundingPercentage = (null == casFeat_fundingPercentage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_fundingPercentage).getCode();


    casFeat_fundingType = jcas.getRequiredFeatureDE(casType, "fundingType", "uima.cas.String", featOkTst);
    casFeatCode_fundingType = (null == casFeat_fundingType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_fundingType).getCode();


    casFeat_geographicRegion = jcas.getRequiredFeatureDE(casType, "geographicRegion", "uima.cas.String", featOkTst);
    casFeatCode_geographicRegion = (null == casFeat_geographicRegion) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_geographicRegion).getCode();


    casFeat_language = jcas.getRequiredFeatureDE(casType, "language", "uima.cas.String", featOkTst);
    casFeatCode_language = (null == casFeat_language) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_language).getCode();


    casFeat_leafLink = jcas.getRequiredFeatureDE(casType, "leafLink", "uima.cas.String", featOkTst);
    casFeatCode_leafLink = (null == casFeat_leafLink) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_leafLink).getCode();


    casFeat_notes = jcas.getRequiredFeatureDE(casType, "notes", "uima.cas.String", featOkTst);
    casFeatCode_notes = (null == casFeat_notes) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_notes).getCode();


    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_text).getCode();


    casFeat_sector = jcas.getRequiredFeatureDE(casType, "sector", "uima.cas.String", featOkTst);
    casFeatCode_sector = (null == casFeat_sector) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_sector).getCode();


    casFeat_subject = jcas.getRequiredFeatureDE(casType, "subject", "uima.cas.String", featOkTst);
    casFeatCode_subject = (null == casFeat_subject) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_subject).getCode();


    casFeat_tags = jcas.getRequiredFeatureDE(casType, "tags", "uima.cas.StringList", featOkTst);
    casFeatCode_tags = (null == casFeat_tags) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_tags).getCode();


    casFeat_title = jcas.getRequiredFeatureDE(casType, "title", "uima.cas.String", featOkTst);
    casFeatCode_title = (null == casFeat_title) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_title).getCode();


    casFeat_category = jcas.getRequiredFeatureDE(casType, "category", "uima.cas.String", featOkTst);
    casFeatCode_category = (null == casFeat_category) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_category).getCode();

  }
}
