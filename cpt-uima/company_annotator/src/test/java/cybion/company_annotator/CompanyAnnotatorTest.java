package cybion.company_annotator;

import cybion.annotator_utils.AnnotatorUtils;
import cybion.annotator_utils.test.TestUtils;
import org.apache.uima.calais.Company;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.test.junit_extension.JUnitExtension;
import org.apache.uima.util.FileUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class CompanyAnnotatorTest {

  private static final String FEATURE_NAME = "companies";
  private static final String ANNOTATOR_DESCRIPTOR = "desc/CompanyAggregateAEDescriptor.xml";

  @Test
  public void test1() {
    try {
      String doc = FileUtils.file2String(JUnitExtension.getFile("bandi/1.txt"));
      JCas cas = TestUtils.executeAE(TestUtils.getAE(ANNOTATOR_DESCRIPTOR), doc);
      assertTrue(cas != null);
      List<Annotation> calaisCompany = AnnotatorUtils.getAnnotations(Company.type, cas);
      assertTrue(calaisCompany != null);
      assertTrue(calaisCompany.size() == 0);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test2() {
    try {
      String doc = FileUtils.file2String(JUnitExtension.getFile("bandi/2.txt"));
      JCas cas = TestUtils.executeAE(TestUtils.getAE(ANNOTATOR_DESCRIPTOR), doc);
      assertTrue(cas != null);
      List<Annotation> calaisCompany = AnnotatorUtils.getAnnotations(Company.type, cas);
      assertTrue(calaisCompany != null);
      assertTrue(calaisCompany.size() == 0);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test3() {
    try {
      String doc = FileUtils.file2String(JUnitExtension.getFile("bandi/3.txt"));
      JCas cas = TestUtils.executeAE(TestUtils.getAE(ANNOTATOR_DESCRIPTOR), doc);
      assertTrue(cas != null);
      List<Annotation> calaisCompany = AnnotatorUtils.getAnnotations(Company.type, cas);
      assertTrue(calaisCompany != null);
      assertTrue(calaisCompany.size() == 0);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test4() {
    try {
      String doc = FileUtils.file2String(JUnitExtension.getFile("bandi/4.txt"));
      JCas cas = TestUtils.executeAE(TestUtils.getAE(ANNOTATOR_DESCRIPTOR), doc);
      assertTrue(cas != null);
      List<Annotation> calaisCompany = AnnotatorUtils.getAnnotations(Company.type, cas);
      assertTrue(calaisCompany != null);
      assertTrue(calaisCompany.size() == 0);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test5() {
    try {
      String doc = FileUtils.file2String(JUnitExtension.getFile("bandi/5.txt"));
      JCas cas = TestUtils.executeAE(TestUtils.getAE(ANNOTATOR_DESCRIPTOR), doc);
      assertTrue(cas != null);
      List<Annotation> calaisCompany = AnnotatorUtils.getAnnotations(Company.type, cas);
      assertTrue(calaisCompany != null);
      assertTrue(calaisCompany.size() > 0);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test6() {
    try {
      String doc = FileUtils.file2String(JUnitExtension.getFile("bandi/6.txt"));
      JCas cas = TestUtils.executeAE(TestUtils.getAE(ANNOTATOR_DESCRIPTOR), doc);
      assertTrue(cas != null);
      List<Annotation> calaisCompany = AnnotatorUtils.getAnnotations(Company.type, cas);
      assertTrue(calaisCompany != null);
      assertTrue(calaisCompany.size() > 0);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
}
