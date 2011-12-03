package cybion.sector_annotator;

import java.util.List;

import org.apache.uima.alchemy.ts.categorization.Category;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.uima.ts.BandoEntity;

public class SectorAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas cas) throws AnalysisEngineProcessException {

    // exploit alchemy-annotator categorization entity
    BandoEntity bando = AnnotatorUtils.getBandoEntityWithCreation(cas);
    List<FeatureStructure> categoryList = AnnotatorUtils.getAllFSofType(Category.type, cas);
    if (categoryList.size() > 1) {
      throw new RuntimeException("TOO MANY CATEGORIES IDENTIFIED!");
    }
    try {
      FeatureStructure categoryFS = categoryList.get(0);
      Type type = categoryFS.getType();
      bando.setCategory(categoryFS.getFeatureValueAsString(type.getFeatureByBaseName("text")));
    } catch (Exception e) {
      this.getContext().getLogger().log(Level.WARNING,"COULD NOT SET THE SECTOR OF THIS BANDO - "+e);
    }

  }

}
