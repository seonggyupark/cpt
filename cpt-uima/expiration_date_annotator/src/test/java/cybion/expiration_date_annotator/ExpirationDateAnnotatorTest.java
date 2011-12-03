package cybion.expiration_date_annotator;

import cybion.annotator_utils.test.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ExpirationDateAnnotatorTest {
  
  private static final String FEATURE_NAME = "expirationDate";
  private static final String ANNOTATOR_DESCRIPTOR = "src/test/resources/AggregateExpirationDateAEDescriptor.xml";

  @Test
  public void test1() {
    try {
      String expirationDate = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/1.txt", FEATURE_NAME);
      assertTrue(expirationDate!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test2() {
    try {
      String expirationDate = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/2.txt", FEATURE_NAME);
      assertTrue(expirationDate!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test3() {
    try {
      String expirationDate = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/3.txt", FEATURE_NAME);
      assertTrue(expirationDate!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test4() {
    try {
      String expirationDate = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/4.txt", FEATURE_NAME);
      assertTrue(expirationDate!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test5() {
    try {
      String expirationDate = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/5.txt", FEATURE_NAME);
      assertTrue(expirationDate!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test6() {
    try {
      String expirationDate = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/6.txt", FEATURE_NAME);
      assertTrue(expirationDate!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void testFVG() {
    try {
      String expirationDate = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/fvg.txt", FEATURE_NAME);
      assertTrue(expirationDate!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

}
