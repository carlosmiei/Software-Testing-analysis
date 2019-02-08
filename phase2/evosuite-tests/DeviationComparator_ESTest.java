/*
 * This file was automatically generated by EvoSuite
 * Mon Nov 12 22:18:25 GMT 2018
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
public class DeviationComparator_ESTest extends DeviationComparator_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      DeviationComparator deviationComparator0 = new DeviationComparator();
      LocalDate localDate0 = MockLocalDate.now();
      Boolean boolean0 = Boolean.valueOf("QNIkfy6(9dRJ.o:");
      Driver driver0 = new Driver("U=6JiDrG@_%FsJ$Av%a", (String) null, (String) null, (String) null, localDate0, 1.0, "\nDesvio total : ");
      ArrayList<Trip> arrayList0 = driver0.getTrips();
      Driver driver1 = new Driver("DeviationComparator", "DeviationComparator", "QNIkfy6(9dRJ.o:", "DeviationComparator", localDate0, (-594.1509926376), (-594.1509926376), boolean0, (-594.1509926376), arrayList0, 0, 0.0, 0.0, "", (String) null, 1.0);
      int int0 = deviationComparator0.compare(driver0, driver1);
      assertEquals(17, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      DeviationComparator deviationComparator0 = new DeviationComparator();
      // Undeclared exception!
      try { 
        deviationComparator0.compare((Driver) null, (Driver) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("DeviationComparator", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      DeviationComparator deviationComparator0 = new DeviationComparator();
      LocalDate localDate0 = MockLocalDate.ofEpochDay((-162L));
      Boolean boolean0 = Boolean.TRUE;
      ArrayList<Trip> arrayList0 = new ArrayList<Trip>();
      Driver driver0 = new Driver("*G),]aYv", "*G),]aYv", "*G),]aYv", "*G),]aYv", localDate0, (-162L), (-162L), boolean0, (-162L), arrayList0, 14, (-162L), (-162L), "*G),]aYv", "*G),]aYv", 14);
      Driver driver1 = new Driver("*G),]aYv", "*G),]aYv", "*G),]aYv", "*G),]aYv", localDate0, 14, 0, boolean0, 14, arrayList0, 0, 14, 0, "*G),]aYv", "*G),]aYv", 0);
      int int0 = deviationComparator0.compare(driver0, driver1);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      DeviationComparator deviationComparator0 = new DeviationComparator();
      LocalDate localDate0 = MockLocalDate.ofEpochDay((-162L));
      Boolean boolean0 = Boolean.TRUE;
      ArrayList<Trip> arrayList0 = new ArrayList<Trip>();
      Driver driver0 = new Driver("*G),]aYv", "*G),]aYv", "*G),]aYv", "*G),]aYv", localDate0, (-162L), (-162L), boolean0, (-162L), arrayList0, 14, (-162L), (-162L), "*G),]aYv", "*G),]aYv", 14);
      int int0 = deviationComparator0.compare(driver0, driver0);
      assertEquals(0, int0);
  }
}
