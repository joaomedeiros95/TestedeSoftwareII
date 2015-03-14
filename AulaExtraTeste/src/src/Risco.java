package src;

public enum Risco {

	BAIXO(1, "Risco Baixo"), MEDIO(2, "Risco Médio"), ALTO(3, "Risco Alto"), 
	NAO_AVALIADO(0, "Risco não avaliado");

	private double preco;
	private String texto;

	Risco(double preco, String texto) {
		this.preco = preco;
		this.texto = texto;
	}

	public double getPreco() {
		return this.preco;
	}

	public String getTexto() {
		return texto;
	}	

}
