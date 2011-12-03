package cybion.beneficiary_annotator;

import cybion.annotator_utils.test.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BeneficiaryAnnotatorTest {
  
  private static final String FEATURE_NAME = "beneficiary";
  private static final String BENEFICIARY_DESCRIPTOR = "src/test/resources/AggregateBeneficiaryDescriptor.xml";

  @Test
  public void test1() {
    try {
      String beneficiary = TestUtils.testWithFileAndCache(BENEFICIARY_DESCRIPTOR, "bandi/b3.txt", FEATURE_NAME);
      assertTrue(beneficiary!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test2() {
    try {
      String beneficiary = TestUtils.testWithFileAndCache(BENEFICIARY_DESCRIPTOR, "bandi/EID.txt", FEATURE_NAME);
      assertTrue(beneficiary==null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test3() {
    try {
      String beneficiary = TestUtils.testWithFileAndCache(BENEFICIARY_DESCRIPTOR, "bandi/EuropeAid.txt", FEATURE_NAME);
      assertTrue(beneficiary==null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test4() {
    try {
      String beneficiary = TestUtils.testWithFileAndCache(BENEFICIARY_DESCRIPTOR, "bandi/FP7.txt", FEATURE_NAME);
      assertTrue(beneficiary==null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test5() {
    try {
      String beneficiary = TestUtils.testWithFileAndCache(BENEFICIARY_DESCRIPTOR, "bandi/IARC.txt", FEATURE_NAME);
      assertTrue(beneficiary!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test6() {
    try {
      String beneficiary = TestUtils.testWithFileAndCache(BENEFICIARY_DESCRIPTOR, "bandi/OJS62.txt", FEATURE_NAME);
      assertTrue(beneficiary!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void testFVG() {
    try {
      String beneficiary = TestUtils.testWithFileAndCache(BENEFICIARY_DESCRIPTOR, "bandi/fvg.txt", FEATURE_NAME);
      assertTrue(beneficiary!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
}
