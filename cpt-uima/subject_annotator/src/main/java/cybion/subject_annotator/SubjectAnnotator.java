package cybion.subject_annotator;

import java.util.List;

import org.apache.uima.SentenceAnnotation;
import org.apache.uima.TokenAnnotation;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import cybion.annotator_utils.AnnotatorUtils;

public class SubjectAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas cas) throws AnalysisEngineProcessException {

    List<Annotation> annotations = AnnotatorUtils.getAnnotations(SentenceAnnotation.type, cas);
    for (Annotation annotation : annotations) {
      SentenceAnnotation sentence = (SentenceAnnotation) annotation;
      try {
        List<TokenAnnotation> tokens = AnnotatorUtils.getTokensInsideSentence(sentence);
      } catch (Exception e) {
        // TODO do nothing
      }
    }
    
    

  }

}
