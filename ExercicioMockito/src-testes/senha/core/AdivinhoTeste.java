package senha.core;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import senha.core.Adivinho;
import senha.core.CaractereInvalidoException;
import senha.core.PinoInvalidoException;
import senha.core.PinoJaExisteException;
import senha.core.QuantidadePinosException;

public class AdivinhoTeste {
	
	private Adivinho adivinho;
	private String normalline;
	
	@Before
	public void setUp() {
		adivinho = new Adivinho();
		normalline = "1 2 3 4";
	}
	
	@Test(expected=QuantidadePinosException.class)
	public void processarPartida1() throws QuantidadePinosException, PinoInvalidoException, PinoJaExisteException, CaractereInvalidoException {
		String line = "0 0 0";
		adivinho.processarEntrada(line);
	}
	
	@Test(expected=PinoInvalidoException.class)
	public void processarPartida2() throws QuantidadePinosException, PinoInvalidoException, PinoJaExisteException, CaractereInvalidoException {
		String line = "1 2 3 7";
		adivinho.processarEntrada(line);
	}
	
	@Test(expected=PinoInvalidoException.class)
	public void processarPartida3() throws QuantidadePinosException, PinoInvalidoException, PinoJaExisteException, CaractereInvalidoException {
		String line = "-1 2 3 6";
		adivinho.processarEntrada(line);
	}
	
	@Test(expected=PinoJaExisteException.class)
	public void processarPartida4() throws QuantidadePinosException, PinoInvalidoException, PinoJaExisteException, CaractereInvalidoException {
		String line = "2 2 3 6";
		adivinho.processarEntrada(line);
	}
	
	@Test(expected=CaractereInvalidoException.class)
	public void processarPartida5() throws QuantidadePinosException, PinoInvalidoException, PinoJaExisteException, CaractereInvalidoException {
		String line = "q a 3 6";
		adivinho.processarEntrada(line);
	}
	
	@Test
	public void processarPartida6() throws QuantidadePinosException, PinoInvalidoException, PinoJaExisteException, CaractereInvalidoException {
		assertEquals();
	}
}
