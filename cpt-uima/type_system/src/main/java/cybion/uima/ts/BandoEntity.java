/* First created by JCasGen Sat Nov 28 18:52:13 CET 2009 */
package cybion.uima.ts;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.TOP_Type;

/**
 * Updated by JCasGen Sun May 16 14:12:55 CEST 2010
 * XML source: /Users/tommaso/Documents/workspaces/tesi_ws/type_system/src/main/resources/CPT_TSDescriptor.xml
 *
 * @generated
 */
public class BandoEntity extends TOP {
  /**
   * @generated
   * @ordered
   */
  public final static int typeIndexID = JCasRegistry.register(BandoEntity.class);

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
  protected BandoEntity() {
  }

  /**
   * Internal - constructor used by generator
   *
   * @generated
   */
  public BandoEntity(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }

  /**
   * @generated
   */
  public BandoEntity(JCas jcas) {
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

  // *--------------*
  // * Feature: abstract

  /**
   * getter for abstract - gets
   *
   * @generated
   */
  public String getAbstract() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_abstract == null)
      jcasType.jcas.throwFeatMissing("abstract", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_abstract);
  }

  /**
   * setter for abstract - sets
   *
   * @generated
   */
  public void setAbstract(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_abstract == null)
      jcasType.jcas.throwFeatMissing("abstract", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_abstract, v);
  }


  // *--------------*
  // * Feature: activity

  /**
   * getter for activity - gets
   *
   * @generated
   */
  public String getActivity() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_activity == null)
      jcasType.jcas.throwFeatMissing("activity", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_activity);
  }

  /**
   * setter for activity - sets
   *
   * @generated
   */
  public void setActivity(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_activity == null)
      jcasType.jcas.throwFeatMissing("activity", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_activity, v);
  }


  // *--------------*
  // * Feature: beneficiary

  /**
   * getter for beneficiary - gets
   *
   * @generated
   */
  public String getBeneficiary() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_beneficiary == null)
      jcasType.jcas.throwFeatMissing("beneficiary", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_beneficiary);
  }

  /**
   * setter for beneficiary - sets
   *
   * @generated
   */
  public void setBeneficiary(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_beneficiary == null)
      jcasType.jcas.throwFeatMissing("beneficiary", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_beneficiary, v);
  }


  // *--------------*
  // * Feature: budget

  /**
   * getter for budget - gets
   *
   * @generated
   */
  public String getBudget() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_budget == null)
      jcasType.jcas.throwFeatMissing("budget", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_budget);
  }

  /**
   * setter for budget - sets
   *
   * @generated
   */
  public void setBudget(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_budget == null)
      jcasType.jcas.throwFeatMissing("budget", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_budget, v);
  }


  // *--------------*
  // * Feature: companies

  /**
   * getter for companies - gets
   *
   * @generated
   */
  public StringList getCompanies() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_companies == null)
      jcasType.jcas.throwFeatMissing("companies", "cybion.uima.ts.BandoEntity");
    return (StringList) (jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_companies)));
  }

  /**
   * setter for companies - sets
   *
   * @generated
   */
  public void setCompanies(StringList v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_companies == null)
      jcasType.jcas.throwFeatMissing("companies", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setRefValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_companies, jcasType.ll_cas.ll_getFSRef(v));
  }


  // *--------------*
  // * Feature: expirationDate

  /**
   * getter for expirationDate - gets
   *
   * @generated
   */
  public String getExpirationDate() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_expirationDate == null)
      jcasType.jcas.throwFeatMissing("expirationDate", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_expirationDate);
  }

  /**
   * setter for expirationDate - sets
   *
   * @generated
   */
  public void setExpirationDate(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_expirationDate == null)
      jcasType.jcas.throwFeatMissing("expirationDate", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_expirationDate, v);
  }


  // *--------------*
  // * Feature: fundingPercentage

  /**
   * getter for fundingPercentage - gets
   *
   * @generated
   */
  public String getFundingPercentage() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_fundingPercentage == null)
      jcasType.jcas.throwFeatMissing("fundingPercentage", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_fundingPercentage);
  }

  /**
   * setter for fundingPercentage - sets
   *
   * @generated
   */
  public void setFundingPercentage(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_fundingPercentage == null)
      jcasType.jcas.throwFeatMissing("fundingPercentage", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_fundingPercentage, v);
  }


  // *--------------*
  // * Feature: fundingType

  /**
   * getter for fundingType - gets
   *
   * @generated
   */
  public String getFundingType() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_fundingType == null)
      jcasType.jcas.throwFeatMissing("fundingType", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_fundingType);
  }

  /**
   * setter for fundingType - sets
   *
   * @generated
   */
  public void setFundingType(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_fundingType == null)
      jcasType.jcas.throwFeatMissing("fundingType", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_fundingType, v);
  }


  // *--------------*
  // * Feature: geographicRegion

  /**
   * getter for geographicRegion - gets
   *
   * @generated
   */
  public String getGeographicRegion() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_geographicRegion == null)
      jcasType.jcas.throwFeatMissing("geographicRegion", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_geographicRegion);
  }

  /**
   * setter for geographicRegion - sets
   *
   * @generated
   */
  public void setGeographicRegion(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_geographicRegion == null)
      jcasType.jcas.throwFeatMissing("geographicRegion", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_geographicRegion, v);
  }


  // *--------------*
  // * Feature: language

  /**
   * getter for language - gets
   *
   * @generated
   */
  public String getLanguage() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_language == null)
      jcasType.jcas.throwFeatMissing("language", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_language);
  }

  /**
   * setter for language - sets
   *
   * @generated
   */
  public void setLanguage(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_language == null)
      jcasType.jcas.throwFeatMissing("language", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_language, v);
  }


  // *--------------*
  // * Feature: leafLink

  /**
   * getter for leafLink - gets
   *
   * @generated
   */
  public String getLeafLink() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_leafLink == null)
      jcasType.jcas.throwFeatMissing("leafLink", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_leafLink);
  }

  /**
   * setter for leafLink - sets
   *
   * @generated
   */
  public void setLeafLink(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_leafLink == null)
      jcasType.jcas.throwFeatMissing("leafLink", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_leafLink, v);
  }


  // *--------------*
  // * Feature: notes

  /**
   * getter for notes - gets
   *
   * @generated
   */
  public String getNotes() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_notes == null)
      jcasType.jcas.throwFeatMissing("notes", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_notes);
  }

  /**
   * setter for notes - sets
   *
   * @generated
   */
  public void setNotes(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_notes == null)
      jcasType.jcas.throwFeatMissing("notes", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_notes, v);
  }


  // *--------------*
  // * Feature: text

  /**
   * getter for text - gets
   *
   * @generated
   */
  public String getText() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_text);
  }

  /**
   * setter for text - sets
   *
   * @generated
   */
  public void setText(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_text, v);
  }


  // *--------------*
  // * Feature: sector

  /**
   * getter for sector - gets
   *
   * @generated
   */
  public String getSector() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_sector == null)
      jcasType.jcas.throwFeatMissing("sector", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_sector);
  }

  /**
   * setter for sector - sets
   *
   * @generated
   */
  public void setSector(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_sector == null)
      jcasType.jcas.throwFeatMissing("sector", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_sector, v);
  }


  // *--------------*
  // * Feature: subject

  /**
   * getter for subject - gets
   *
   * @generated
   */
  public String getSubject() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_subject);
  }

  /**
   * setter for subject - sets
   *
   * @generated
   */
  public void setSubject(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_subject, v);
  }


  // *--------------*
  // * Feature: tags

  /**
   * getter for tags - gets
   *
   * @generated
   */
  public StringList getTags() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_tags == null)
      jcasType.jcas.throwFeatMissing("tags", "cybion.uima.ts.BandoEntity");
    return (StringList) (jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_tags)));
  }

  /**
   * setter for tags - sets
   *
   * @generated
   */
  public void setTags(StringList v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_tags == null)
      jcasType.jcas.throwFeatMissing("tags", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setRefValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_tags, jcasType.ll_cas.ll_getFSRef(v));
  }


  // *--------------*
  // * Feature: title

  /**
   * getter for title - gets
   *
   * @generated
   */
  public String getTitle() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_title);
  }

  /**
   * setter for title - sets
   *
   * @generated
   */
  public void setTitle(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_title, v);
  }


  // *--------------*
  // * Feature: category

  /**
   * getter for category - gets
   *
   * @generated
   */
  public String getCategory() {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "cybion.uima.ts.BandoEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_category);
  }

  /**
   * setter for category - sets
   *
   * @generated
   */
  public void setCategory(String v) {
    if (BandoEntity_Type.featOkTst && ((BandoEntity_Type) jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "cybion.uima.ts.BandoEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((BandoEntity_Type) jcasType).casFeatCode_category, v);
  }
}
