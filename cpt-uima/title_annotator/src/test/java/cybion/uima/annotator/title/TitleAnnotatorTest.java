package cybion.uima.annotator.title;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.uima.jcas.JCas;
import org.apache.uima.test.junit_extension.JUnitExtension;
import org.apache.uima.util.FileUtils;
import org.junit.Test;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.test.TestUtils;

public class TitleAnnotatorTest {

  @Test
  public void test1() {
    testWithFile("b3.txt");
  }
  
  @Test
  public void test2() {
    testWithFile("EID.txt");
  }
  
  @Test
  public void test3() {
    testWithFile("EuropeAid.txt");
  }
  
  @Test
  public void test4() {
    testWithFile("FP7.txt");
  }
  
  @Test
  public void test5() {
    testWithFile("IARC.txt");
  }
  
  @Test
  public void test6() {
    testWithFile("OJS62.txt");
  }
  
  
  
  
  private void testWithFile(String file) {
    try {
      String xmlPath = "desc/AggregateTitleAEDescriptor.xml";
      String doc = FileUtils.file2String(JUnitExtension.getFile(file));

      JCas resultingCAS = TestUtils.executeAE(TestUtils.getAE(xmlPath), doc);

      assertTrue(resultingCAS!=null);
      String title = AnnotatorUtils.getBandoEntityWithCreation(resultingCAS).getTitle();
      System.err.println("----------------");
      System.err.println("----------------");
      System.err.println("TITLE: "+title);
      System.err.println("----------------");
      System.err.println("----------------");
      assertTrue(title!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }
  }

}
