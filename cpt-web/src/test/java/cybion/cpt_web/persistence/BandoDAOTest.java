package cybion.cpt_web.persistence;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cybion.cpt_web.model.Bando;

public class BandoDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Bando bando;

	public Bando getBando() {
		return bando;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}

	@Before
	public void setUp() throws Exception {
		
		Bando b = new Bando();
		b.setIdBando(3);
		b.setTitolo("titolo");
		b.setAttivita("attivita");
		b.setTestoIntegrale("testo integrale");
		b.setBeneficiario("beneficiario");
		b.setBudget("100.000");
		b.setDataScadenza("domani");
		b.setEnte("ente");
		b.setLinkAllaFonte("http://www.uniroma3.it");
		b.setNote("note");
		b.setOggetto("oggetto del bando");
		b.setPercFinanziamento("0.2");
		b.setRegGeografica("europa");
		List <String> tagList = new LinkedList<String>();
		tagList.add("tag1");tagList.add("tag2");tagList.add("tag3");
		b.setTagList(tagList.toString());
		b.setTimestamp(new Date());
		b.setTipoFinanziamento("tipo finanziamento");
		this.bando = b;
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsertBando() {
		try {
			ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/persistenceContext.xml");
			PersistenceBroker broker = (PersistenceBroker) ctx.getBean("persistenceBroker");
			Bando b = this.getBando();
			broker.saveBando(b);
		} catch (BeansException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}


}
