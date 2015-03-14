import static org.junit.Assert.*;

import org.junit.Test;


/*
 * Adaptado de James W. Grenning
 * All rights reserved 
 * For use by attendees of James training or conference sessions
 * 
 */

public class DepositoTest {

	@Test
	public void testCreate() {
		String depositDate = "2015-03-13";
		int valor = 3000;
		
		Deposito d = new Deposito(depositDate, valor);
		assertEquals(depositDate, d.data());
	}
}
