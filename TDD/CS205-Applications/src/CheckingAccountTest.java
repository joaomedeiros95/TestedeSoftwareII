import junit.framework.TestCase;

/*
 * Copyright (c) 2009 James W. Grenning
 * All rights reserved 
 * For use by attendees of James training or conference sessions
 * 
 */

/*
 * You are going to write a CheckingAccount class that supports
 * deposits, checks, transfers to savings, ATM withdrawals, electronic
 * bill payment, and electronic funds transfers. Each transaction has 
 * an associated date.
 * 
 * An account statement can be created that shows each transaction.
 * 
 * The purpose of this exercise is to give you a feel for
 * pair programming with an experienced TDD developer.
 *
 * We are going to create a Checkbook class.
 * Before starting the development of the checkbook, the Test Driven 
 * Developer makes a test list from what they know about 
 * the requirements.  Here is our initial test list:
 * 
 * 		- Balance should be zero upon creation
 * 		- Balance increases when a deposit is made
 * 		- Multiple account deposits
 * 		- Writing a check decreases the balance
 * 		- Writing a NSF check, rejects the check and charges the 
 * 			account $50. 
 * 		- NSF ATM withdrawals are rejected
 * 		- ATM withdrawals from OOPSLA-Bank are free
 * 		- ATM withdrawals from other bank's ATMs cost $3
 * 
 * We also thought we would need a Deposit class, a data holder.
 * That's already build and ready for use.  You can evolve it as needed.
 * Later, you might need Check, AtmWithDrawal, AtmDeposit, ect classes.
 * Don't worry about them yet.
 */

/*
 * Un-comment one test at a time.  Write the bare minimum to get the 
 * test to pass.  In many cases this means hard coding the return result.
 * Don't worry, a subsequent test case will force you to evolve
 * your Checkbook into the real checkbook implementation.
 * 
 * Always first make your test case fail by having the 
 * production code return an incorrect result.  This assures that 
 * your test can detect a mistake.
 * 
 * The make it pass.
 */


public class CheckingAccountTest extends TestCase {
	
	private CheckingAccount account;;

	/*
	 * set up is run BEFORE EVERY test case function
	 */

	public void setUp() {
		 account = new CheckingAccount();
	
	}

	/*
	 * tearDown is called AFTER EVERY test case function
	 */
	public void tearDown() {
		
	}
	
	/*
	 * test case functions must: 
	 * 1) be public 
	 * 2) have a void return type 
	 * 3) Have their name start with test
	 */
	
//	public void testANewCheckBookHasAZeroBallanceByDefault() {	
//		assertEquals(0, account.balance());
//	}
	
	/*
	 * To make the previous test pass, all you need to do is have a
	 * hard code the return result in the balance method.  If you coded any 
	 * more than that, please delete the currently unneeded code.
	 */
	
//	public void testSingleDepositIncreasesBalance() {
//		account.credit(new Deposit("2009-10-12", 10000));
//		
//		assertEquals(10000, account.balance());
//	}
	
	/*
	 * To make the previous test pass you would only need to introduce a 
	 * balance member variable and set it to the amount of the passed in
	 * Deposit.
	 */
		
//	public void testMultipleDeposits() {
//		account.credit(new Deposit("2009-10-12", 100));
//		account.credit(new Deposit("2009-10-13", 200));
//		account.credit(new Deposit("2009-10-14", 300));
//		
//		assertEquals(600, account.balance());
//	}
	
	/*
	 * To make the previous test pass, you need to sum each deposited amount
	 */
	
	/*
	 * To make this next test pass you have to add a new constructor.
	 */
	
//	public void testCreateAccountWithInitialBalance() {
//		CheckingAccount account = new CheckingAccount(10000);
//
//		assertEquals(10000, account.balance());
//	}
	
	/*
	 * To get this next test to pass you can see there is some 
	 * missing information, like: the account holder's name.
	 * 
	 * Don't worry about it at first, just return a hard coded
	 * string that passes this test.  In the next test we
	 * will drive out the hard coded name.
	 * 
	 * We will use other tests to drive out the other hard coded
	 * items, link the Starting and Ending balance, as well as 
	 * transactions.  We 
	 * 
	 * Right now just get this boundary test to pass with the bare 
	 * minimum of code.  For this exercise we wont worry about formatting 
	 * the money correctly.
	 */

//	public void testProduceStatementWithNoTransactions() {
//		String expected = 
//			"Checking account for James Grenning\n" +
//			"Starting Balance $0\n" +
//			"Ending Balance $0\n" +
//			"No Transactions in this period\n";
//		
//		String statement = account.statement();
//		
//		assertEquals(expected, statement);
//	}
	
	/*
	 * in this next lets drive out the hard coded
	 * statement holder.  We need to add a statement holder
	 * to the constructor of the account. 
	 */
	
//	public void testProduceStatementWithDifferentHolder() {
//		CheckingAccount account = new CheckingAccount("Your Name");
//		String expected = 
//			"Checking account for Your Name\n" +
//			"Starting Balance $0\n" +
//			"Ending Balance $0\n" +
//			"No Transactions in this period\n";
//		
//		String statement = account.statement();
//		
//		assertEquals(expected, statement);
//	}
	
	/*
	 * In the next test drive out the hard coded starting balance.
	 */
	
//	public void testProduceStatementWithDifferentStartigBalancen() {
//		CheckingAccount account = new CheckingAccount("Your Name", 10000);
//		String expected = 
//			"Checking account for Your Name\n" +
//			"Starting Balance $10000\n" +
//			"Ending Balance $10000\n" +
//			"No Transactions in this period\n";
//		
//		String statement = account.statement();
//		
//		assertEquals(expected, statement);
//	}
	
	/*
	 * So far we've only had to keep track of the balances, not any of the
	 * Deposits or Checks.  For this test you will need to keep track of a single
	 * Deposit.  Don't add a collection, just add a way to hold a single 
	 * Deposit in the account.
	 */
	
//	public void testProduceStatementWithOneDeposit() {
//			String expected = 
//			"Checking account for James Grenning\n" +
//			"Starting Balance $0\n" +
//			"Ending Balance $10000\n" +
//			"2009-10-12\tDeposit\t$10000\n";
//			
//		account.credit(new Deposit("2009-10-12", 10000));
//		
//		String statement = account.statement();
//		
//		assertEquals(expected, statement);
//	}
	
	/*
	 * Notice that this approach makes sure we are focused on making a
	 * single change at a time.  And that each change is well tested.
	 * 
	 * Now let's add a couple more deposits.  This will force us to create
	 * a collection of some sort, and add the loop to put them
	 * all in the statement.
	 * 
	 * Don't forget to watch the test file before adding the production
	 * code that makes it pass.
	 */
	
//	public void testProduceStatementWithMultipleDeposit() {
//			String expected = 
//			"Checking account for James Grenning\n" +
//			"Starting Balance $0\n" +
//			"Ending Balance $60000\n" +
//			"2009-10-12\tDeposit\t$10000\n" +
//			"2009-10-13\tDeposit\t$20000\n" + 
//			"2009-10-14\tDeposit\t$30000\n";
//			
//			account.credit(new Deposit("2009-10-12", 10000));
//			account.credit(new Deposit("2009-10-13", 20000));
//			account.credit(new Deposit("2009-10-14", 30000));
//		
//		String statement = account.statement();
//		
//		assertEquals(expected, statement);
//	}
	
	/*
	 * Now you take over and continue implementing CheckingAccount
	 */
	
}
