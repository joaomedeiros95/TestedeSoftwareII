/**
 * João Eduardo Ribeiro de Medeiros - 2013020793
 * Universidade Federal do Rio Grande do Norte
 * Bacharelado em Tecnologia da Informação
 * Criado em 11/02/2015
 */
package parameter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author joao
 *
 */
@RunWith(Parameterized.class)
public class CalculoImpostoRendaTeste {

	private int expected;
	private int first;

	public CalculoImpostoRendaTeste(int expectedResult, int firstNumber) {
		this.expected = expectedResult;
		this.first = firstNumber;
	}
	
	/**
	 * Foram costatados os seguintes erros durante o teste:
	 * - Valores abaixo de 1201 entram no imposto de 20% onde não deveriam pagar nada 
	 */
	@Parameters
    public static Collection<Integer[]> addedNumbers() {
        return Arrays.asList(new Integer[][] { { 4950, 4500}, { 960, 800 },
                { 8165, 7100 }, { 13200, 11000 }, });
    }
    
    @Test
    public void calculaImposto() {
    	assertEquals(expected, CalculoImpostoRenda.calculaImposto(first), 0.1);
    }
    
    /**
     * Aqui o valor de imposto aplicado deveria ser de 10% ou 20% mas como tem um problema 
     * nas condicionais é aplicado um valor de 20%, colocado no expected o valor que deveria
     * ser de 10% de imposto.
     */
    @Test
    public void calculaImposto1() {
    	assertNotEquals(5500.55, CalculoImpostoRenda.calculaImposto(5000.5), 0.1);
    }

}
