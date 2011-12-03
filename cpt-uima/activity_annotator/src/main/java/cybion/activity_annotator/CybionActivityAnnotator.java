package cybion.activity_annotator;

import cybion.activity_annotator.dictionary.ActivityEnglishDictionary;
import cybion.activity_annotator.dictionary.ActivityItalianDictionary;
import cybion.activity_annotator.dictionary.GoodVerbsEnglishDictionary;
import cybion.activity_annotator.dictionary.GoodVerbsItalianDictionary;
import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.DefaultTermsDictionaryProvider;
import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.TermsDictionary;
import cybion.annotator_utils.annotator.CybionAbstractAnnotator;
import cybion.annotator_utils.annotator.POSTokenPredicate;
import cybion.uima.ts.ActivityAnnotation;
import cybion.uima.ts.BandoEntity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.uima.SentenceAnnotation;
import org.apache.uima.TokenAnnotation;
import org.apache.uima.UimaContext;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CybionActivityAnnotator extends CybionAbstractAnnotator {

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

  @Override
  public void extractWithCustomAlgorithm(JCas cas) {

    List<Annotation> sentenceAnnotations = AnnotatorUtils.getAnnotations(SentenceAnnotation.type,
            cas);

    String language = cas.getDocumentLanguage();

    if (language != null && language.length() > 0 && !"x-unspecified".equals(language)) {

      // first try to look for the activity using dictionaries
      addMatchingTermsSentences(sentenceAnnotations, language);

      // look for particular structures of sentences

      // Italian structures like ENTITY bandisce OBJECT per ACTIVITY are good
      addMatchingStructuresSentences(sentenceAnnotations, language);

      // if something was found ok
      if (this.candidateSentences.size() > 0) {
        StringBuffer activity = new StringBuffer();
        for (SentenceAnnotation sentence : this.candidateSentences) {
          try {
            activity.append(sentence.getCoveredText()).append("...");
            ActivityAnnotation activityAnnotation = new ActivityAnnotation(cas);
            activityAnnotation.setBegin(sentence.getBegin());
            activityAnnotation.setEnd(sentence.getEnd());
            activityAnnotation.addToIndexes();
          } catch (Exception e) {
            this.getContext().getLogger().log(Level.SEVERE, e.toString());
          }
        }
        getBando(cas).setActivity(activity.toString());
      } else {
        this.getContext().getLogger().log(Level.WARNING, "no activity found");
      }
    } else {
      this.getContext().getLogger().log(Level.WARNING, new StringBuffer("undefined or incompatible language: ").append(language).toString());
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
          this.getContext().getLogger().log(Level.INFO,
                  new StringBuffer("VERB FOUND: ").append(verbToken.getCoveredText()).toString());

          // if the verb is a "good" verb
          if (goodVerbsDictionary.containsTerm(verbToken.getCoveredText())) {
            this.getContext().getLogger().log(Level.INFO,
                    "found a good verb " + verbToken.getCoveredText());
            /*
             * look forward (in the sentence) to some tokens' sequence representing
             * "doing something"
             */

            // get following tokens
            List<TokenAnnotation> followingTokens = AnnotatorUtils.getTokensInsideSentence(
                    sentence, verbToken.getAddress());

            for (Pattern doingSomethingPattern : patterns) {
              if (patternMatches(doingSomethingPattern, followingTokens)) {
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

  private boolean patternMatches(Pattern doingSomethingPattern,
                                 List<TokenAnnotation> followingTokens) {
    StringBuilder stringBuilder = new StringBuilder();
    for (TokenAnnotation tokenAnnotation : followingTokens) {
      stringBuilder.append(tokenAnnotation.getCoveredText()).append(" ");
    }
    String followingSentence = stringBuilder.toString();
    this.getContext().getLogger().log(Level.INFO,
            "Trying to match a 'doing pattern' for sentence " + followingSentence);
    boolean ok = doingSomethingPattern.matcher(followingSentence).find();
    this.getContext().getLogger().log(Level.INFO,
            "sentence " + followingSentence + " matching 'doing-pattern' : " + ok);
    return ok;
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

  @Override
  protected Feature getFeature(JCas cas) throws CASException {
    return cas.getRequiredFeature(cas.getCasType(BandoEntity.type), "activity");
  }

  @Override
  protected String[] getFeatureKeys(String language) {
    List<String> dictionaryItems = this.genericTermsDictionaryProvider.getDictionary(language)
            .getDictionaryItems();
    return dictionaryItems.toArray(new String[dictionaryItems.size()]);
  }

}
