package senha.core;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws PinoJaExisteException,
			PinoInvalidoException, QuantidadePinosException {
		Jogo j = new Jogo(System.in);
		System.out.println("INICIANDO O JOGO ADIVINHE A SENHA...");
		System.out.println(j.iniciarJogo());
	}
}
