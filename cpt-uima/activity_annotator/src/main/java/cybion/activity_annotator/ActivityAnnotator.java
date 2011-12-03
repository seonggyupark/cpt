package cybion.activity_annotator;

import cybion.activity_annotator.dictionary.ActivityEnglishDictionary;
import cybion.activity_annotator.dictionary.ActivityItalianDictionary;
import cybion.activity_annotator.dictionary.GoodVerbsEnglishDictionary;
import cybion.activity_annotator.dictionary.GoodVerbsItalianDictionary;
import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.DefaultTermsDictionaryProvider;
import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.TermsDictionary;
import cybion.annotator_utils.annotator.POSTokenPredicate;
import cybion.uima.ts.ActivityAnnotation;
import cybion.uima.ts.BandoEntity;
import org.apache.commons.collections.CollectionUtils;
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
import java.util.regex.Pattern;

public class ActivityAnnotator extends JCasAnnotator_ImplBase {

  private DictionaryProvider genericTermsDictionaryProvider;

  private Set<SentenceAnnotation> candidateSentences;

  private DictionaryProvider goodVerbsDictionaryProvider;

  private ActivityPatternProvider activityPatternProvider;

  private static final String VB = "vb";

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    buildTermsDictionaryProvider();
    buildVerbDictionaryProvider();
    this.activityPatternProvider = new ActivityPatternProvider();
    this.candidateSentences = new HashSet<SentenceAnnotation>();
    super.initialize(aContext);
  }

  private void buildVerbDictionaryProvider() {
    List<TermsDictionary> supportedDictionaries = new ArrayList<TermsDictionary>(2);
    supportedDictionaries.add(new GoodVerbsEnglishDictionary());
    supportedDictionaries.add(new GoodVerbsItalianDictionary());
    this.goodVerbsDictionaryProvider = new DefaultTermsDictionaryProvider(supportedDictionaries);
  }

  private void buildTermsDictionaryProvider() {
    List<TermsDictionary> supportedDictionaries = new ArrayList<TermsDictionary>(2);
    supportedDictionaries.add(new ActivityItalianDictionary());
    supportedDictionaries.add(new ActivityEnglishDictionary());
    this.genericTermsDictionaryProvider = new DefaultTermsDictionaryProvider(supportedDictionaries);
  }

  public void process(JCas cas) throws AnalysisEngineProcessException {

    List<Annotation> sentenceAnnotations = AnnotatorUtils.getAnnotations(SentenceAnnotation.type,
            cas);

    String language = cas.getDocumentLanguage();
    // first try to look for the activity using dictionaries
    addMatchingTermsSentences(sentenceAnnotations, language);

    // look for particular structures of sentences

    // Italian structures like ENTITY bandisce OBJECT per ACTIVITY are good
    addMatchingStructuresSentences(sentenceAnnotations, language);

    // if something was found ok
    if (this.candidateSentences.size() > 0) {
      StringBuffer activity = new StringBuffer();
      for (SentenceAnnotation sentence : this.candidateSentences) {
        activity.append(sentence.getCoveredText());
        ActivityAnnotation activityAnnotation = new ActivityAnnotation(cas);
        activityAnnotation.setBegin(sentence.getBegin());
        activityAnnotation.setEnd(sentence.getEnd());
        activityAnnotation.addToIndexes();
      }
      BandoEntity bando = AnnotatorUtils.getBandoEntity(cas);
      bando.setActivity(activity.toString());
    } else {
      this.getContext().getLogger().log(Level.WARNING, "no activity found");
    }
  }

  private void addMatchingStructuresSentences(List<Annotation> sentenceAnnotations, String language) {
    for (Annotation sentenceAnnotation : sentenceAnnotations) {
      try {
        SentenceAnnotation sentence = (SentenceAnnotation) sentenceAnnotation;
        List<TokenAnnotation> tokens = AnnotatorUtils.getTokensInsideSentence(sentence);

        // get all the verbs inside the sentence
        List<TokenAnnotation> verbTokens = new ArrayList<TokenAnnotation>();
        verbTokens.addAll(tokens);
        CollectionUtils.filter(verbTokens, new POSTokenPredicate(VB));

        // TODO we could use here a shallow parser to make it easier

        TermsDictionary goodVerbsDictionary = this.goodVerbsDictionaryProvider
                .getDictionary(language);
        
        // get patterns for language 
        List<Pattern> patterns = activityPatternProvider.getPatterns(language);

        // iterate over verbs i
        for (TokenAnnotation verbToken : verbTokens) {
          this.getContext().getLogger().log(Level.FINE,
                  new StringBuffer("VERB FOUND: ").append(verbToken.getCoveredText()).toString());

          // if the verb is a "good" verb
          if (goodVerbsDictionary.containsTerm(verbToken.getCoveredText())) {
            /*
             * look forward (in the sentence) to some tokens' sequence representing
             * "doing something"
             */
            
            // get following tokens
            List<TokenAnnotation> followingTokens = AnnotatorUtils.getTokensInsideSentence(sentence,verbToken.getAddress());
            
            for (Pattern doingSomthingPattern : patterns) {
              if (patternMatches(doingSomthingPattern,followingTokens)) {
                this.candidateSentences.add(sentence);
                break;
              }
            }
            
          }

        }

      } catch (CASException e) {
        this.getContext().getLogger().log(Level.WARNING, e.toString());
      }
    }
  }

  private boolean patternMatches(Pattern doingSomthingPattern, List<TokenAnnotation> followingTokens) {
    // TODO Auto-generated method stub
    return false;
  }

  private void addMatchingTermsSentences(List<Annotation> sentenceAnnotations, String language) {

    TermsDictionary dictionary = genericTermsDictionaryProvider.getDictionary(language);
    for (Annotation sentenceAnnotation : sentenceAnnotations) {
      try {
        List<TokenAnnotation> tokenAnnotations = AnnotatorUtils
                .getTokensInsideSentence((SentenceAnnotation) sentenceAnnotation);
        for (TokenAnnotation token : tokenAnnotations) {
          if (dictionary.containsTerm(token.getCoveredText())) {
            this.candidateSentences.add((SentenceAnnotation) sentenceAnnotation);
          }
        }
      } catch (Exception e) {
        this.getContext().getLogger().log(Level.WARNING, e.toString());
      }
    }

  }

}
