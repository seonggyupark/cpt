package cybion.cpt_web.model.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.uima.cas.CASRuntimeException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.StringList;

import cybion.cpt_web.model.Bando;
import cybion.cpt_web.model.Metadata;
import cybion.cpt_web.model.Pagina;
import cybion.uima.ts.BandoEntity;

/**
 * builder for object Bando
 * 
 * @author tommaso
 * 
 */
public class BandoBuilder {

  private Pagina pagina;

  private Map<String, Metadata> annotationsMap = new HashMap<String, Metadata>();

  private BandoEntity bandoEntity;

  public BandoBuilder(BandoEntity bandoEntity) {
    this.bandoEntity = bandoEntity;
  }

  public BandoBuilder(Pagina pagina, Map<String, Metadata> annotations) {
    this.pagina = pagina;
    this.annotationsMap = annotations;
  }

  public BandoBuilder(Pagina pagina, List<Metadata> listaAnnotations) {
    this.pagina = pagina;
    for (Metadata metadata : listaAnnotations) {
      this.annotationsMap.put(metadata.getType(), metadata);
    }
  }

  public Bando build() {
    
    for (Feature feature : this.bandoEntity.getType().getFeatures()) {
      try {
        System.err.println("-----------------");
        System.err.println("-----------------");
        System.err.println(feature.getName()+" : "+this.bandoEntity.getFeatureValueAsString(feature));
        System.err.println("-----------------");
        System.err.println("-----------------");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    Bando bando = new Bando();
    bando.setCategoria(this.bandoEntity.getCategory());
    bando.setAttivita(this.bandoEntity.getActivity());
    bando.setBeneficiario(this.bandoEntity.getBeneficiary());
    bando.setBudget(this.bandoEntity.getBudget());
    bando.setDataScadenza(this.bandoEntity.getExpirationDate());
    bando.setLingua(this.bandoEntity.getLanguage());
    bando.setSunto(this.bandoEntity.getAbstract());
    StringList tagsStringList = this.bandoEntity.getTags();
    int i = 0;
    StringBuffer tags = new StringBuffer();
    while (tagsStringList.getNthElement(i) != null) {
      tags.append(tagsStringList.getNthElement(i)).append(",");
      i++;
    }
    bando.setTagList(tags.toString());
    bando.setLingua(this.bandoEntity.getLanguage());
    bando.setTestoIntegrale(this.bandoEntity.getText());
    bando.setRegGeografica(this.bandoEntity.getGeographicRegion());
    bando.setOggetto(this.bandoEntity.getSubject() + " - " + this.bandoEntity.getSector());
    bando.setTitolo(this.bandoEntity.getTitle());
    System.err.println(bando.toString());
    return bando;
  }

  @Deprecated
  public Bando oldBuild() {
    Bando bando = new Bando();
    bando.setAnnotationsNumber(this.annotationsMap.size());

    // prevalgono le informazioni inserite nel modello di navigazione (i metadati dei wrapper)

    // per ogni campo se queste informazioni non ci sono allora si mettono quelle stratte da UIMA

    if (this.annotationsMap.get("cybion.uima.ts.ActivityAnnotation") != null)
      bando.setAttivita(this.annotationsMap.get("cybion.uima.ts.ActivityAnnotation").getText());
    if (this.annotationsMap.get("cybion.uima.ts.BeneficiaryAnnotation") != null)
      bando.setBeneficiario(this.annotationsMap.get("cybion.uima.ts.BeneficiaryAnnotation")
              .getText());
    if (this.annotationsMap.get("cybion.uima.ts.BudgetAnnotation") != null)
      bando.setBudget(this.annotationsMap.get("cybion.uima.ts.BudgetAnnotation").getText());
    if (this.annotationsMap.get("cybion.uima.ts.ExpirationDateAnnotation") != null)
      bando.setDataScadenza(this.annotationsMap.get("cybion.uima.ts.ExpirationDateAnnotation")
              .getText());
    // bando.setEnte(this.annotations.get("cybion.uima.ts....Annotation").getText());
    bando.setIdBando(generateId());
    bando.setLinkAllaFonte(pagina.getUri()); // what about leaf_link_annotator here? :
                                             // this.annotations.get("cybion.uima.ts.LeafLinkAnnotation").getText()
    if (this.annotationsMap.get("cybion.uima.ts.NoteAnnotation") != null)
      bando.setNote(this.annotationsMap.get("cybion.uima.ts.NoteAnnotation").getText());
    if (this.annotationsMap.get("cybion.uima.ts.SubjectAnnotation") != null)
      bando.setOggetto(this.annotationsMap.get("cybion.uima.ts.SubjectAnnotation").getText());
    if (this.annotationsMap.get("cybion.uima.ts.FundingPercentageyAnnotation") != null)
      bando.setPercFinanziamento(this.annotationsMap.get(
              "cybion.uima.ts.FundingPercentageAnnotation").getText());
    if (this.annotationsMap.get("cybion.uima.ts.GeographicRegionAnnotation") != null)
      bando.setRegGeografica(this.annotationsMap.get("cybion.uima.ts.GeographicRegionAnnotation")
              .getText());
    // bando.setTagList(this.annotations.get("cybion.uima.ts.TagAnnotation").getText());
    if (this.annotationsMap.get("cybion.uima.ts.ProclamationTextAnnotation") != null)
      bando.setTestoIntegrale(this.annotationsMap.get("cybion.uima.ts.ProclamationTextAnnotation")
              .getText());
    // bando.setTimestamp(timeStamp); //TODO use hashcode
    if (this.annotationsMap.get("cybion.uima.ts.FundingTypeAnnotation") != null)
      bando.setTipoFinanziamento(this.annotationsMap.get("cybion.uima.ts.FundingTypeAnnotation")
              .getText());
    if (this.annotationsMap.get("cybion.uima.ts.TitleAnnotation") != null)
      bando.setTitolo(this.annotationsMap.get("cybion.uima.ts.TitleAnnotation").getText());
    if (this.annotationsMap.get("org.apache.uima.alchemy.ts.categorization.Category") != null) {
      bando.setCategoria(this.annotationsMap.get(
              "org.apache.uima.alchemy.ts.categorization.Category").getText());
    }
    return bando;
  }

  private int generateId() {
    // TODO Auto-generated method stub
    return 0;
  }

}
