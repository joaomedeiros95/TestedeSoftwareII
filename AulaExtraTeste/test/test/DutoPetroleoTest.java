package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import src.DutoPetroleo;
import src.Risco;

@RunWith(Parameterized.class)
public class DutoPetroleoTest {
	
	private int temperature_ambiente;
	private double percentual_cheio;
	private Risco expected;
	private DutoPetroleo dutoPetroleo;

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 15, 30.0, Risco.BAIXO }, { 30, 70.0, Risco.BAIXO }, 
                 { 31, 40.0, Risco.MEDIO }, { 60, 60.0, Risco.MEDIO },
                 { 61, 10.0, Risco.ALTO }, { 0, 71.0, Risco.ALTO },{ 20, 15.0, Risco.NAO_AVALIADO }  
           });
    }

	public DutoPetroleoTest(int temperature_ambiente, double percentual_cheio,
			Risco expected) {
		super();
		this.temperature_ambiente = temperature_ambiente;
		this.percentual_cheio = percentual_cheio;
		this.expected = expected;
	}
	
	@Before
	public void setUp() {
		dutoPetroleo = new DutoPetroleo();
	}

	@Test
	public void testCalculaRiscoExplosao() {
		assertEquals(expected, dutoPetroleo.calculaRiscoExplosao(percentual_cheio, temperature_ambiente));
	}

}
