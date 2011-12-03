package cybion.annotator_utils;

import cybion.uima.ts.BandoEntity;
import org.apache.uima.SentenceAnnotation;
import org.apache.uima.TokenAnnotation;
import org.apache.uima.cas.*;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils class for annotators
 */
public class AnnotatorUtils {
  /**
   * @param cas
   * @return
   */
  public static BandoEntity getBandoEntityWithCreation(JCas cas) {
    BandoEntity bandoEntity = null;
    FSIterator<FeatureStructure> indexIterator = cas.getFSIndexRepository().getAllIndexedFS(
            cas.getCasType(BandoEntity.type));
    if (indexIterator.hasNext() == false) {
      System.err.println("No BandoEntity found -- creating one");
      bandoEntity = new BandoEntity(cas);
      bandoEntity.addToIndexes();

    } else {
      try {
        bandoEntity = (BandoEntity) indexIterator.next();
        if (indexIterator.hasNext() == true) {
          throw new RuntimeException("Multiple BandoEntity objects found");
        }
      } catch (Exception e) {
        System.err.println(e);
      }
    }
    return bandoEntity;
  }

  /**
   * @param cas
   * @return
   */
  public static BandoEntity getBandoEntity(JCas cas) {
    FSIterator<FeatureStructure> indexIterator = cas.getFSIndexRepository().getAllIndexedFS(
            cas.getCasType(BandoEntity.type));
    if (indexIterator.hasNext() == false) {
      throw new RuntimeException("No BandoEntity found");
    }
    BandoEntity bandoEntity = (BandoEntity) indexIterator.next();
    if (indexIterator.hasNext() == true) {
      throw new RuntimeException("Multiple BandoEntity objects found");
    }
    return bandoEntity;
  }

  /**
   * @param type
   * @param cas
   * @return
   */
  public static List<FeatureStructure> getAllFSofType(int type, JCas cas) {
    List<FeatureStructure> featureStructures = new ArrayList<FeatureStructure>();
    for (FSIterator<FeatureStructure> it = cas.getFSIndexRepository().getAllIndexedFS(
            cas.getCasType(type)); it.hasNext();) {
      featureStructures.add(it.next());
    }
    return featureStructures;
  }

  /**
   * @param type
   * @param cas
   * @return
   */
  public static List<FeatureStructure> getAllFSofType(Type type, JCas cas) {
    List<FeatureStructure> featureStructures = new ArrayList<FeatureStructure>();
    for (FSIterator<FeatureStructure> it = cas.getFSIndexRepository().getAllIndexedFS(type); it
            .hasNext();) {
      featureStructures.add(it.next());
    }
    return featureStructures;
  }

  /**
   * @param type
   * @param cas
   * @return
   */
  public static List<Annotation> getAnnotations(int type, JCas cas) {
    List<Annotation> annotations = new ArrayList<Annotation>();
    for (Annotation annotation : cas.getAnnotationIndex(type)) {
      annotations.add(annotation);
    }
    return annotations;
  }

  /**
   * @param type
   * @param cas
   * @return
   */
  public static List<Annotation> getAnnotations(Type type, JCas cas) {
    List<Annotation> annotations = new ArrayList<Annotation>();
    for (Annotation annotation : cas.getAnnotationIndex(type)) {
      annotations.add(annotation);
    }
    return annotations;
  }

  /**
   * @return
   * @throws CASException
   * @throws CASRuntimeException
   */
  public static List<TokenAnnotation> getTokensInsideSentence(SentenceAnnotation sentence)
          throws CASRuntimeException, CASException {
    // filter and takes only the token annotations inside the sentence
    AnnotationIndex<Annotation> tokenIndex = sentence.getCAS().getJCas().getAnnotationIndex(
            TokenAnnotation.type);
    List<TokenAnnotation> tokens = new ArrayList<TokenAnnotation>();
    for (Annotation ta : tokenIndex) {
      if (ta.getBegin() < sentence.getEnd() && ta.getEnd() > sentence.getBegin()) {
        tokens.add((TokenAnnotation) ta);
      }
    }
    return tokens;
  }

  /**
   * 
   * @param sentence
   * @param startingAddress
   * @return
   * @throws CASRuntimeException
   * @throws CASException
   */
  public static List<TokenAnnotation> getTokensInsideSentence(SentenceAnnotation sentence,
          int startingAddress) throws CASRuntimeException, CASException {
    // filter and takes only the token annotations inside the sentence
    AnnotationIndex<Annotation> tokenIndex = sentence.getCAS().getJCas().getAnnotationIndex(
            TokenAnnotation.type);
    List<TokenAnnotation> tokens = new ArrayList<TokenAnnotation>();
    for (Annotation ta : tokenIndex) {
      if (ta.getBegin() < sentence.getEnd() && ta.getEnd() > sentence.getBegin()
              && ta.getBegin() > startingAddress) {
        tokens.add((TokenAnnotation) ta);
      }
    }
    return tokens;
  }

  /**
   * get the sentence containing the desired annotation
   * 
   * @param annotation
   * @return
   * @throws CASException
   */
  public static SentenceAnnotation getSentenceContaining(Annotation annotation) throws CASException {
    SentenceAnnotation foundSentence = null;
    List<Annotation> sentenceAnnotations = getAnnotations(SentenceAnnotation.type, annotation
            .getCAS().getJCas());
    for (Annotation sentence : sentenceAnnotations) {
      if (annotation.getBegin() > sentence.getBegin() && annotation.getEnd() < sentence.getEnd()) {
        foundSentence = (SentenceAnnotation) sentence;
        break;
      }
    }

    return foundSentence;
  }

  /**
   * get sentence surrounding a particular position inside the document
   * 
   * @param i
   * @param cas
   * @return
   */
  public static SentenceAnnotation getSentenceAtPosition(int i, JCas cas) {
    SentenceAnnotation foundSentence = null;
    List<Annotation> sentenceAnnotations = getAnnotations(SentenceAnnotation.type, cas);
    for (Annotation sentence : sentenceAnnotations) {
      if (sentence.getBegin() < i && sentence.getEnd() > i) {
        foundSentence = (SentenceAnnotation) sentence;
        break;
      }
    }

    return foundSentence;
  }

  /**
   * get annotations of passed type contained inside the sentece
   * @param sentence
   * @param type
   * @return
   */
  public static List<Annotation> getContainedAnnotations(SentenceAnnotation sentence, int type) throws CASException {
    List<Annotation> foundAnnotations = new ArrayList<Annotation>();
    for (Annotation annotation : getAnnotations(type, sentence.getCAS().getJCas())) {
      if (annotation.getBegin()>=sentence.getBegin() && annotation.getEnd()<=sentence.getEnd()) {
        foundAnnotations.add(annotation);
      }
    }
    return foundAnnotations;
  }
}
