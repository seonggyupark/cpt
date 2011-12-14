package cybion.abstract_annotator;

import cybion.abstract_annotator.dictionary.AbstractDictionaryProvider;
import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.annotator.CybionAbstractAnnotator;
import cybion.uima.ts.BandoEntity;
import org.apache.uima.UimaContext;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import java.util.List;

public class CybionSummaryTextAnnotator extends CybionAbstractAnnotator {

  private TermsAbstractRetriever termsRetriever;

  private RecoveryRetriever recoveryRetriver;

  private DictionaryProvider dictionaryProvider;

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    this.dictionaryProvider = new AbstractDictionaryProvider();
    this.termsRetriever = new TermsAbstractRetriever(this.dictionaryProvider);
    this.recoveryRetriver = new RecoveryRetriever();
    super.initialize(aContext);
  }

  @Override
  protected void extractWithCustomAlgorithm(JCas jCas) {
    // first look for abstract using a dictionary-like approach
    String termsAbstract = termsRetriever.retrieveAbstract(jCas);
    if (termsAbstract != null && !termsAbstract.equals("")) {
      getBando(jCas).setAbstract(termsAbstract);
      this.getContext().getLogger().log(Level.INFO, "abstract found with terms retriever");
    } else {
      // recovery
      try {
        String recoveryAbstract = recoveryRetriver.retrieveAbstract(jCas);
        getBando(jCas).setAbstract(recoveryAbstract);
        this.getContext().getLogger().log(Level.INFO, "abstract found with recovery retriever");
      } catch (Throwable e) {
        this.getContext().getLogger().log(Level.WARNING, "no abstract found");
      }
    }

  }

  @Override
  protected Feature getFeature(JCas cas) throws CASException {
    return cas.getRequiredFeature(cas.getCasType(BandoEntity.type), "abstract");
  }

  @Override
  protected String[] getFeatureKeys(String language) {
    List<String> dictionaryItems = this.dictionaryProvider.getDictionary(language).getDictionaryItems();
    return dictionaryItems.toArray(new String[dictionaryItems.size()]);
  }

}
