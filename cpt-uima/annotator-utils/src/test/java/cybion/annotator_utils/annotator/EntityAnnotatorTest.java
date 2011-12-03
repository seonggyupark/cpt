package cybion.annotator_utils.annotator;

import java.util.Iterator;

import junit.framework.TestCase;

import org.apache.uima.Constants;
import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.impl.AnalysisEngineDescription_impl;
import org.apache.uima.cas.CAS;
import org.apache.uima.internal.util.AnalysisEnginePool;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.resource.metadata.impl.TypeSystemDescription_impl;
import org.apache.uima.test.junit_extension.JUnitExtension;

import cybion.annotator_utils.jcas.cas.Entity;

public class EntityAnnotatorTest extends TestCase {

	private final String doc = "UIMA stands for Unstructured Information Management Architecture. It is a component software architecture for the development, discovery, composition, and deployment of multi-modal analytics for the analysis of unstructured information and its integration with search technologies developed by IBM. The source code for a reference implementation of this framework has been made available on SourceForge, and later on Apache Software Foundation website."
			+ " An example would be a logistics analysis software system that could convert unstructured data such as repair logs and service notes into relational tables. These tables can then be used by automated tools to detect maintenance or manufacturing problems."
			+ "Other examples are systems that are used in medical environments to analyze clinical notes.";
	
	
	
	
	
	private AnalysisEngineDescription_impl mSimpleDesc;
//	private ResultSpecification_impl rs;

	protected void setUp() throws Exception {
		try {
			super.setUp();
//			this.rs = new ResultSpecification_impl();
//			TypeSystemMgr typeSystemMgr = new TypeSystemImpl();
//			typeSystemMgr.addType("org.apache.uima.jcas.cas.Entity",typeSystemMgr.getTopType());
//			this.rs.compile(typeSystemMgr); 
			
			mSimpleDesc = new AnalysisEngineDescription_impl();
			mSimpleDesc.setFrameworkImplementation(Constants.JAVA_FRAMEWORK_NAME);
			mSimpleDesc.setPrimitive(true);
			mSimpleDesc.getMetaData().setName("Test EntityAnnotator TAE");
			mSimpleDesc.setAnnotatorImplementationName("cybion.annotator_utils.annotator.DummyEntityAnnotator");
			mSimpleDesc.getMetaData().setName("Simple Test");
			TypeSystemDescription aTypeSystem = new TypeSystemDescription_impl();
			aTypeSystem.addType("cybion.annotator_utils.jcas.cas.Entity", "entity type", "uima.cas.TOP");
			mSimpleDesc.getAnalysisEngineMetaData().setTypeSystem(aTypeSystem );
		} catch (Exception e) {
			JUnitExtension.handleException(e);
		}
	}
	
	
	public void testEntityAnnotator() {
		try {
		  
		  //FIXME
//			AnalysisEnginePool aPool = new AnalysisEnginePool("dae",1,mSimpleDesc);
//			aPool.setResultSpecification(this.rs);
//			this.testProcess(aPool , 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		} 
	}

	protected void testProcess(AnalysisEnginePool aPool, int i)
			throws UIMAException {
		AnalysisEngine tae = aPool.getAnalysisEngine(i);
		try {
			CAS tcas = tae.newCAS();
			tcas.setDocumentText(doc);
			
			System.out.println(".................................");
			System.out.println(tcas.getTypeSystem());
			System.out.println(".................................");

			
			tae.process(tcas);
			for (Iterator it = tcas.getJCas().getAnnotationIndex(Entity.type).iterator();it.hasNext();) {
				Entity entity = (Entity) it.next();
				assert entity != null : "entity must be not null";
				System.err.println("ENTITY ---->>>>>>"+entity.getText());
				assert entity.getOccurencies().size() > 0 : "unless one occurency of entity";
				System.err.println("ENTITY OCCURRENCIES----->>>>>>>"+entity.getOccurencies().size());
			}
			
			tcas.reset();

		} finally {
			aPool.releaseAnalysisEngine(tae);
		}
	}


}
