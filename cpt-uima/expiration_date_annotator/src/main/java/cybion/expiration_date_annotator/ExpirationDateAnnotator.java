package cybion.expiration_date_annotator;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.DefaultTermsDictionaryProvider;
import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.TermsDictionary;
import cybion.annotator_utils.ts.DateAnnotation;
import cybion.expiration_date_annotator.dictionary.EDEnglishTermsDictionary;
import cybion.expiration_date_annotator.dictionary.EDItalianTermsDictionary;
import cybion.uima.ts.BandoEntity;
import cybion.uima.ts.ExpirationDateAnnotation;
import org.apache.uima.SentenceAnnotation;
import org.apache.uima.TokenAnnotation;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpirationDateAnnotator extends JCasAnnotator_ImplBase {

  private Set<SentenceAnnotation> candidates = new HashSet<SentenceAnnotation>();
  private DictionaryProvider dictionaryProvider ;

  @Override
  public void initialize(UimaContext uimaContext) throws ResourceInitializationException {
    List<TermsDictionary> termsDictionaries = new ArrayList<TermsDictionary>();
    termsDictionaries.add(new EDItalianTermsDictionary());
    termsDictionaries.add(new EDEnglishTermsDictionary());
    dictionaryProvider = new DefaultTermsDictionaryProvider(termsDictionaries); 
    super.initialize(uimaContext);
  }

  public void process(JCas cas) throws AnalysisEngineProcessException {
    List<Annotation> dateAnnotations = AnnotatorUtils.getAnnotations(DateAnnotation.type, cas);

    // find sentenceAnnotations containing dates
    for (Annotation dateAnnotation : dateAnnotations) {
      try {
        SentenceAnnotation sentenceAnnotation = AnnotatorUtils
                .getSentenceContaining(dateAnnotation);
        if (sentenceAnnotation != null) {
          this.getContext().getLogger().log(Level.INFO, new StringBuilder("found a date : ").append(dateAnnotation.getCoveredText()).toString());
          this.candidates.add(sentenceAnnotation);
        } else {
          this.getContext().getLogger().log(Level.WARNING,
                  "sentence containing date annotation not found ");
        }
      } catch (CASException e) {
        this.getContext().getLogger().log(Level.WARNING, e.toString());
      }
    }

    // choose from the candidates sentences
    String expirationDateSentence = chooseBetweenCandidates(cas.getDocumentLanguage());

    if (expirationDateSentence != null && !"".equals(expirationDateSentence)) {
      BandoEntity bandoEntity = AnnotatorUtils.getBandoEntityWithCreation(cas);
      bandoEntity.setExpirationDate(expirationDateSentence);
    }
  }

  private String chooseBetweenCandidates(String language) {
    String expirationDate = null;
    TermsDictionary dictionary = this.dictionaryProvider.getDictionary(language);
    for (SentenceAnnotation sentenceAnnotation : this.candidates) {
      try {
        for (TokenAnnotation token : AnnotatorUtils.getTokensInsideSentence(sentenceAnnotation)){
          if (dictionary.containsTerm(token.getCoveredText())) {
            expirationDate = sentenceAnnotation.getCoveredText();
            ExpirationDateAnnotation expirationDateAnnotation = new ExpirationDateAnnotation(sentenceAnnotation.getCAS().getJCas());
            expirationDateAnnotation.setBegin(sentenceAnnotation.getBegin());
            expirationDateAnnotation.setEnd(sentenceAnnotation.getEnd());
            expirationDateAnnotation.addToIndexes();
            break;
          }
        }
      } catch (CASException e) {
        // do nothing
      }
    }
    return expirationDate;
  }
}
