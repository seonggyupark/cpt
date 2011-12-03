package com.cybion.cpt.web.core.business;

import java.io.File;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import com.cybion.cpt.web.core.business.utility.CrawlingSpecificationFirefoxPluginAdapter;


public class XmlAdapterTest {
	
	
	public static void main(String[] args){
		try {
		String path = "/webpipes/fvg/webpipe/crawling.xml";
		File f = new File(path);
		System.out.println(f.toString());
		Document d = new SAXBuilder().build(f);
		String s = new XMLOutputter().outputString(d);
		System.out.println(s);
		CrawlingSpecificationFirefoxPluginAdapter adapter = new CrawlingSpecificationFirefoxPluginAdapter(d);
		Document doc = adapter.getAdaptedDoc();
		String as = new XMLOutputter().outputString(doc);
		System.out.println(as);
		}
		catch(Exception e){e.printStackTrace();}
	}
}