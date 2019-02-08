/*
 * This file was automatically generated by EvoSuite
 * Mon Nov 12 22:09:35 GMT 2018
 */


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.geom.Point2D;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Van_ESTest extends Van_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Point2D.Double point2D_Double0 = new Point2D.Double(0.0, 0.0);
      Van van0 = new Van("3[>_Zs", 0.0, point2D_Double0, "");
      Van van1 = van0.clone();
      assertEquals(9, van1.getSeats());
      assertEquals(55.0, van1.getSpeed(), 0.01);
      assertEquals(55.0, van0.getSpeed(), 0.01);
      assertEquals(1.9, van1.getPrice(), 0.01);
      assertEquals(9, van0.getSeats());
      assertEquals(1.9, van0.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Point2D.Double point2D_Double0 = new Point2D.Double();
      Van van0 = new Van("Htv", 60.0, point2D_Double0, (String) null);
      Van van1 = van0.clone();
      assertEquals(1.9, van1.getPrice(), 0.01);
      assertEquals(9, van0.getSeats());
      assertEquals(9, van1.getSeats());
      assertEquals(55.0, van1.getSpeed(), 0.01);
      assertEquals(1.9, van0.getPrice(), 0.01);
      assertEquals(55.0, van0.getSpeed(), 0.01);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Point2D.Double point2D_Double0 = new Point2D.Double((-2178.7316849269027), (-2178.7316849269027));
      Van van0 = new Van("", (-2178.7316849269027), point2D_Double0, "I$J^YT1{");
      Trip trip0 = new Trip();
      van0.addTrip(trip0);
      // Undeclared exception!
      try { 
        van0.clone();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Trip", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Van van0 = null;
      try {
        van0 = new Van("'-)LdS", 2680.71476816, (Point2D.Double) null, "'-)LdS");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Vehicle", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Van van0 = null;
      try {
        van0 = new Van((Van) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Van", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Point2D.Double point2D_Double0 = new Point2D.Double();
      Van van0 = new Van("vv{hn4c{y2T>", 0.0, point2D_Double0, "");
      Van van1 = new Van(van0);
      assertEquals(55.0, van1.getSpeed(), 0.01);
      assertEquals(1.9, van1.getPrice(), 0.01);
      assertEquals(55.0, van0.getSpeed(), 0.01);
      assertEquals(9, van0.getSeats());
      assertEquals(9, van1.getSeats());
      assertEquals(1.9, van0.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Point2D.Double point2D_Double0 = new Point2D.Double((-2178.7316849269027), (-2178.7316849269027));
      Van van0 = new Van("", (-2178.7316849269027), point2D_Double0, "I$J^YT1{");
      Van van1 = van0.clone();
      assertEquals(9, van0.getSeats());
      assertEquals(55.0, van0.getSpeed(), 0.01);
      assertEquals(1.9, van1.getPrice(), 0.01);
      assertEquals(9, van1.getSeats());
      assertEquals(55.0, van1.getSpeed(), 0.01);
      assertEquals(1.9, van0.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      Van van0 = null;
      try {
        van0 = new Van();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }
}
