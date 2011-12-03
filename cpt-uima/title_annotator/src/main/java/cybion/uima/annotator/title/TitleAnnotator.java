package cybion.uima.annotator.title;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.DefaultTermsDictionaryProvider;
import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.TermsDictionary;
import cybion.annotator_utils.annotator.CybionAbstractAnnotator;
import cybion.annotator_utils.annotator.date.DatePatternsProvider;
import cybion.uima.ts.BandoEntity;
import cybion.uima.ts.TitleAnnotation;
import org.apache.uima.SentenceAnnotation;
import org.apache.uima.UimaContext;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TitleAnnotator extends CybionAbstractAnnotator {
  private DictionaryProvider termsDictionaryProvider;

  @Override
  protected Feature getFeature(JCas cas) throws CASException {
    return cas.getRequiredFeature(cas.getCasType(BandoEntity.type), "title");
  }

  @Override
  protected String[] getFeatureKeys(String language) {
    List<String> dictionaryItems = termsDictionaryProvider.getDictionary(language)
            .getDictionaryItems();
    return dictionaryItems.toArray(new String[dictionaryItems.size()]);
  }

  @Override
  protected void extractWithCustomAlgorithm(JCas jCas) {
    // first look for an existing title
    List<Annotation> sentences = AnnotatorUtils.getAnnotations(SentenceAnnotation.type, jCas);

    // look only in the first two sentences
    if (!sentences.isEmpty()) {

      if (sentences.size() == 1) {
        extractTitleFromOneSentence(sentences.get(0));
      } else {
        extractTitleFromMoreSentences(jCas, sentences);
      }
    }
  }

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    TermsDictionary dictionary = new TitleDictionary();
    List<TermsDictionary> termsDictionaries = new ArrayList<TermsDictionary>(1);
    termsDictionaries.add(dictionary);
    DictionaryProvider provider = new DefaultTermsDictionaryProvider(termsDictionaries);
    this.termsDictionaryProvider = provider;
    super.initialize(aContext);
  }

  private void extractTitleFromMoreSentences(JCas aJCas, List<Annotation> sentences) {

    List<Annotation> firstSentences = sentences.subList(0, 2);

    StringBuffer title = new StringBuffer();

    for (Annotation annotation : firstSentences) {
      String foundTitle = getTitleWithKnownPatterns(annotation.getCoveredText());

      if (foundTitle != null && !foundTitle.equals("")) {
        title.append(foundTitle);
        TitleAnnotation titleAnnotation = new TitleAnnotation(aJCas);
        titleAnnotation.setBegin(annotation.getBegin());
        titleAnnotation.setEnd(annotation.getEnd());
        titleAnnotation.addToIndexes();
        break;
      } else {
        boolean good = true;

        // check if it's too long
        if (annotation.getCoveredText().length() > 25)
          good = false;

        // then check if there are some dates inside
        if (good) {
          for (Pattern pat : DatePatternsProvider.getDatePatterns()) { // get a pattern
            int pos = 0; // start position
            Matcher m = pat.matcher(annotation.getCoveredText());

            // look for a matching of the regex
            while (m.find(pos)) {
              // if some date is in the title then it's not good
              good = false;
              pos = m.end();
              break;
            }
            if (!good)
              break;
          }
        }

        if (good) {
          title.append(annotation.getCoveredText()).append("...");
          TitleAnnotation titleAnnotation = new TitleAnnotation(aJCas);
          titleAnnotation.setBegin(annotation.getBegin());
          titleAnnotation.setEnd(annotation.getEnd());
          titleAnnotation.addToIndexes();
        }
      }

      if (title.toString().equals("")) {
        // if not found put some kind of derived title
        if (annotation.getCoveredText().length() > 25) {
          title = new StringBuffer(aJCas.getDocumentText().substring(0, 25).trim());
          TitleAnnotation titleAnnotation = new TitleAnnotation(aJCas);
          titleAnnotation.setBegin(0);
          titleAnnotation.setEnd(28);
          titleAnnotation.addToIndexes();
        } else {
          title.append(annotation.getCoveredText());
        }
      }

    }

    // store the title
    BandoEntity bandoEntity = AnnotatorUtils.getBandoEntityWithCreation(aJCas);
    bandoEntity.setTitle(title.toString());
  }

  private void extractTitleFromOneSentence(Annotation sentenceAnnotation) {
    StringBuffer title = new StringBuffer();
    String foundTitle = getTitleWithKnownPatterns(sentenceAnnotation.getCoveredText());
    if (foundTitle != null && !foundTitle.equals("")) {
      title.append(foundTitle);
    } else {
      if (sentenceAnnotation.getCoveredText().length() > 25)
        title.append(sentenceAnnotation.getCoveredText().substring(0, 25).trim()).append("...");
      else {
        title.append(sentenceAnnotation.getCoveredText());
      }
    }
    // store the title
    BandoEntity bandoEntity = null;
    try {
      bandoEntity = AnnotatorUtils
              .getBandoEntityWithCreation(sentenceAnnotation.getCAS().getJCas());
      bandoEntity.setTitle(title.toString());
    } catch (CASException e) {
      this.getContext().getLogger().log(Level.SEVERE,
              new StringBuilder("could not create title!").toString());
    }

  }

  private String getTitleWithKnownPatterns(String text) {

    Scanner stringScanner = new Scanner(text);

    String pattern = ".*(Identifier|Title|Titolo|Titre|(Refrence de l'appel)).*(:|\\s).*";
    String stringFound = stringScanner.findInLine(Pattern.compile(pattern));
    if (stringFound != null && stringFound.indexOf(':') > 0)
      stringFound = stringFound.substring(stringFound.indexOf(':'));
    return stringFound;

  }

}
