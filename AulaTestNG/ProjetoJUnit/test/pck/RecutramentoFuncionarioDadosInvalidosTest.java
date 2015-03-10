package pck;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class RecutramentoFuncionarioDadosInvalidosTest {

	private int idade;
	
	public RecutramentoFuncionarioDadosInvalidosTest(int idade) {
		this.idade = idade;
	}
	
	@Parameters
	public static Collection<Object[]> dados() {
		return Arrays.asList(new Object[][]{
				{-1},
				{100},
				{101}
		});
		
	}
	
	@Test(expected = Exception.class)
	public void empregar() throws Exception {
		RecrutamentoFuncionario.empregar(idade);
	}
	
}
