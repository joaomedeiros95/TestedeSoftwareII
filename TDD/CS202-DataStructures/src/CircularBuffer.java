public class CircularBuffer {
	
	private static int CAPACIDADE;
	private Integer[] num;
	private int fim;
	private int inicio;
	private int buflen;
	
	public CircularBuffer(int tamanho) {
		CAPACIDADE = tamanho;
		num = new Integer[tamanho];
		fim = -1;
		inicio = -1;
		buflen = 0;
	}
	
	public boolean isEmpty() {
		return buflen == 0;
	}

	public boolean isFull() {
		return buflen == CAPACIDADE;
	}

	public void Put(int valor) {
		if(isFull())
			throw new CircularBufferException("Put to full circular buffer");
		
		buflen++;
		fim = (fim + 1) % CAPACIDADE;
		num[fim] = valor;
	}

	public long Get() {
		if(isEmpty())
			throw new CircularBufferException("Get from empty circular buffer");
		
		buflen--;
		inicio = (inicio + 1) % CAPACIDADE;
		int retorno = num[inicio];
		return retorno;
	}

	public int capacity() {
		return CAPACIDADE;
	}
	
	public int size() {
		return num.length;
	}
	
}
