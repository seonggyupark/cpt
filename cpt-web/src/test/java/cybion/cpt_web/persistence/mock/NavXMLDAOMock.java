package cybion.cpt_web.persistence.mock;

import cybion.cpt_web.model.Fonte;
import cybion.cpt_web.model.NavXML;
import cybion.cpt_web.persistence.NavXMLDAO;


/** mock per il dao navxml */
public class NavXMLDAOMock extends NavXMLDAO {
	
	@Override
	public NavXML getNavXML(Fonte f) {
		NavXML n = new NavXML();
		n.setContentCrawling("<navigation><model><pageclass type=\"pageclass_0\"><classlink expectedtype=\"pageclass_1\"><linksfactory type=\"AnchorLinksFactory\"><xpath><![CDATA[//HTML[1]/BODY[1]/DIV[2]/DIV[2]/DIV[1]/DIV[2]/UL[1]/LI[6]/A[1]]]></xpath></linksfactory></classlink></pageclass><pageclass type=\"pageclass_1\"><classlink expectedtype=\"pageclass_2\"><linksfactory type=\"AnchorLinksFactory\"><xpath><![CDATA[//HTML[1]/BODY[1]/DIV[2]/DIV[5]/DIV[2]/DIV[1]/DIV/DIV[2]/A[1]]]><urlPattern><![CDATA[^http://www.regione.fvg.it/rafvg/concorsi/ricercheConcorsi.act[?](m|id|dir)=([^&]*)&(m|id|dir)=([^&]*)&(m|id|dir)=([^&]*)$]]></urlPattern></xpath></linksfactory></classlink></pageclass><pageclass type=\"pageclass_2\"><classlink expectedtype=\"pageclass_3\"><linksfactory type=\"AnchorLinksFactory\"><xpath><![CDATA[//HTML[1]/BODY[1]/DIV[2]/DIV[5]/DIV[2]/DIV[1]/DIV[2]/UL[1]/LI[1]/A[1]]]></xpath></linksfactory></classlink></pageclass><pageclass type=\"pageclass_3\"/></model><entrypoint type=\"pageclass_0\"><url><![CDATA[http://arpebur.regione.fvg.it/newbur/]]></url></entrypoint></navigation>);");
		n.setIdNavXML(new Integer(900000001));
		return n;
		
	}
	
}
