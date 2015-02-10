package senha.core;

import java.util.Collections;
import java.util.List;

public class Retorno {

	private List<Integer> retorno;

	public List<Integer> getRetorno() {
		return retorno;
	}

	public void setRetorno(List<Integer> retornoAtual) {
		this.retorno = retornoAtual;
	}

	public int printRetorno() {
		int resultado = Collections.frequency(retorno, 0);
		
		System.out.println("Numero de pinos de cor e posicao correta: "
				+ Collections.frequency(retorno, 0));
		System.out
				.println("Numero de pinos de cor correta e posicao incorreta: "
						+ Collections.frequency(retorno, 1));

		return resultado;
	}

}
