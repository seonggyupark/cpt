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
 */
public class BandoBuilder {

  private BandoEntity bandoEntity;

  public BandoBuilder(BandoEntity bandoEntity) {
    this.bandoEntity = bandoEntity;
  }

  public Bando build() {
    
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
    return bando;
  }

}
