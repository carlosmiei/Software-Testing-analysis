/*
 * This file was automatically generated by EvoSuite
 * Mon Nov 12 22:10:46 GMT 2018
 */


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockLocalDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class RatingComparator_ESTest extends RatingComparator_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      RatingComparator ratingComparator0 = new RatingComparator();
      // Undeclared exception!
      try { 
        ratingComparator0.compare((Driver) null, (Driver) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("RatingComparator", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      RatingComparator ratingComparator0 = new RatingComparator();
      LocalDate localDate0 = MockLocalDate.now();
      Boolean boolean0 = Boolean.TRUE;
      Driver driver0 = new Driver("bYI", "bYI", "bYI", "bYI", localDate0, 27, "bYI");
      ArrayList<Trip> arrayList0 = new ArrayList<Trip>();
      Driver driver1 = new Driver("bYI", "bYI", "bYI", "bYI", localDate0, 27, 27, boolean0, 27, arrayList0, 27, 27, 27, "bYI", "bYI", 27);
      int int0 = ratingComparator0.compare(driver0, driver1);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      RatingComparator ratingComparator0 = new RatingComparator();
      LocalDate localDate0 = MockLocalDate.now();
      Boolean boolean0 = Boolean.TRUE;
      Driver driver0 = new Driver("bYI", "bYI", "bYI", "bYI", localDate0, 27, "bYI");
      ArrayList<Trip> arrayList0 = new ArrayList<Trip>();
      Driver driver1 = new Driver("bYI", "bYI", "bYI", "bYI", localDate0, 27, 27, boolean0, 27, arrayList0, 27, 27, 27, "bYI", "bYI", 27);
      int int0 = ratingComparator0.compare(driver1, driver0);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      RatingComparator ratingComparator0 = new RatingComparator();
      LocalDate localDate0 = MockLocalDate.now();
      Driver driver0 = new Driver("bYI", "bYI", "bYI", "bYI", localDate0, 27, "bYI");
      int int0 = ratingComparator0.compare(driver0, driver0);
      assertEquals(0, int0);
  }
}
