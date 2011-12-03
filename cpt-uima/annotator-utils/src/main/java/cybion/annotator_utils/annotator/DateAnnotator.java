package cybion.annotator_utils.annotator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import cybion.annotator_utils.annotator.date.DatePatternsProvider;
import cybion.annotator_utils.ts.DateAnnotation;

public class DateAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJcas) throws AnalysisEngineProcessException {

    String doc = aJcas.getDocumentText(); // fetch document
    int pos = 0; // start position
    for (Pattern pat : DatePatternsProvider.getDatePatterns()) { //get a pattern
      Matcher m = pat.matcher(doc);
      while (m.find(pos)) { // look for a matching of the regex
        DateAnnotation da = new DateAnnotation(aJcas); // set a date annotaion
        da.setBegin(m.start());
        da.setEnd(m.end());
        da.addToIndexes(); // add annotation to indexes
        pos = m.end();
      }
    }

  }
}
