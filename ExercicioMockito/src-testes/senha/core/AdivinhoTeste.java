package senha.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class AdivinhoTeste {
	
	private Adivinho adivinho;
	private String normalline;
	public Tentativa tentativa;
	
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
		assertNotNull(adivinho.processarEntrada(normalline));
	}
	
	@Test
	public void lerTentativa() throws QuantidadePinosException, PinoJaExisteException, PinoInvalidoException, CaractereInvalidoException {
		Adivinho adivinho = new Adivinho();
		assertNotNull(adivinho.lerTentativa(criarMockedInputStream()));
	}
	
	@Test
	public void lerTentativa1() throws QuantidadePinosException, PinoJaExisteException, PinoInvalidoException, CaractereInvalidoException {
		Adivinho adivinho = new Adivinho();
		List<Integer> esperado = adivinho.lerTentativa(criarMockedInputStream()).getTentativa();
		assertEquals(tentativa.getTentativa(), esperado);
	}
	
	public InputStream criarMockedInputStream() {
		String input = "";
		Random rand = new Random();
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		for(int i = 0; i < 4; i++) {
			int num = rand.nextInt(6);
			while(input.contains(String.valueOf(num))) num = rand.nextInt(6);
			
			if(input.isEmpty())
				input += num;
			else
				input += " " + num;
			
			numeros.add(num);
		}
		
		tentativa = new Tentativa(numeros);
		
		return new ByteArrayInputStream(input.getBytes());
	}
}
