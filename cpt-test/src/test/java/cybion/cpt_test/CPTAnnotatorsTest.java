package cybion.cpt_test;

import java.io.File;
import java.io.IOException;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.collection.CasConsumer;
import org.apache.uima.collection.CollectionProcessingManager;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.test.junit_extension.JUnitExtension;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.Level;
import org.apache.uima.util.ProcessTrace;
import org.apache.uima.util.ProcessTraceEvent;
import org.apache.uima.util.Progress;
import org.apache.uima.util.XMLInputSource;
import org.junit.Before;
import org.junit.Test;

public class CPTAnnotatorsTest {

    private CollectionProcessingManager mCPM;

    @Before
    public void setUp() {
        mCPM = UIMAFramework.newCollectionProcessingManager();
    }

    private CollectionReader getCollectionReader() throws InvalidXMLException, IOException,
            ResourceInitializationException {

        // the CPM will scan the src/test/resources/bandi dir and get all the files

        ResourceSpecifier colReaderSpecifier = UIMAFramework.getXMLParser()
                .parseCollectionReaderDescription(
                        new XMLInputSource(JUnitExtension.getFile("FileSystemBandiCollectionReader.xml")));
        return UIMAFramework.produceCollectionReader(colReaderSpecifier);
    }

    @Test
    public void testAllCPTAnnotators() throws Exception {
        // create a new Collection Processing Manager
        mCPM = UIMAFramework.newCollectionProcessingManager();

        // set the (aggregate) ae that will scan the docs
        setAE();

        // Create and register a Status Callback Listener
        mCPM.addStatusCallbackListener(new DummyStatusCallbackListenerImpl(mCPM.getAnalysisEngine().getLogger()));

        // Finish setup
        mCPM.setPauseOnException(true);

        // Start Processing (in batches of 10, just for testing purposes)
        mCPM.process(getCollectionReader(), 10);

        while (mCPM.isProcessing()) {
            for (Progress p : mCPM.getProgress()) {
                System.out.println(p.getUnit() + ": " + p.getCompleted() + "/" + p.getTotal());
            }
        }

        ProcessTrace pt = mCPM.getPerformanceReport();
        for (ProcessTraceEvent event : pt.getEvents()) {
            System.out.println(event.getComponentName() + "-" + event.getType() + "-"
                    + event.getDuration());
        }

        // TODO get all the features to extract from the grant proposals

        // TODO get the annotator for each feature

        // TODO for each feature and for each bando verify the feature is extracted by the annotator

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

        File consumerDesc = new File(getClass().getResource("/XmiWriterCasConsumer.xml").getFile());
        XMLInputSource consumerXML = new XMLInputSource(consumerDesc);
        ResourceSpecifier consumerSpecifier = UIMAFramework.getXMLParser().parseResourceSpecifier(consumerXML);
        CasConsumer consumer = UIMAFramework.produceCasConsumer(consumerSpecifier);
        assert consumer != null;

        mCPM.addCasConsumer(consumer);
    }

//  private CAS setCASUp() throws IOException, InvalidXMLException, ResourceInitializationException {
//
//    XMLInputSource in = new XMLInputSource(JUnitExtension.getFile("CPT_TSDescriptor.xml"));
//    TypeSystemDescription typeSystemDescription = UIMAFramework.getXMLParser()
//            .parseTypeSystemDescription(in);
//      return CasCreationUtils.createCas(typeSystemDescription, null, null);
//
//  }

}
