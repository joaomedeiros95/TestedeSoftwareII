import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class ExtratoSalvoTest {
	
	ExtratoSalvo extratoSalvo;
	ContaCorrente contaCorrente;

	@Before
	public void setUp() throws Exception {
		extratoSalvo = new ExtratoSalvo();
		contaCorrente = new ContaCorrente();
	}

	/**
	 * Só para exemplificar como ficaria o método sem dar o mock
	 */
	@Test
	public void testSalvarExtratoSemMock() {
		String texto = "Conta de Your Name\n" +
				"Saldo Inicial $0\n" +
				"Saldo Final $0\n" +
				"Nenhuma trasacao realizada\n";
		extratoSalvo = new ExtratoSalvo(texto, "/home/joaomedeiros95");
		try {
			extratoSalvo.salvar();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			assertEquals(texto, contaCorrente.verExtratoEmArquivo(extratoSalvo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSalvarExtratoComMock() throws IOException {
		ExtratoSalvo extratoSalvoMocked = mock(ExtratoSalvo.class);
		String texto = "Conta de Your Name\n" +
				"Saldo Inicial $0\n" +
				"Saldo Final $0\n" +
				"Nenhuma trasacao realizada\n";
		
		when(extratoSalvoMocked.ler()).thenReturn(texto);
		assertEquals(texto, contaCorrente.verExtratoEmArquivo(extratoSalvoMocked));
	}

}
