package com.cybion.cpt.web.core.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cybion.cpt.web.core.model.NavigationXML;
import com.cybion.cpt.web.core.model.Source;


/**
 * DAO per i file XML di navigazione delle Fonti
 * @author tommaso
 *
 */
public class NavigationXMLDAO extends HibernateDaoSupport {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected NavigationXML getNavXML(Source f) {
		// mockato : per effettuare i primi test (ritorna infatti l'xml di navigazione di FVG)
		NavigationXML n = new NavigationXML();
		n.setContentWrapping("<navigation><model><pageclass type=\"pageclass_0\"><classlink expectedtype=\"pageclass_1\"><linksfactory type=\"AnchorLinksFactory\"><xpath><![CDATA[//HTML[1]/BODY[1]/DIV[2]/DIV[2]/DIV[1]/DIV[2]/UL[1]/LI[6]/A[1]]]></xpath></linksfactory></classlink></pageclass><pageclass type=\"pageclass_1\"><classlink expectedtype=\"pageclass_2\"><linksfactory type=\"AnchorLinksFactory\"><xpath><![CDATA[//HTML[1]/BODY[1]/DIV[2]/DIV[5]/DIV[2]/DIV[1]/DIV/DIV[2]/A[1]]]><urlPattern><![CDATA[^http://www.regione.fvg.it/rafvg/concorsi/ricercheConcorsi.act[?](m|id|dir)=([^&]*)&(m|id|dir)=([^&]*)&(m|id|dir)=([^&]*)$]]></urlPattern></xpath></linksfactory></classlink></pageclass><pageclass type=\"pageclass_2\"><classlink expectedtype=\"pageclass_3\"><linksfactory type=\"AnchorLinksFactory\"><xpath><![CDATA[//HTML[1]/BODY[1]/DIV[2]/DIV[5]/DIV[2]/DIV[1]/DIV[2]/UL[1]/LI[1]/A[1]]]></xpath></linksfactory></classlink></pageclass><pageclass type=\"pageclass_3\"/></model><entrypoint type=\"pageclass_0\"><url><![CDATA[http://arpebur.regione.fvg.it/newbur/]]></url></entrypoint></navigation>);");
		n.setIdNavXML(new Integer(900000001));
		return n;
	}
	
	protected NavigationXML getNavXML(int idNavXML){
		NavigationXML xml = null;
		try {
			xml = (NavigationXML) this.getSession().load(NavigationXML.class, idNavXML);
		  	this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}
		  	catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		  	
		  	return xml;
	}
	
	protected void saveXML(NavigationXML xml) {
		try {
			this.getHibernateTemplate().save(xml);
			logger.info("XML SALVATO");
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		} catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		
	}
	
	protected List<NavigationXML> getAllXML() {
		List<NavigationXML> result = null;
		try {
			List<NavigationXML> loadAll = (List<NavigationXML>)this.getHibernateTemplate().loadAll(NavigationXML.class);
			result = loadAll;
			logger.info("XML CARICATI");
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		
		return result;
	}
}
