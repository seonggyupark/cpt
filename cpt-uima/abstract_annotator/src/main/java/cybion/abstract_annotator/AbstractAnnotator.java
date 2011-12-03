package cybion.abstract_annotator;

import cybion.abstract_annotator.dictionary.AbstractDictionaryProvider;
import cybion.annotator_utils.AnnotatorUtils;
import cybion.uima.ts.BandoEntity;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

@Deprecated
public class AbstractAnnotator extends JCasAnnotator_ImplBase {

  private TermsAbstractRetriever termsRetriever;

  private RecoveryRetriever recoveryRetriver;

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    this.termsRetriever = new TermsAbstractRetriever(new AbstractDictionaryProvider());
    this.recoveryRetriver = new RecoveryRetriever();
    super.initialize(aContext);
  }

  public void process(JCas cas) throws AnalysisEngineProcessException {
    BandoEntity bando = AnnotatorUtils.getBandoEntity(cas);

    // look inside the first part of the document

    // first look for abstract using a dictionary-like approach
    String termsAbstract = termsRetriever.retrieveAbstract(cas);
    if (termsAbstract != null && !termsAbstract.equals("")) {
      bando.setAbstract(termsAbstract);
    } else {
      // recovery
      try {
        String recoveryAbstract = recoveryRetriver.retrieveAbstract(cas);
        bando.setAbstract(recoveryAbstract);
      } catch (AssertionError e) {
        this.getContext().getLogger().log(Level.WARNING, "no abstract found");
      }
    }
  }

}
