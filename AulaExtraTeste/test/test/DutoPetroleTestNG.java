package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import src.DutoPetroleo;
import src.Risco;

public class DutoPetroleTestNG {
	
	private DutoPetroleo dutoPetroleo;
	
	@BeforeTest
	public void setUp() {
		dutoPetroleo = new DutoPetroleo();
	}
	
	@Test(dataProvider = "dp")
	public void f(Integer temp, double nivel, Risco risco) {
		Assert.assertEquals(dutoPetroleo.calculaRiscoExplosao(nivel, temp), risco);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {  { 15, 30.0, Risco.BAIXO }, { 30, 70.0, Risco.BAIXO }, 
                { 31, 40.0, Risco.MEDIO }, { 60, 60.0, Risco.MEDIO },
                { 61, 10.0, Risco.ALTO }, { 0, 71.0, Risco.ALTO },{ 20, 15.0, Risco.NAO_AVALIADO } };
	}
}
