package senha.core;

import java.io.InputStream;

public class Jogo {

	public static final String PARABENS_VOCE_GANHOU = "Parabens! Voce ganhou!";
	public static final String VOCE_PERDEU = "Voce perdeu!";
	private final InputStream entradaDados;
	private Adivinho adivinho;
	private Senha senha;

	public Jogo(InputStream entradaDados) {
		adivinho = new Adivinho();
		senha = new Senha();
		FornecedorDaSenha fornecedorDaSenha = new FornecedorDaSenha();
		fornecedorDaSenha.gerarNovaSenha();
		senha = fornecedorDaSenha.getSenha();
		this.entradaDados = entradaDados;
	}

	public Jogo(InputStream entradaDados, Senha senha) {
		adivinho = new Adivinho();
		this.senha = senha;
		this.entradaDados = entradaDados;
	}

	public String iniciarJogo() {
		int TAM = 5;
		
		System.out.println("A senha fornecida deve conter 4 numeros interios entre 1 e 6. "
				+ "Separados por espaco. Boa sorte!!");
						
		for (int i = 0; i < TAM; ++i) {
			System.out.println("\nNumero da Jogada " + (i + 1) + "de "+TAM );
			try {
				Tentativa t = adivinho.lerTentativa(entradaDados);
				int resultado = processarPartida(t, senha);
				if (resultado == 4) {
					return PARABENS_VOCE_GANHOU;
				}
			} catch (PinoInvalidoException p) {
				System.out.println(p.getMessage());
				--i;
			} catch (PinoJaExisteException p) {
				System.out.println(p.getMessage());
				--i;
			} catch (QuantidadePinosException e) {
				--i;
				System.out.println(e.getMessage());
			} catch (CaractereInvalidoException e) {
				--i;
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("A senha era: "+senha.getSenha());
		return VOCE_PERDEU;
	}

	public int processarPartida(Tentativa t, Senha senha) {
		Jogada j = new Jogada(t);
		j.calcularRetorno(senha);
		Retorno r = j.getSitRetorno();
		int resultado = r.printRetorno();
		return resultado;
	}
}
