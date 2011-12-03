package cybion.tag_annotator;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.uima.ts.BandoEntity;
import org.apache.uima.alchemy.ts.keywords.KeywordFS;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyStringList;
import org.apache.uima.jcas.cas.NonEmptyStringList;

/**
 * @author tommaso
 */
public class AlchemyKeywordsTagAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas cas) throws AnalysisEngineProcessException {
    BandoEntity bandoEntity = AnnotatorUtils.getBandoEntity(cas);
    if (bandoEntity.getTags() == null || bandoEntity.getTags() instanceof EmptyStringList ) {
      NonEmptyStringList tags = new NonEmptyStringList(cas);
      for (FeatureStructure keyword : AnnotatorUtils.getAllFSofType(KeywordFS.type, cas)) {
        Type type = keyword.getType();

        //set new tail of tags
        String previousHead = tags.getHead(); //extract previous head of tags
        NonEmptyStringList newTail = new NonEmptyStringList(cas);
        newTail.setHead(previousHead);
        newTail.setTail(tags.getTail());
        tags.setTail(newTail);

        tags.setHead(keyword.getStringValue(type.getFeatureByBaseName("text"))); //set new head of tags
      }

      bandoEntity.setTags(tags);
    }
  }

}
