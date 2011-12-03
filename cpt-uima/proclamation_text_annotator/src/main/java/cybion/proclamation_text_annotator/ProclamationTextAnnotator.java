package cybion.proclamation_text_annotator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import cybion.uima.ts.BandoEntity;
import cybion.uima.ts.ProclamationTextAnnotation;

public class ProclamationTextAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas cas) throws AnalysisEngineProcessException {
    String proclamationText = cas.getDocumentText();
    // dummy implementation: simply get document text and annotates the whole of it
    ProclamationTextAnnotation proclamationTextAnnotation = new ProclamationTextAnnotation(cas);
    proclamationTextAnnotation.setBegin(0);
    proclamationTextAnnotation.setEnd(proclamationText.length());
    proclamationTextAnnotation.addToIndexes();

    // generate the entity related to the Bando object
    BandoEntity bando = new BandoEntity(cas);
    bando.setText(proclamationTextAnnotation.getCoveredText());
    bando.addToIndexes();

  }

}
