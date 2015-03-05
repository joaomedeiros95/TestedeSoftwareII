import junit.framework.TestCase;

/*
 * Copyright (c) 2009 James W. Grenning
 * All rights reserved 
 * For use by attendees of James training or conference sessions
 * 
 */

public class DepositTest extends TestCase {

	public void testCreate() {
		String depositDate = "2009-10-1";
		int pennies = 3000;
		
		Deposit d = new Deposit(depositDate, pennies);
		assertEquals(depositDate, d.date());
	}
}
