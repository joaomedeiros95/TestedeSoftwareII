package senha.core;

import java.util.List;

public class Senha {

	private List<Integer> senha;

	public Senha() {

	}

	public Senha(List<Integer> senha) {
		this.senha = senha;
	}

	public List<Integer> getSenha() {
		return senha;
	}

	public void setSenha(List<Integer> senha) {
		this.senha = senha;
	}
}
