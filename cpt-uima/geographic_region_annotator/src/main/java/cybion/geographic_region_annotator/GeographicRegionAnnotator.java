package cybion.geographic_region_annotator;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.uima.ts.BandoEntity;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.util.Level;

import java.util.ArrayList;
import java.util.List;

public class GeographicRegionAnnotator extends JCasAnnotator_ImplBase {

  private static final String[] calaisGeoTypes = new String[] { "org.apache.uima.calais.Region",
      "org.apache.uima.calais.Country", "org.apache.uima.calais.Continent",
      "org.apache.uima.calais.ProviceOrState" };

  private static final String[] alchemyGeoTypes = new String[] {
      "org.apache.uima.alchemy.ts.entity.City", "org.apache.uima.alchemy.ts.entity.Continent",
      "org.apache.uima.alchemy.ts.entity.Country",
      "org.apache.uima.alchemy.ts.entity.GeographicFeature",
      "org.apache.uima.alchemy.ts.entity.Region", "org.apache.uima.alchemy.ts.entity.StateOrCounty" };

  private static final String SPACE = " ";

  public void process(JCas cas) throws AnalysisEngineProcessException {

    // get geographic annotations extracted by open calais service
    List<Annotation> calaisGeoAnnotations = getCalaisGeoAnnotations(cas);

    // get geographic annotations extracted by alchemyapi service
    List<FeatureStructure> alchemyGeoEntities = getAlchemyGeoEntities(cas);

    StringBuffer buffer = new StringBuffer();
    
    //add alchemy api entites to the geographic region
    try {
      for (FeatureStructure fs : alchemyGeoEntities) {
        buffer.append(fs.getFeatureValueAsString(cas.getRequiredFeature(fs.getType(), "text"))).append(SPACE);
      }
    } catch (Exception ae) {
      //do nothing
    }
    
    //add open calais covered text values to geographic region text
    try {
      for (Annotation openCalaisAnnotation : calaisGeoAnnotations) {
        buffer.append(openCalaisAnnotation.getCoveredText()).append(SPACE);
      }
    }
    catch (Exception oce) {
      //do nothing
    }
    
    
    //store value inside the bando entity
    String geo = buffer.toString();
    if (geo!=null && !"".equals(geo)) {
      BandoEntity bandoEntity;
      try {
        bandoEntity = AnnotatorUtils.getBandoEntity(cas);
      } catch (Exception e) {
        this.getContext().getLogger().log(Level.WARNING,"bandoEntity didn't exist, so now it's been created");
        bandoEntity = AnnotatorUtils.getBandoEntityWithCreation(cas);
      }
      bandoEntity.setGeographicRegion(geo);
    }
  }

  private List<FeatureStructure> getAlchemyGeoEntities(JCas cas) {
    List<FeatureStructure> geoAlchemyEntities = new ArrayList<FeatureStructure>();
    for (String alchemyTypeName : alchemyGeoTypes) {
      Type alchemyGeoType = cas.getTypeSystem().getType(alchemyTypeName);
      List<FeatureStructure> alchemyCurrentGeoEntities = AnnotatorUtils.getAllFSofType(
              alchemyGeoType, cas);
      geoAlchemyEntities.addAll(alchemyCurrentGeoEntities);
    }
    return geoAlchemyEntities;
  }

  private List<Annotation> getCalaisGeoAnnotations(JCas cas) {
    List<Annotation> geoCalaisAnnotations = new ArrayList<Annotation>();
    for (String calaisTypeName : calaisGeoTypes) {
      Type calaisGeoType = cas.getTypeSystem().getType(calaisTypeName);
      List<Annotation> calaisCurrentGeoAnnotations = AnnotatorUtils.getAnnotations(calaisGeoType,
              cas);
      geoCalaisAnnotations.addAll(calaisCurrentGeoAnnotations);
    }
    return geoCalaisAnnotations;
  }

}
