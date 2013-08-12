package cybion.annotator_utils.annotator;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DummyEntityAnnotator extends EntityAnnotator {

  private String regex = "(the|that|your|it|uima|UIMA|yours|mine|my|this)\\s";


  /* (non-Javadoc)
   * @see org.apache.uima.analysis_component.JCasAnnotator_ImplBase#process(org.apache.uima.jcas.JCas)
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {

    String doc = aJCas.getDocumentText(); //fetch document
    int pos = 0; //start position
    Pattern pat = Pattern.compile(regex); //compile regex
    Matcher m = pat.matcher(doc);
    while (m.find(pos)) { //look for a matching of the regex
      Annotation annotation = new Annotation(aJCas); //set a date annotaion
      annotation.setBegin(m.start());
      annotation.setEnd(m.end());
      annotation.addToIndexes(); //add annotation to indexes

      this.addEntityReference(aJCas, annotation); //add the annotation to the entities references

      pos = m.end();

    }


  }

}
