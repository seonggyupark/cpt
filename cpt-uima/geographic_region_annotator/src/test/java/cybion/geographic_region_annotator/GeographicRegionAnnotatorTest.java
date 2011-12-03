package cybion.geographic_region_annotator;

import cybion.annotator_utils.test.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GeographicRegionAnnotatorTest {
  
  
  private void testFile(String file){
    try {
      String geographicRegion = TestUtils.testWithFileAndCache("src/test/resources/AggregateGeographicRegionAEDescriptor.xml",file,"geographicRegion");
      assertTrue(geographicRegion!=null);
    }
    catch (Exception e) {
      fail(e.toString());
    }
  }

  @Test
  public void test1() {
    testFile("bandi/1.txt");
  }
  
  @Test
  public void test2() {
    testFile("bandi/2.txt");
  }
  
  @Test
  public void test3() {
    testFile("bandi/3.txt");
  }
  
  @Test
  public void test4() {
    testFile("bandi/4.txt");
  }
  
  @Test
  public void test5() {
    testFile("bandi/5.txt");
  }
  
  @Test
  public void test6() {
    testFile("bandi/6.txt");
  }

  @Test
  public void testFVG() {
    try {
      String geographicRegion = TestUtils.testWithFileAndCache("src/test/resources/AggregateGeographicRegionAEDescriptor.xml","bandi/fvg.txt","geographicRegion");
      assertTrue(geographicRegion==null);
    }
    catch (Exception e) {
      fail(e.toString());
    }
  }
}
