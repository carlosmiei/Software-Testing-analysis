/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 04 16:45:21 GMT 2018
 */
package ats;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockLocalDate;
import org.evosuite.runtime.mock.java.time.chrono.MockIsoChronology;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class DeviationComparatorTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      DeviationComparator deviationComparator0 = new DeviationComparator();
      LocalDate localDate0 = MockLocalDate.now();
      Boolean boolean0 = Boolean.FALSE;
      Driver driver0 = new Driver("Pqi/1+%/I:'?", "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", localDate0, 45.33526782580838, "Pqi/1+%/I:'?");
      ArrayList<Trip> arrayList0 = new ArrayList<Trip>();
      Driver driver1 = new Driver("Pqi/1+%/I:'?", "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", localDate0, 45.33526782580838, 45.33526782580838, boolean0, 45.33526782580838, arrayList0, (-74), 45.33526782580838, 45.33526782580838, "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", 45.33526782580838);
      int int0 = deviationComparator0.compare(driver0, driver1);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      DeviationComparator deviationComparator0 = new DeviationComparator();
      LocalDate localDate0 = MockLocalDate.ofEpochDay(0L);
      Boolean boolean0 = Boolean.valueOf("");
      Driver driver0 = new Driver("", "?zX<2b[", "?zX<2b[", "-_uIU^@Jl>", localDate0, (-602.546461553), "?zX<2b[");
      ArrayList<Trip> arrayList0 = driver0.getTrips();
      Driver driver1 = new Driver("w;T", "w;T", "-_uIU^@Jl>", "-_uIU^@Jl>", localDate0, 0L, (-602.546461553), boolean0, (-602.546461553), arrayList0, 0, 0.0, (-602.546461553), "\nClassifica\u00E7\u00E3o : ", "\nClassifica\u00E7\u00E3o : ", 0);
      int int0 = deviationComparator0.compare(driver1, driver0);
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      DeviationComparator deviationComparator0 = new DeviationComparator();
      Period period0 = Period.ofYears(0);
      IsoChronology isoChronology0 = period0.getChronology();
      LocalDate localDate0 = MockIsoChronology.dateNow(isoChronology0);
      Driver driver0 = new Driver("", "Driver", "", "DeviationComparator", localDate0, 0, "");
      // Undeclared exception!
      try { 
        deviationComparator0.compare(driver0, (Driver) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
//         verifyException("DeviationComparator", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      DeviationComparator deviationComparator0 = new DeviationComparator();
      LocalDate localDate0 = MockLocalDate.now();
      Boolean boolean0 = Boolean.FALSE;
      Driver driver0 = new Driver("Pqi/1+%/I:'?", "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", localDate0, 45.33526782580838, "Pqi/1+%/I:'?");
      ArrayList<Trip> arrayList0 = new ArrayList<Trip>();
      Driver driver1 = new Driver("Pqi/1+%/I:'?", "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", localDate0, 45.33526782580838, 45.33526782580838, boolean0, 45.33526782580838, arrayList0, (-74), 45.33526782580838, 45.33526782580838, "Pqi/1+%/I:'?", "Pqi/1+%/I:'?", 45.33526782580838);
      int int0 = deviationComparator0.compare(driver1, driver0);
      assertEquals((-1), int0);
  }
}
