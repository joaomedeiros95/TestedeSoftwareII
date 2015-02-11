/**
 * João Eduardo Ribeiro de Medeiros - 2013020793
 * Universidade Federal do Rio Grande do Norte
 * Bacharelado em Tecnologia da Informação
 * Criado em 11/02/2015
 */
package fila;

/**
 * @author joao
 *
 */
public class FilaCircular implements IFila {
	
	private static int CAPACIDADE = 5;
	private Object[] filaCircular;  //Array que representa a fila
	private int fim = 0, inicio = 0, tamanho = 0; //final da fila
	

	public FilaCircular(int tamanho) {
		filaCircular = new Object[tamanho];
		CAPACIDADE = tamanho;
	}
	
	public FilaCircular() {
		this(CAPACIDADE);
	}
	
	@Override
	public int tamanho() {
		return fim;
	}

	@Override
	public boolean estaVazia() {
		return tamanho == 0;
	}

	@Override
	public boolean estaCheia() {
		return tamanho == CAPACIDADE;
	}

	@Override
	public void insereNaFila(Object obj) throws FilaCheiaException {
		if(tamanho == CAPACIDADE) {
			throw new FilaCheiaException();
		} {
			filaCircular[fim] = obj;
			fim = (fim + 1) % CAPACIDADE;
			tamanho++;
		}
	}

	@Override
	public Object removeDaFila() throws FilaVaziaException {
		if(tamanho > 0) {
			Object retorno = filaCircular[inicio];
			filaCircular[inicio] = 0;
			inicio = (inicio + 1) % CAPACIDADE;
			tamanho--;
			return retorno;
		} else {
			throw new FilaVaziaException();
		}
	}

}
