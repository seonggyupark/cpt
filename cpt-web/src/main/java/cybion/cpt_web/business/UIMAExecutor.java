package cybion.cpt_web.business;

import java.util.Iterator;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.ProcessTrace;
import org.apache.uima.util.ProcessTraceEvent;
import org.apache.uima.util.XMLInputSource;

import cybion.cpt_web.model.Bando;
import cybion.cpt_web.model.Metadata;
import cybion.cpt_web.model.builder.BandoBuilder;
import cybion.uima.ts.BandoEntity;

/**
 * 
 * @author tommaso
 * 
 */
public class UIMAExecutor {

  private final String defaultXMLPath = "../aggregate_annotator/desc/AggregateCybionAEDescriptor.xml";

  private AnalysisEngine ae = null;

  public UIMAResult analyzeDocument(String doc) throws Exception {
    return this.executeAE(this.getAE(defaultXMLPath), doc);
  }

  public UIMAResult analyzeDocument(String doc, String xmlPath) throws Exception {
    return this.executeAE(this.getAE(xmlPath), doc);
  }

  private AnalysisEngine getAE(String filePath) throws Exception {
    if (this.ae == null) {
      AnalysisEngine ae = null;
      try {
        // get Resource Specifier from XML file
        XMLInputSource in = new XMLInputSource(filePath);
        ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(in);

        // create AE here
        ae = UIMAFramework.produceAnalysisEngine(specifier);

      } catch (Exception e) {
        e.printStackTrace();
        throw (e);
      }
      this.ae = ae;
    }
    else {
      // if the ae already exists then it must be reconfigured to be executed again
      ae.reconfigure();
    }

    return this.ae;
  }

  private UIMAResult executeAE(AnalysisEngine ae, String docText)
          throws AnalysisEngineProcessException {
    UIMAResult toReturn = new UIMAResult();
    try {
      // create a JCas, given an Analysis Engine (ae)
      JCas jcas = ae.newJCas();

      // analyze a document
      jcas.setDocumentText(docText);
      ProcessTrace pt = ae.process(jcas);

      // analyze results
      for (Object eventObject : pt.getEvents()) {
        try {
          ProcessTraceEvent e = (ProcessTraceEvent) eventObject;
          System.err.println(e.getComponentName() + " (" + e.getType() + ") - "
                  + e.getDescription() + " (" + e.getDuration() + ") : " + e.getResultMessage());
          if (e != null && e.getResultMessage() != null && e.getResultMessage().contains("error")) {
            throw new AnalysisEngineProcessException();
          }
        } catch (ClassCastException cce) {
          cce.printStackTrace();
        }
      }
      for (Iterator<FSIndex<FeatureStructure>> it = jcas.getFSIndexRepository().getIndexes(); it
              .hasNext();) {
        FSIndex<FeatureStructure> index = it.next();
        for (FeatureStructure fs : index) {
          try {
            // handle annotations
            if (fs instanceof AnnotationFS || fs instanceof Annotation) {
              AnnotationFS annotationFS = (AnnotationFS) fs;
              Metadata metadata = new Metadata();
              metadata.setBegin("" + annotationFS.getBegin());
              metadata.setEnd("" + annotationFS.getEnd());
              metadata.setText(annotationFS.getCoveredText());
              metadata.setType(annotationFS.getType().getName());
              toReturn.getMetadatas().add(metadata);
            } else if (fs instanceof BandoEntity) {
              Bando bando = new BandoBuilder((BandoEntity) fs).build();
              toReturn.setBando(bando);
            }
            // handle simple feature structures
            else {
              Metadata metadata = new Metadata();
              Type type = fs.getType();
              if (fs instanceof Annotation) {
                try {
                  metadata.setText(((Annotation) fs).getCoveredText());
                } catch (Exception e) {
                }
              } else {
                try {
                  metadata.setText(fs.getStringValue(type.getFeatureByBaseName("text")));
                } catch (Exception e) {
                }
              }
              metadata.setType(type.getName());
              toReturn.getMetadatas().add(metadata);
            }

          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }

      jcas.reset();
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
    return toReturn;

  }

}
