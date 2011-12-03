package cybion.activity_annotator;

import cybion.annotator_utils.test.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ActivityAnnotatorTest {
  
  private static final String FEATURE_NAME = "activity";
  private static final String ACTIVITY_DESCRIPTOR = "src/test/resources/AggregateActivityDescriptor.xml";

  @Test
  public void test1() {
    try {
      String activity = TestUtils.testWithFileAndCache(ACTIVITY_DESCRIPTOR, "bandi/b3.txt", FEATURE_NAME);
      assertTrue(activity!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test2() {
    try {
      String activity = TestUtils.testWithFileAndCache(ACTIVITY_DESCRIPTOR, "bandi/EID.txt", FEATURE_NAME);
      assertTrue(activity==null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test3() {
    try {
      String activity = TestUtils.testWithFileAndCache(ACTIVITY_DESCRIPTOR, "bandi/EuropeAid.txt", FEATURE_NAME);
      assertTrue(activity==null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test4() {
    try {
      String activity = TestUtils.testWithFileAndCache(ACTIVITY_DESCRIPTOR, "bandi/FP7.txt", FEATURE_NAME);
      assertTrue(activity==null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test5() {
    try {
      String activity = TestUtils.testWithFileAndCache(ACTIVITY_DESCRIPTOR, "bandi/IARC.txt", FEATURE_NAME);
      assertTrue(activity==null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  @Test
  public void test6() {
    try {
      String activity = TestUtils.testWithFileAndCache(ACTIVITY_DESCRIPTOR, "bandi/OJS62.txt", FEATURE_NAME);
      assertTrue(activity!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void testFVG() {
    try {
      String activity = TestUtils.testWithFileAndCache(ACTIVITY_DESCRIPTOR, "bandi/fvg.txt", FEATURE_NAME);
      assertTrue(activity!=null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

}
