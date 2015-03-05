import junit.framework.TestCase;

/*
 * Copyright (c) 2009 James W. Grenning
 * All rights reserved 
 * For use by attendees of James training or conference sessions
 * 
 */

/*
 * TDD Exercise
 *
 * The purpose of this exercise is to give you a feel for
 * pair programming with an experienced TDD developer
 *
 * Before starting, we brain stormed a list of needed tests.
 * Here is the initial list we came up with:
 * - Empty after creation
 * - Not full after creation
 * - Not empty after put
 * - Empty after last item removed
 * - put and get one or many
 * - set-able capacity
 * - totally full, but no more, and no wrap around
 * - totally filled with wrap around
 * - underflow, taking items out of an empty buffer
 * - overflow, adding items to a full buffer
 *
 * The process is
 * - write a failing unit test
 * - make it compile (let eclipse help you)
 * - run the test and see it fail
 * - add simplest code to make the test pass
 *
 * To get the feel of TDD enable only one test at a time
 * Like this:
 *
 *   Un-comment one the next test.  In Eclipse, 
 *   select the commented lines and press CTRL-/
 *   
 *   Study the test, make sure you understand what the 
 *   test is trying to accomplish.  Read the test name.  You are
 *   pretending to pair program with me.  I just wrote
 *   the first test, you need to make it pass.
 * *
 *   Each time you enable a new test, follow this careful process:
 *   1) Get the test to compile.  Eclipse is dying to help you
 *   	CTRL-1 will give you its suggestions.
 *   2) Add a trivial, but failing, implementation to the production 
 *   	code. Watch the test fail.
 *   3) Finally, add the simplest implementation that will
 *   allow the test to pass.  Sometimes this means hard
 *   coding a return value. Don't let the code get ahead of
 *   the tests.
 *
 *   Now go to the next test.
 *
 * Please read the instruction down the page as you go.  Ask 
 * me for help if something is not clear.  I am your pair 
 * partner.
 */


public class CircularBufferTest extends TestCase {

	CircularBuffer buffer;
	
	/*
	 * set up is run BEFORE EVERY test case function
	 */

	protected void setUp() throws Exception {
		buffer = new CircularBuffer(5);
	}
	
	/*
	 * test case functions must: 
	 * 1) be public 
	 * 2) have a void return type 
	 * 3) Have their name start with test
	 */
	

	public void testShouldBeEmptyAfterCreate() {
		assertTrue(buffer.isEmpty());
	}

	public void testNotFullAfterCreation()
	{
		assertTrue(!buffer.isFull());
	}

	public void testNotEmptyAfterPut()
	{
		buffer.Put(10046);
		assertTrue(!buffer.isEmpty());
	}

	public void testNotEmptyThenEmpty()
	{
		buffer.Put(4567);
		assertTrue(!buffer.isEmpty());
		buffer.Get();
		assertTrue(buffer.isEmpty());
	}

	public void testGetPutOneValue()
	{
		buffer.Put(4567);
		assertEquals(4567, buffer.Get());
	}

	/*
	 * To make the previous tests pass, you do not need to have an array of ints.
	 * Your tests do not require it.  They will soon enough.  You really only
	 * need a counter that knows how many ints have been put() to the buffer, with
	 * hard coded return value for get().
	 *
	 * If you have more, delete it now!  It is not tested code, you
	 * are supposed to be doing TDD!
	 * 
	 * This next test will drive you to add the array of ints.
	 * 
	 */
	
	public void testGetPutAFew()
	{
		buffer.Put(1);
		buffer.Put(2);
		buffer.Put(3);
		assertEquals(1, buffer.Get());
		assertEquals(2, buffer.Get());
		assertEquals(3, buffer.Get());
	}

	/*
	 * The previous test has driven you to have a simple internal array
	 * of fixed size, an index and an outdex.  There should
	 * be no circular buffer logic yet.
	 * Why?  Your tests do not require it yet.
	 */

	public void testCapacity()
	{
		CircularBuffer buffer = new CircularBuffer(2);
		assertEquals(2, buffer.capacity());
	}

