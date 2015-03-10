package pck;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import pck.RecrutamentoFuncionario;
import pck.TipoEmprego;

@RunWith(value = Parameterized.class)
public class RecutramentoFuncionarioTest {

	private int idade;
	private TipoEmprego tipoEmprego;
	
	public RecutramentoFuncionarioTest(int idade, TipoEmprego tipoEmprego) {
		this.idade = idade;
		this.tipoEmprego = tipoEmprego;
	}
	
	@Parameters
	public static Collection<Object[]> dados() {
		return Arrays.asList(new Object[][]{
				{12, TipoEmprego.NAO_EMPREGAR},
				{60, TipoEmprego.NAO_EMPREGAR},
				{16, TipoEmprego.EMPREGAR_PARCIALMENTE},
				{17, TipoEmprego.EMPREGAR_PARCIALMENTE},
				{18, TipoEmprego.EMPREGAR}
		});
		
	}
	
	@Test
	public void empregar() throws Exception {
		Assert.assertEquals(tipoEmprego, RecrutamentoFuncionario.empregar(idade));
	}

}
