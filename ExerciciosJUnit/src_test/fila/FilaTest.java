package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilaTest {
	
	Fila fila;
	
	@Before
	public void setUp() {
		fila = new Fila();
	}
	
	@Test
	public void testTamanho1() {
		assertEquals(-1, fila.tamanho());
	}
	
	@Test
	public void testTamanho2() {
		fila.insereNaFila(10);
		assertEquals(0, fila.tamanho());
	}
	
	@Test
	public void testEstaVazia1() {
		assertEquals(true, fila.estaVazia());
	}
	
	@Test
	public void testEstaVazia2() {
		fila.insereNaFila(10);
		assertEquals(false, fila.estaVazia());
	}
	
	@Test
	public void testEstaVazia3() {
		fila.insereNaFila(10);
		fila.removeDaFila();
		assertEquals(true, fila.estaVazia());
	}
	
	@Test
	public void testEstaCheia1() {
		assertEquals(false, fila.estaCheia());
	}
	
	/*Aqui encontra-se um erro pois deveria dizer que a fila está cheia*/
	@Test
	public void testEstaCheia2() {
		fila.insereNaFila(10);
		fila.insereNaFila(10);
		fila.insereNaFila(10);
		fila.insereNaFila(10);
		fila.insereNaFila(10);
		assertEquals(true, fila.estaCheia());
	}
	
	@Test
	public void testInsereNaFila1() {
		fila.insereNaFila(10);
		assertEquals(0, fila.tamanho());
		assertEquals(10, fila.removeDaFila());
	}
	
	/*Aqui deveria ter um tratamento de exceção para evitar o lançamento da 
	 * ArrayIndexOutOfBoundsException
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInsereNaFila2() {
		fila.insereNaFila(5);
		fila.insereNaFila(10);
		fila.insereNaFila(5);
		fila.insereNaFila(10);
		fila.insereNaFila(5);
		fila.insereNaFila(10);
	}
	
	/*Aqui ocorre um erro pois o código remove da fila mesmo sem ter ninguém lá*/
	@Test
	public void testRemovedaFila1() {
		fila.removeDaFila();
		assertEquals(true, fila.estaVazia());
	}
	
	@Test
	public void testRemovedaFila2() {
		fila.insereNaFila(10);
		assertEquals(10, fila.removeDaFila());
		assertEquals(true, fila.estaVazia());
	}
	
	/*Aqui ocorre um erro pois o segundo remover deveria retornar o objeto 10
	 * que é o que está sendo removido mas ele retorna 5
	 */
	@Test
	public void testRemovedaFila3() {
		fila.insereNaFila(5);
		fila.insereNaFila(10);
		assertEquals(5, fila.removeDaFila());
		assertEquals(10, fila.removeDaFila());
		assertEquals(true, fila.estaVazia());
	}
	
	@Test
	public void testLimpaFila1() {
		fila.limpaFila();
		assertEquals(true, fila.estaVazia());
	}
	
	@Test
	public void testLimpaFila2() {
		fila.insereNaFila(5);
		fila.insereNaFila(10);
		fila.insereNaFila(5);
		fila.insereNaFila(10);
		fila.insereNaFila(10);
		fila.limpaFila();
		assertEquals(true, fila.estaVazia());
	}
	
	@Test
	public void testLimpaFila3() {
		fila.insereNaFila(5);
		fila.insereNaFila(10);
		fila.limpaFila();
		assertNull(fila.removeDaFila());
	}

}
