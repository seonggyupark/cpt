package cybion.funding_type_annotator;

import cybion.annotator_utils.test.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class FundingTypeAnnotatorTest {

  private static final String FEATURE_NAME = "fundingType";
  private static final String ANNOTATOR_DESCRIPTOR = "src/test/resources/AggregateFundingTypeAEDescriptor.xml";

  @Test
  public void test1() {
    try {
      String fundingType = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/1.txt", FEATURE_NAME);
      assertTrue(fundingType!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test2() {
    try {
      String fundingType = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/2.txt", FEATURE_NAME);
      assertTrue(fundingType!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test3() {
    try {
      String fundingType = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/3.txt", FEATURE_NAME);
      assertTrue(fundingType!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test4() {
    try {
      String fundingType = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/4.txt", FEATURE_NAME);
      assertTrue(fundingType!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test5() {
    try {
      String fundingType = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/5.txt", FEATURE_NAME);
      assertTrue(fundingType!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test6() {
    try {
      String fundingType = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/6.txt", FEATURE_NAME);
      assertTrue(fundingType!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
}
