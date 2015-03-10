package pck;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class RecutramentoFuncionarioWorkaroundTest {
	
	private int idade;
	private TipoEmprego tipoEmprego;
	private boolean valido;
	
	public RecutramentoFuncionarioWorkaroundTest(int idade, TipoEmprego tipoEmprego, boolean valido) {
		this.idade = idade;
		this.tipoEmprego = tipoEmprego;
		this.valido = valido;
	}
	
	@Parameters
	public static Collection<Object[]> dados() {
		return Arrays.asList(new Object[][]{
				{12, TipoEmprego.NAO_EMPREGAR,true},
				{60, TipoEmprego.NAO_EMPREGAR,true},
				{16, TipoEmprego.EMPREGAR_PARCIALMENTE,true},
				{17, TipoEmprego.EMPREGAR_PARCIALMENTE, true},
				{18, TipoEmprego.EMPREGAR, true},
				{-1, null, false},
				{100, null, false},
				{101, null, false}
		});
		
	}
	
	@Test
	public void empregar() throws Exception {
		if(valido)
			Assert.assertEquals(tipoEmprego, RecrutamentoFuncionario.empregar(idade));
		else {
			try {
				RecrutamentoFuncionario.empregar(idade);
				fail("Exceção é esperada!");
			} catch(Exception e) {
				assertTrue(true);
			}
		}
	}

}
