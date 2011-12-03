package org.apache.uima.annotator.language;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.uima.ts.BandoEntity;

public class DummyLanguageAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas cas) throws AnalysisEngineProcessException {

    BandoEntity bando = AnnotatorUtils.getBandoEntityWithCreation(cas);
    if (cas.getDocumentLanguage().length()>2) 
      cas.setDocumentLanguage(cas.getDocumentLanguage().substring(0,2));
    bando.setLanguage(cas.getDocumentLanguage());
    
  }

}
