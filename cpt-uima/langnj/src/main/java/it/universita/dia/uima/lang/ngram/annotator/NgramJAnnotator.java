package it.universita.dia.uima.lang.ngram.annotator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.spieleck.app.ngramj.Categorizer;
import de.spieleck.app.ngramj.lm.CategorizerImpl;

public class NgramJAnnotator extends JCasAnnotator_ImplBase {

	public void process(JCas cas) throws AnalysisEngineProcessException {
		
		String doc = cas.getDocumentText();
		

	}

}
