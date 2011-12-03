package cybion.cpt_web.business;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cybion.cpt_web.model.Fonte;
import cybion.cpt_web.model.NavXML;

public class WebpipeExecutorTest {

	private WebpipeExecutor fixture;
	private static final String path = "/webpipes/fvg/webpipe/crawling.xml";
	
	@Before
	public void setUp() throws Exception {
		File file = new File(path);
//		FileReader reader = new FileReader(file);
//		Document doc = new SAXBuilder().build(reader);
		
		StringBuffer fileData = this.readFromFile(path);
		
		Fonte f = new Fonte();
		NavXML xml = new NavXML();
		xml.setContentCrawling(fileData.toString());
		f.setXmlDescriber(xml);
		this.fixture = new WebpipeExecutor(path,"fvg");
	}

	private StringBuffer readFromFile(String path2) {
		StringBuffer fileData = new StringBuffer(1000);
        try {
			BufferedReader reader = new BufferedReader(
			        new FileReader(path));
			char[] buf = new char[1024];
			int numRead=0;
			while((numRead=reader.read(buf)) != -1){
			    String readData = String.valueOf(buf, 0, numRead);
			    fileData.append(readData);
			    buf = new char[1024];
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileData;
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testFireCrawling() {
		assertTrue(this.fixture.fireCrawling().size()>0);
	}

}
