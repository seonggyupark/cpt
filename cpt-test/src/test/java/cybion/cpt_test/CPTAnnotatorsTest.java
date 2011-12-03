package cybion.cpt_test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CollectionProcessingManager;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.test.junit_extension.JUnitExtension;
import org.apache.uima.util.CasCreationUtils;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.Level;
import org.apache.uima.util.ProcessTrace;
import org.apache.uima.util.ProcessTraceEvent;
import org.apache.uima.util.XMLInputSource;
import org.junit.Before;
import org.junit.Test;

public class CPTAnnotatorsTest {

  private CollectionProcessingManager mCPM;

  @Before
  public void setUp() {
    mCPM = UIMAFramework.newCollectionProcessingManager();
  }

  private CollectionReader setBandiToAnalyze() throws InvalidXMLException, IOException,
          ResourceInitializationException {

    // the CPM will scan the src/test/resources/bandi dir and get all the files

    ResourceSpecifier colReaderSpecifier = UIMAFramework.getXMLParser()
            .parseCollectionReaderDescription(
                    new XMLInputSource(JUnitExtension.getFile("FileSystemBandiCollectionReader.xml")));
    CollectionReader collectionReader = UIMAFramework.produceCollectionReader(colReaderSpecifier);
    return collectionReader;
  }

  @Test
  public void testAllCPTAnnotators() {
    try {

      // create a new Collection Processing Manager
      mCPM = UIMAFramework.newCollectionProcessingManager();

      // set the (aggregate) ae that will scan the docs
      setAE();

      // Create and register a Status Callback Listener
      mCPM.addStatusCallbackListener(new DummyStatusCallbackListenerImpl(mCPM.getAnalysisEngine().getLogger()));

      // Finish setup
      mCPM.setPauseOnException(true);
      
      // Start Processing (in batches of 10, just for testing purposes)
      mCPM.process(setBandiToAnalyze(), 10);

      ProcessTrace pt = mCPM.getPerformanceReport();
      for (ProcessTraceEvent event : pt.getEvents()) {
        mCPM.getAnalysisEngine().getLogger().log(Level.INFO,event.getComponentName() + "-" + event.getType() + "-"
                + event.getDuration());
      }
      while (true) {
        System.err.println(mCPM.getProgress());
      }
      // TODO get all the features to extract from the bandi
      // BandoEntity bandoEntity = new BandoEntity(cas.getJCas());

      // TODO get the annotator for each feature

      // TODO for each feature and for each bando verify the feature is extracted by the annotator
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }

  }

  private void setAE() throws InvalidXMLException, IOException, ResourceInitializationException,
          ResourceConfigurationException {
    File descriptor = new File(
            "../cpt-uima/aggregate_annotator/desc/AggregateCybionAEDescriptor.xml");
    XMLInputSource aInput = new XMLInputSource(descriptor);
    ResourceSpecifier aeSpecifier = UIMAFramework.getXMLParser().parseResourceSpecifier(aInput);
    AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(aeSpecifier);
    assert ae != null;
    mCPM.setAnalysisEngine(ae);
  }

  private CAS setCASUp() throws IOException, InvalidXMLException, ResourceInitializationException {

    XMLInputSource in = new XMLInputSource(JUnitExtension.getFile("CPT_TSDescriptor.xml"));
    TypeSystemDescription typeSystemDescription = UIMAFramework.getXMLParser()
            .parseTypeSystemDescription(in);
    CAS cas = CasCreationUtils.createCas(typeSystemDescription, null, null);
    return cas;

  }

}