	/*
	 * Did you create the internal buffer with new.  This is a 
	 * good opportunity to.
	 * 
	 * Did you add a second constructor? or Did you change the default
	 * to parameterized?  I recommend the later.  Who knows better than the
	 * client code that is creating the buffer.
	 * make your of the I also suggest that
	 * you create the buffer in setup with 5 or more elements.
	 */

	public void testIsFull()
	{
		for (int i = 0; i < buffer.capacity(); i++)
			buffer.Put(i + 100);

		assertTrue(buffer.isFull());
	}
	
	/*
	 * As long as your hard coded array of ints is big enough the previous
	 * test will pass.  you should not have wrap around logic yet.
	 * If you have wrap around logic already, raise your hand and 
	 * show me your untested code so I can delete it.
	 */

	public void testEmptyToFullToEmpty()
	{
		for (int i = 0; i < buffer.capacity(); i++)
			buffer.Put(i + 100);

		for (int j = 0; j < buffer.capacity(); j++)
		{
			assertEquals(j + 100, buffer.Get());
			assertTrue(!buffer.isFull());
		}

		assertTrue(buffer.isEmpty());
	}

	/*
	 * Did the previous test pass without changes to the production code?
	 * That happens sometime.
	 *
	 * Finally, the wrap around test.  You should get an array bounds 
	 * exception.  Once you do, add the wrap around logic for put()
	 */

	public void testWrapAround()
	{
		int capacity = buffer.capacity();
		int seed = 100;
		
		for (int i = 0; i < capacity; i++)
			buffer.Put(i + seed);

		assertEquals(seed, buffer.Get());
		buffer.Put(110);
		assertTrue(buffer.isFull());

		for (int i = 1; i < capacity; i++)
			assertEquals(i + seed, buffer.Get());

		assertEquals(110, buffer.Get());
		assertEquals(capacity, buffer.size());
		assertTrue(buffer.isEmpty());
	}
	

	/*
	 *  These tests are collecting some duplication.
	 *  By now you should be sick of writing the fill loop over
	 *  and over again.  Refactor the loop into a fillTheBuffer()
	 *  function, add it as a private function to CurcularBufferTest.
	 *  Get rid of all the duplication.
	 *
	 *  This example of fillTheBuffer puts 5 values into the buffer
	 *  using 900 as a seed value, incrementing the seed by one
	 *  with each put
	 *  	fillTheBuffer(900, 5);
	 *
	 *  You should also get rid of the duplication around draining and
	 *  checking of the buffer. drainAndCheck() works similarly to
	 *  fillTheBuffer().
	 *
	 *  BTW: At this point in the exercise you should not have
	 *  any production code that is worried about doing a Get
	 *  from an empty buffer, or putting to a full buffer.
	 *  You will worry about that in the next test.  TDD, remember?
	 *
	 */
	
	public void testPutToFullThrows()
	{
		fillTheBuffer(900, buffer.capacity());

		try
		{
			buffer.Put(9999);
			fail("Put to full circularBuffer should throw");
		}
		catch (CircularBufferException e)
		{
			String expected = "Put to full circular buffer";
			assertEquals(expected, e.getMessage());
		}
	}

	private void fillTheBuffer(int seed, int capacity) {
		for (int i = 0; i < capacity; i++)
			buffer.Put(i + seed);
	}

	public void testPutToFullDoesNotDamageContents()
	{
		fillTheBuffer(900, buffer.capacity());

		try
		{
			buffer.Put(9999);
		}
		catch (CircularBufferException e)
		{
		}

		drainAndCheck(900, buffer.capacity());

		assertTrue(buffer.isEmpty());
	}

	private void drainAndCheck(int seed, int capacity) {
		for (int i = 0; i < capacity; i++)
			assertEquals(i + seed, buffer.Get());
	}

	/*
	 * Don't you think you should refactor that duplicate index
	 * wrapping code into a helper function in your production code?
	 *
	 */

	public void testGetFromEmptyThrows()
	{
		try
		{
			buffer.Get();
			fail("Get from empty should throw");
		}
		catch (CircularBufferException e)
		{
			String expected = "Get from empty circular buffer";
			assertEquals(expected, e.getMessage());
			assertTrue(buffer.isEmpty());
		}
	}

	/*
	 * Did you delete all the unneeded comments?
	 */

}
