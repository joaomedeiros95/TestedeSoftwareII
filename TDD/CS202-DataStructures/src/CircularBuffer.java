public class CircularBuffer {
	
	private static int CAPACIDADE;
	private Integer[] num;
	private int atual;
	
	public CircularBuffer(int tamanho) {
		num = new Integer[tamanho];
		CAPACIDADE = tamanho;
		atual = 0;
	}
	
	public boolean isEmpty() {
		return num[0] == null && num[finalvetor()] == null;
	}

	public boolean isFull() {
		return atual == capacity() && num[0] != null;
	}

	public void Put(int valor) {
		if(isFull())
			throw new CircularBufferException("Put to full circular buffer");
		
		num[atual] = valor;
		atual++;
	}

	public long Get() {
		if(isEmpty())
			throw new CircularBufferException("Get from empty circular buffer");
		
		int retorno = num[0];
		num[0] = null;
		return retorno;
	}

	public int capacity() {
		return CAPACIDADE;
	}
	
	public int size() {
		return num.length;
	}
	
	public int finalvetor() {
		return CAPACIDADE - 1;
	}

}
