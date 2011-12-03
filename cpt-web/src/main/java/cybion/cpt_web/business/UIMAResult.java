package cybion.cpt_web.business;

import java.util.ArrayList;
import java.util.List;

import cybion.cpt_web.model.Bando;
import cybion.cpt_web.model.Metadata;

public class UIMAResult {
	
	List<Metadata> metadatas;
	Bando bando;
	
	public UIMAResult() {
		this.metadatas = new ArrayList<Metadata>();
	}
	
	public List<Metadata> getMetadatas() {
		return metadatas;
	}
	public void setMetadatas(List<Metadata> metadatas) {
		this.metadatas = metadatas;
	}
	public Bando getBando() {
		return bando;
	}
	public void setBando(Bando bando) {
		this.bando = bando;
	}
	
	

}
