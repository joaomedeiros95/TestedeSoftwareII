import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;


/**
 * Esta classe só deve ser utilizada na parte do roteiro de testes
 * referente ao MOCKITO.
 * 
 * @author roberta
 *
 */

public class ContaCorrenteTestMockito {

	
	/**
	 * Este metodo exemplo foi inserido aqui apenas para ilustrar 
	 * algumas chamadas
	 * para os principais métodos disponíveis na lib
	 * do mockito.
	 */
	
	@Test
	public void depositarTest() {
		int valor = 5000;
		String data = "2015-02-07";
		
		Deposito mokckedDeposito = mock(Deposito.class);
		when(mokckedDeposito.valor()).thenReturn(valor);
		when(mokckedDeposito.data()).thenReturn(data);
		
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.creditar(mokckedDeposito);
		
		assertEquals(valor, contaCorrente.saldo());
	}

}
