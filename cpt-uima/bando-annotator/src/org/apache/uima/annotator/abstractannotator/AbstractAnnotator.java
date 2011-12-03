package org.apache.uima.annotator.abstractannotator;

import java.util.Iterator;

import org.apache.uima.SentenceAnnotation;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class AbstractAnnotator extends JCasAnnotator_ImplBase  {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		Iterator<SentenceAnnotation> it = aJCas.getAnnotationIndex(SentenceAnnotation.type).iterator();
		
		while (it.hasNext()) {
			SentenceAnnotation s = (SentenceAnnotation) it.next();
			
		}
	}

}
