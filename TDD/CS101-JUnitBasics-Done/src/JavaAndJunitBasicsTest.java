import junit.framework.TestCase;

/*
 * Copyright (c) 2009 James W. Grenning
 * All rights reserved 
 * For use by attendees of James training or conference sessions
 * 
 */

/*
 * Exercise - Intro to JUnit
 * 
 * In this exercise you will enable each test case, watch it fail,
 * then make a minor change to make it pass.
 * 
 * 1) Run the test case as a JUnit test
 * 
 * To run this test case from eclipse use Run->Run As->JUnit Test
 * You can also right click the test class in the package 
 * explorer and select Run As->JUnit Test
 * 
 * Note that the test run fails because there are no test cases yet.
 * 
 * Un-comment one test case at a time, in order. Watch it fail, then make
 * it pass. In the JUnit window you can double 
 * click the the error and Eclipse will highlight the failing
 * line in the test case. Look at the information JUinit is providing.
 * 
 * You can un-comment a block of commented out lines, by 
 * selecting the lines and and pressing CRTL-/
 * Command-? on a Mac
 * 
 */

public class JavaAndJunitBasicsTest extends TestCase {

	
	public void testAssertTrue() {
		assertTrue(true);
	}
	
	
	/*
	 * Now, Un-comment the next test.  See that it fails. 
	 * Make it pass
	 */
	
	public void testAssertFalse() {
	assertFalse(false);
	}

	/*
	 * You are probably getting the idea now.  When you run this test, notice how JUnit's
	 * error report tells you the expected and actual values.
	 */
	
	public void testAssertEqualInts() {
		assertEquals(1, 1);
	}	
	
	/*
	 * By fixing the expected result, make this test pass
	 */
	
	public void testCheckingIntCalculation() {
		int value = 4;
		int doubled = value * 2;
		assertEquals(8, doubled);
	}	
	
	/*
	 * By fixing the calculation, make this test pass
	 */

	public void testAssertExactlyEqualDoubles() {
		double value = 12.0;
		double result = value / 2;
		double delta = 0.0;
		assertEquals(6.0, result, delta);
	}
	
	
	/*
	 * Floating point numbers can only be approximated by a 
	 * digital computer.  When comparing double precision 
	 * floating point numbers an allowed delta must be 
	 * provided as the third parameter to assertEquals.
	 * Notice in the previous test the delta is 0.0
	 * 
	 * Make this test pass by adjusting delta.
	 */

	public void testAssertAlmostEqualDoubles() {
		double numerator = 10.0;
		double denominator = 3.0;
		double delta = 0.001;
		double expected = 3.333;
		double quotient = numerator/denominator;
		
		assertEquals(expected, quotient, delta);
	}
	
	/*
	 * Strings can be compared too. Make this test pass by fixing
	 * whatToSay.  Before you fix it, note how JUnit indicates where the
	 * expected and actual strings differ
	 */
	
	public void testCompareStrings() {
		String greeting = "Hello";
		String greetee = "World";
		
		String whatToSay = greeting + " " + greetee;
		
		assertEquals("Hello World", whatToSay);
	}
	
}
