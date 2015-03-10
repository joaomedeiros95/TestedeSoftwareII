package pck;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;

public class RecrutamentoFuncionarioTest {

	@DataProvider(name = "dadosValidos")
	public Object[][] dp() {
		return new Object[][] { { 12, TipoEmprego.NAO_EMPREGAR, },
				{ 60, TipoEmprego.NAO_EMPREGAR },
				{ 16, TipoEmprego.EMPREGAR_PARCIALMENTE },
				{ 17, TipoEmprego.EMPREGAR_PARCIALMENTE },
				{ 18, TipoEmprego.EMPREGAR } };
	}
	
	@DataProvider(name = "dadosInvalidos")
	public Object[][] dp1() {
		return new Object[][] { {-1},
				{100},
				{101} };
	}

	@Test(dataProvider = "dadosValidos")
	public void f(int idade, TipoEmprego tipoEmprego) throws Exception {
		AssertJUnit.assertEquals(tipoEmprego, RecrutamentoFuncionario.empregar(idade));
	}
	
	@Test(dataProvider = "dadosInvalidos",expectedExceptions=Exception.class)
	public void f1(int idade) throws Exception {
		RecrutamentoFuncionario.empregar(idade);
	}
}
