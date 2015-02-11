package senha.core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Adivinho extends Jogador {

	private Scanner scanner = null;

	public Tentativa lerTentativa(InputStream is)
			throws QuantidadePinosException, PinoJaExisteException,
			PinoInvalidoException, CaractereInvalidoException {
		if (scanner == null) {
			scanner = new Scanner(is);
		}
		System.out.println("Digite sua tentativa:");
		String line = scanner.nextLine();
		return processarEntrada(line);
	}

	public Tentativa processarEntrada(String line)
			throws QuantidadePinosException, PinoInvalidoException,
			PinoJaExisteException, CaractereInvalidoException {
		ArrayList<Integer> tentativa = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(line);
		int count = st.countTokens();
		if (count != 4) {
			throw new QuantidadePinosException("Devem ser inseridos 4 pinos.");
		}
		while (st.hasMoreTokens()) {
			try {
				int v = Integer.valueOf(st.nextToken());
				
				if (v < 0 || v > 6) {
					throw new PinoInvalidoException(
							"Este valor nao eh um pino valido - valores válidos de 0 a 6");
				}
				if (tentativa.contains(v)) {
					throw new PinoJaExisteException("O pino adicionado ja existe: "+ v);
				} else {
					tentativa.add(v);
				}
			}
			catch (NumberFormatException e) {
				throw new CaractereInvalidoException("Caractere Invalido");
			}
			
		}
		return new Tentativa(tentativa);
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}
