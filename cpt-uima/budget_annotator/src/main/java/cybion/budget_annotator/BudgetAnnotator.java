package cybion.budget_annotator;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.DefaultTermsDictionaryProvider;
import cybion.annotator_utils.DictionaryProvider;
import cybion.annotator_utils.TermsDictionary;
import cybion.annotator_utils.annotator.CybionAbstractAnnotator;
import cybion.uima.ts.BandoEntity;
import cybion.uima.ts.BudgetAnnotation;
import org.apache.uima.SentenceAnnotation;
import org.apache.uima.UimaContext;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BudgetAnnotator extends CybionAbstractAnnotator {

  private static final String SIMPLE_BUDGET_REGEX = "(VAT|(B|b)udget|(A|a)ward):\\s*\\({0,1}\\s*(USD|€|euro|$|pound|Euro|EURO|EUR|£|Pound|Dollar|Dollars){0,1}\\s*\\){0,1}\\s*(\\d{1,}\\.{0,1}\\,{0,1}\\s{0,1}){1,}\\s*\\({0,1}\\s*(USD|€|euro|$|pound|Euro|EURO|EUR|£|Pound|Dollar|Dollars){0,1}\\s*\\){0,1}\\s*(per award){0,1}";

  private static final Pattern simpleBudgetPattern = Pattern.compile(SIMPLE_BUDGET_REGEX);

  private DictionaryProvider budgetProvider;

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    List<TermsDictionary> supportedDictionaries = new ArrayList<TermsDictionary>();
    supportedDictionaries.add(new BudgetDictionary("it"));
    supportedDictionaries.add(new BudgetDictionary("en"));
    this.budgetProvider = new DefaultTermsDictionaryProvider(supportedDictionaries);
  }

  public void extractWithCustomAlgorithm(JCas cas) {
    boolean found = false;
    String document = cas.getDocumentText();
    Matcher matcher = simpleBudgetPattern.matcher(document);
    while (matcher.find(0)) {
      BudgetAnnotation budgetAnnotation = new BudgetAnnotation(cas);
      budgetAnnotation.setBegin(matcher.start());
      budgetAnnotation.setEnd(matcher.end());
      budgetAnnotation.addToIndexes();
      BandoEntity bandoEntity = AnnotatorUtils.getBandoEntityWithCreation(cas);
      bandoEntity.setBudget(budgetAnnotation.getCoveredText());
      found = true;
      break;
    }
    if (!found) {
      // get the first sentence which contains 'budget'
      List<Annotation> sentences = AnnotatorUtils.getAnnotations(SentenceAnnotation.type, cas);
      for (Annotation annotation : sentences) {
        if (annotation.getCoveredText().contains("budget")
                || annotation.getCoveredText().contains("Budget")
                || annotation.getCoveredText().contains("BUDGET")) {
          BandoEntity bandoEntity = AnnotatorUtils.getBandoEntityWithCreation(cas);
          bandoEntity.setBudget(annotation.getCoveredText());
          break;
        }
      }
    }

  }

  @Override
  protected Feature getFeature(JCas cas) throws CASException {
    return cas.getRequiredFeature(cas.getCasType(BandoEntity.type), "budget");
  }

  @Override
  protected String[] getFeatureKeys(String language) {
    List<String> dictionaryItems = this.budgetProvider.getDictionary(language).getDictionaryItems();
    return dictionaryItems.toArray(new String[dictionaryItems.size()]);
  }

}
