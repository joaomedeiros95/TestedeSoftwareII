package senha.core;

import java.util.ArrayList;
import java.util.List;

public class Jogada {

	private Tentativa sitTentativa;
	private Retorno sitRetorno;

	public Jogada(Tentativa t) {
		this.sitTentativa = t;
	}

	public Retorno getSitRetorno() {
		return sitRetorno;
	}

	/**
	 * 0 representa pino preto e 1 representa pino branco
	 * 
	 * @param senha
	 */
	public void calcularRetorno(Senha senha) {
		List<Integer> retornoAtual = new ArrayList<Integer>();
		List<Integer> senhaAtual = senha.getSenha();
		List<Integer> tentativaAtual = sitTentativa.getTentativa();

		for (int i = 0; i < 4; ++i) {
			if (senhaAtual.contains(tentativaAtual.get(i))) {
				if (tentativaAtual.get(i) == senhaAtual.get(i))
					retornoAtual.add(0);
				else
					retornoAtual.add(1);
			}
		}
		Retorno r = new Retorno();
		r.setRetorno(retornoAtual);
		this.sitRetorno = r;
	}

}
