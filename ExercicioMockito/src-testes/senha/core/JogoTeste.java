package senha.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class JogoTeste {
	
	Tentativa tentativa;
	
	@Test
	public void processarPartida1() {
		Jogo jogo = new Jogo(criarMockedInputStream());
		assertNotNull(jogo.processarPartida(criarMockedTentativa(0, 1, 2, 4), criarMockedSenha(0, 0, 0, 0)));
	}
	
	@Test
	public void processarPartida2() {
		Jogo jogo = new Jogo(criarMockedInputStream());
		assertEquals(1, jogo.processarPartida(criarMockedTentativa(0, 1, 2, 4), criarMockedSenha(0, 0, 0, 0)));
	}
	
	@Test
	public void processarPartida3() {
		Jogo jogo = new Jogo(criarMockedInputStream());
		assertEquals(3, jogo.processarPartida(criarMockedTentativa(0, 1, 2, 4), criarMockedSenha(0, 1, 2, 0)));
	}
	
	@Test
	public void processarPartida4() {
		Jogo jogo = new Jogo(criarMockedInputStream());
		assertEquals(4, jogo.processarPartida(criarMockedTentativa(0, 1, 2, 4), criarMockedSenha(0, 1, 2, 4)));
	}
	
	@Test
	public void iniciarJogo1() {
		Jogo jogo = new Jogo(criarMockedInputStream());
		assertEquals(Jogo.VOCE_PERDEU, jogo.iniciarJogo());
	}
	
	@Test
	public void iniciarJogo2() {
		InputStream is = criarMockedInputStream();
		Senha senha = new Senha(tentativa.getTentativa().subList(0, 4));
		Jogo jogo = new Jogo(is, senha);
		
		assertEquals(Jogo.PARABENS_VOCE_GANHOU, jogo.iniciarJogo());
	}
	
	private Tentativa criarMockedTentativa(int num1, int num2, int num3, int num4) {
		ArrayList<Integer> tentativas = new ArrayList<Integer>();
		tentativas.add(num1);
		tentativas.add(num2);
		tentativas.add(num3);
		tentativas.add(num4);
		
		Tentativa tentativa = mock(Tentativa.class);
		when(tentativa.getTentativa()).thenReturn(tentativas);
		
		return tentativa;
	}
	private Senha criarMockedSenha(int num1, int num2, int num3, int num4) {
		ArrayList<Integer> senhas = new ArrayList<Integer>();
		senhas.add(num1);
		senhas.add(num2);
		senhas.add(num3);
		senhas.add(num4);
		
		Senha senha = mock(Senha.class);
		when(senha.getSenha()).thenReturn(senhas);
		
		return senha;
	}
	
	public InputStream criarMockedInputStream() {
		String input = "";
		Random rand = new Random();
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		for(int i = 0; i < 5; i++) {
			String line = "";
			for(int j = 0; j < 4; j++) {
				int num = rand.nextInt(6);
				while(line.contains(String.valueOf(num))) num = rand.nextInt(6);
				
				if(line.isEmpty())
					line += num;
				else
					line += " " + num;
				
				numeros.add(num);
			}
			input += line + "\n";
		}
		
		tentativa = new Tentativa(numeros);
		
		return new ByteArrayInputStream(input.getBytes());
	}

}
