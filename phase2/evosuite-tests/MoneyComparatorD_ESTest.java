/*
 * This file was automatically generated by EvoSuite
 * Mon Nov 12 22:21:10 GMT 2018
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
public class MoneyComparatorD_ESTest extends MoneyComparatorD_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MoneyComparatorD moneyComparatorD0 = new MoneyComparatorD();
      // Undeclared exception!
      try { 
        moneyComparatorD0.compare((Driver) null, (Driver) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("MoneyComparatorD", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      MoneyComparatorD moneyComparatorD0 = new MoneyComparatorD();
      LocalDate localDate0 = MockLocalDate.now();
      Driver driver0 = new Driver("f,Im2%)RX<", "f,Im2%)RX<", "f,Im2%)RX<", "f,Im2%)RX<", localDate0, 2217L, "f,Im2%)RX<");
      Boolean boolean0 = Boolean.FALSE;
      ArrayList<Trip> arrayList0 = driver0.getTrips();
      Driver driver1 = new Driver("f,Im2%)RX<", "f,Im2%)RX<", "f,Im2%)RX<", "f,Im2%)RX<", localDate0, 2217L, 0, boolean0, 2217L, arrayList0, 0, 2217L, 2217L, "f,Im2%)RX<", "f,Im2%)RX<", 2217L);
      int int0 = moneyComparatorD0.compare(driver0, driver1);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      MoneyComparatorD moneyComparatorD0 = new MoneyComparatorD();
      LocalDate localDate0 = MockLocalDate.now();
      Driver driver0 = new Driver("f,Im2%)RX<", "f,Im2%)RX<", "f,Im2%)RX<", "f,Im2%)RX<", localDate0, 2217L, "f,Im2%)RX<");
      Boolean boolean0 = Boolean.FALSE;
      ArrayList<Trip> arrayList0 = driver0.getTrips();
      Driver driver1 = new Driver("f,Im2%)RX<", "f,Im2%)RX<", "f,Im2%)RX<", "f,Im2%)RX<", localDate0, 2217L, 0, boolean0, 2217L, arrayList0, 0, 2217L, 2217L, "f,Im2%)RX<", "f,Im2%)RX<", 2217L);
      int int0 = moneyComparatorD0.compare(driver1, driver0);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      MoneyComparatorD moneyComparatorD0 = new MoneyComparatorD();
      LocalDate localDate0 = MockLocalDate.now();
      Driver driver0 = new Driver("J3.*`At8", "J3.*`At8", "Jb~v(c|Xkw?!m,r", "J3.*`At8", localDate0, (-4427.9), "J3.*`At8");
      int int0 = moneyComparatorD0.compare(driver0, driver0);
      assertEquals(0, int0);
  }
}