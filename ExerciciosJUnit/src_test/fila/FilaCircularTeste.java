/**
 * João Eduardo Ribeiro de Medeiros - 2013020793
 * Universidade Federal do Rio Grande do Norte
 * Bacharelado em Tecnologia da Informação
 * Criado em 11/02/2015
 */
package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author joao
 *
 */
public class FilaCircularTeste {
	
	FilaCircular fila;
	
	@Before
	public void setUp() {
		fila = new FilaCircular();
	}
	
	@Test
	public void estaVazia() {
		assertTrue(fila.estaVazia());
	}
	
	@Test
	public void estaCheia() {
		fila.insereNaFila(1);
		fila.insereNaFila(2);
		fila.insereNaFila(3);
		fila.insereNaFila(4);
		fila.insereNaFila(5);
		
		assertTrue(fila.estaCheia());
	}
	
	@Test
	public void insereNaFila1() {
		fila.insereNaFila(10);
		
		assertEquals(10, fila.removeDaFila());
	}
	
	@Test
	public void insereNaFila2() {
		fila.insereNaFila(10);
		fila.insereNaFila(15);
		fila.insereNaFila(20);
		
		assertEquals(10, fila.removeDaFila());
		assertEquals(15, fila.removeDaFila());
		assertEquals(20, fila.removeDaFila());
	}
	
	@Test(expected = FilaCheiaException.class)
	public void insereNaFila3() {
		fila.insereNaFila(1);
		fila.insereNaFila(2);
		fila.insereNaFila(3);
		fila.insereNaFila(4);
		fila.insereNaFila(5);
		fila.insereNaFila(6);
	}
	
	@Test(expected = FilaVaziaException.class) 
	public void removeDaFila() {
		fila.removeDaFila();
	}
	
	@Test
	public void removeDaFila2() {
		fila.insereNaFila(10);
		
		assertEquals(10, fila.removeDaFila());
		assertTrue(fila.estaVazia());
	}
	
	@Test
	public void removeDaFila3() {
		fila.insereNaFila(10);
		fila.insereNaFila(15);
		fila.insereNaFila(20);
		
		assertEquals(10, fila.removeDaFila());
		assertEquals(15, fila.removeDaFila());
		assertEquals(20, fila.removeDaFila());
		assertTrue(fila.estaVazia());
	}

}
