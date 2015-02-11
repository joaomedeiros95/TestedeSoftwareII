package senha.core;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

public class JogadaTeste {
	
	Senha mockedSenha;
	
	@Before
	public void setUp() {
		mockedSenha = mock(Senha.class);
		ArrayList<Integer> senhas = new ArrayList<Integer>();
		senhas.add(1);
		senhas.add(2);
		senhas.add(3);
		senhas.add(4);
		
		when(mockedSenha.getSenha()).thenReturn(senhas);
		
	}
	
	@Test
	public void calcularRetorno1() {
		Tentativa tentativa = criarTentativa(1, 2, 3, 4);
		Jogada jogada = new Jogada(tentativa);
		jogada.calcularRetorno(mockedSenha);
		
		assertEquals(criarRetorno(0, 0, 0, 0).getRetorno(), jogada.getSitRetorno().getRetorno());
	}
	
	@Test
	public void calcularRetorno2() {
		Tentativa tentativa = criarTentativa(4, 3, 2, 1);
		Jogada jogada = new Jogada(tentativa);
		jogada.calcularRetorno(mockedSenha);
		
		assertEquals(criarRetorno(1, 1, 1, 1).getRetorno(), jogada.getSitRetorno().getRetorno());
	}
	
	@Test
	public void calcularRetorno3() {
		Tentativa tentativa = criarTentativa(1, 2, 3, 5);
		Jogada jogada = new Jogada(tentativa);
		jogada.calcularRetorno(mockedSenha);
		
		assertEquals(criarRetorno(0, 0, 0).getRetorno(), jogada.getSitRetorno().getRetorno());
	}
	
	private Tentativa criarTentativa(int num1, int num2, int num3, int num4) {
		ArrayList<Integer> tentativas = new ArrayList<Integer>();
		tentativas.add(num1);
		tentativas.add(num2);
		tentativas.add(num3);
		tentativas.add(num4);
		
		Tentativa tentativa = new Tentativa(tentativas);
		return tentativa;
	}
	
	private Retorno criarRetorno (int num1, int num2, int num3, int num4) {
		Retorno retorno = new Retorno();
		ArrayList<Integer> tentativas = new ArrayList<Integer>();
		tentativas.add(num1);
		tentativas.add(num2);
		tentativas.add(num3);
		tentativas.add(num4);
		
		retorno.setRetorno(tentativas);
		return retorno;
	}
	
	private Retorno criarRetorno (int num1, int num2, int num3) {
		Retorno retorno = new Retorno();
		ArrayList<Integer> tentativas = new ArrayList<Integer>();
		tentativas.add(num1);
		tentativas.add(num2);
		tentativas.add(num3);
		
		retorno.setRetorno(tentativas);
		return retorno;
	}


}
