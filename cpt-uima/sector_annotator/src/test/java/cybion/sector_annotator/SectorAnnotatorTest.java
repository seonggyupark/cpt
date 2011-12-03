package cybion.sector_annotator;

import org.junit.Test;

import cybion.annotator_utils.test.TestUtils;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

public class SectorAnnotatorTest {
  
  
  private void testFile(String file){
    try {
      String category = TestUtils.testWithFileAndCache("src/test/resources/AggregateSectorAEDescriptor.xml",file,"category");
      assertTrue(category!=null);
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
}
