package banco;

//s�� para os testes com @Test
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContaTest  {
	
	Conta c1;
	Conta c2;
	
	@Before
	public void setUp() {
		c1 = new Conta("1234", 500.0);
		c2 = new Conta("12345", 600.0);
	}

	@Test
	public void testDebitarSucesso() throws OperacaoIlegalException{
		Conta c = new Conta("123", 20);
		c.debitar(10);
		assertEquals(10,c.getSaldo(),0.0);
	}
	
	@Test
	public void testTransferirSucesso() throws OperacaoIlegalException {
		c1.transferir(300.0, c2);
		assertEquals(200.0, c1.getSaldo(),0.0);
		assertEquals(900.0, c2.getSaldo(),0.0);
	}
	
	@Test(expected = OperacaoIlegalException.class)
	public void testTransferirFalha1() throws OperacaoIlegalException {
		c1.transferir(1000.0, c2);
	}
	
	@Test(expected = OperacaoIlegalException.class)
	public void testTransferirFalha2() throws OperacaoIlegalException {
		c1.transferir(-10.0, c2);
	}
}
