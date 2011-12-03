/**
 * 	Licensed to the Apache Software Foundation (ASF) under one
 * 	or more contributor license agreements.  See the NOTICE file
 * 	distributed with this work for additional information
 * 	regarding copyright ownership.  The ASF licenses this file
 * 	to you under the Apache License, Version 2.0 (the
 * 	"License"); you may not use this file except in compliance
 * 	with the License.  You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * 	Unless required by applicable law or agreed to in writing,
 * 	software distributed under the License is distributed on an
 * 	"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * 	KIND, either express or implied.  See the License for the
 * 	specific language governing permissions and limitations
 * 	under the License.
 */
package cybion.annotator_utils.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.test.junit_extension.JUnitExtension;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.ProcessTrace;
import org.apache.uima.util.ProcessTraceEvent;
import org.apache.uima.util.XMLInputSource;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.uima.ts.BandoEntity;

public class TestUtils {

  private static Map<String, AnalysisEngine> cache = new WeakHashMap<String, AnalysisEngine>();

  /**
   * get an AE from a path of the descriptor
   * 
   * @param filePath
   * @return
   * @throws IOException
   * @throws InvalidXMLException
   * @throws ResourceInitializationException
   * @throws ResourceConfigurationException
   */
  public static AnalysisEngine getCachedAE(String filePath) throws IOException,
          InvalidXMLException, ResourceInitializationException, ResourceConfigurationException {
    AnalysisEngine cachedAnalysisEngine = cache.get(filePath);
    if (cachedAnalysisEngine == null) {
      // get Resource Specifier from XML file
      XMLInputSource in = new XMLInputSource(filePath);
      ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(in);

      // create AE here
      cachedAnalysisEngine = UIMAFramework.produceAnalysisEngine(specifier);
      cache.put(filePath, cachedAnalysisEngine);
    } else {
      cachedAnalysisEngine.reconfigure();
    }
    return cachedAnalysisEngine;
  }

  /**
   * get an AE from a path of the descriptor
   * 
   * @param filePath
   * @return
   * @throws IOException
   * @throws InvalidXMLException
   * @throws ResourceInitializationException
   */
  public static AnalysisEngine getAE(String filePath) throws IOException, InvalidXMLException,
          ResourceInitializationException {
    AnalysisEngine ae = null;
    // get Resource Specifier from XML file
    XMLInputSource in = new XMLInputSource(filePath);
    ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(in);

    // create AE here
    ae = UIMAFramework.produceAnalysisEngine(specifier);

    return ae;
  }

  /**
   * executes an AE on a document
   * 
   * @param ae
   * @param docText
   * @return
   * @throws AnalysisEngineProcessException
   * @throws ResourceInitializationException
   */
  public static JCas executeAE(AnalysisEngine ae, String docText)
          throws AnalysisEngineProcessException, ResourceInitializationException {
    // create a JCas, given an Analysis Engine (ae)
    JCas jcas = ae.newJCas();

    // analyze a document
    jcas.setDocumentText(docText);
    ProcessTrace pt = ae.process(jcas);

    // analyze results
    for (ProcessTraceEvent e : pt.getEvents()) {
      if (e != null && e.getResultMessage() != null && e.getResultMessage().contains("error")) {
        throw new AnalysisEngineProcessException();
      }
    }
    return jcas;
  }

  /**
   * get all FeatureStructures of a type from the CAS
   * 
   * @param type
   * @param cas
   * @return
   */
  public static List<? extends FeatureStructure> getAllFSofType(int type, JCas cas) {
    List<FeatureStructure> featureStructures = new ArrayList<FeatureStructure>();
    for (FSIterator<FeatureStructure> it = cas.getFSIndexRepository().getAllIndexedFS(
            cas.getCasType(type)); it.hasNext();) {
      featureStructures.add(it.next());
    }
    return featureStructures;
  }

  public static String testWithFile(String xmlPath, String file, String featureName)
          throws AnalysisEngineProcessException, ResourceInitializationException,
          InvalidXMLException, IOException {
    String doc = FileUtils.file2String(JUnitExtension.getFile(file));

    JCas resultingCAS = executeAE(getAE(xmlPath), doc);

    BandoEntity bandoEntity = AnnotatorUtils.getBandoEntityWithCreation(resultingCAS);
    Feature feat = bandoEntity.getType().getFeatureByBaseName(featureName);
    String toReturn = bandoEntity.getFeatureValueAsString(feat);
    System.err.println("----------------");
    System.err.println("----------------");
    System.err.println(featureName + ": " + toReturn);
    System.err.println("----------------");
    System.err.println("----------------");
    return toReturn;
  }

  public static String testWithFileAndCache(String xmlPath, String file, String featureName)
          throws AnalysisEngineProcessException, ResourceInitializationException,
          InvalidXMLException, IOException, ResourceConfigurationException {
    String doc = FileUtils.file2String(JUnitExtension.getFile(file));

    JCas resultingCAS = executeAE(getCachedAE(xmlPath), doc);

    BandoEntity bandoEntity = AnnotatorUtils.getBandoEntityWithCreation(resultingCAS);
    Feature feat = bandoEntity.getType().getFeatureByBaseName(featureName);
    String toReturn = bandoEntity.getFeatureValueAsString(feat);
    System.err.println("----------------");
    System.err.println("----------------");
    System.err.println(featureName + ": " + toReturn);
    System.err.println("----------------");
    System.err.println("----------------");
    return toReturn;
  }

}
