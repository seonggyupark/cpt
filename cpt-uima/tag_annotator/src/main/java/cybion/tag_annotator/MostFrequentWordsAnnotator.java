package cybion.tag_annotator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

/**
 * 
 * @author Tommaso Teofili
 * 
 */
public class MostFrequentWordsAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas cas) throws AnalysisEngineProcessException {
    cas.getAnnotationIndex();

  }

}
