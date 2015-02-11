package senha.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class FornecedorDaSenhaTeste {
	
	@Test
	public void gerarNovaSenha() {
		FornecedorDaSenha fornecedor = new FornecedorDaSenha();
		fornecedor.gerarNovaSenha();
		assertNotNull(fornecedor.getSenha());
	}

}
