package cybion.tag_annotator;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.uima.ts.BandoEntity;
import org.apache.uima.alchemy.ts.concept.ConceptFS;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.NonEmptyStringList;

/**
 *
 * @author tommaso
 *
 */
public class AlchemyConceptsTagAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas cas) throws AnalysisEngineProcessException {
    cas.getAnnotationIndex();

    NonEmptyStringList tags = new NonEmptyStringList(cas);
    for (FeatureStructure concept : AnnotatorUtils.getAllFSofType(ConceptFS.type, cas)) {
      Type type = concept.getType();

      //set new tail of tags
      String previousHead = tags.getHead(); //extract previous head of tags
      NonEmptyStringList newTail = new NonEmptyStringList(cas);
      newTail.setHead(previousHead);
      newTail.setTail(tags.getTail());
      tags.setTail(newTail);

      tags.setHead(concept.getStringValue(type.getFeatureByBaseName("text"))); //set new head of tags
    }
    BandoEntity bandoEntity = AnnotatorUtils.getBandoEntity(cas);
    bandoEntity.setTags(tags);

  }

}