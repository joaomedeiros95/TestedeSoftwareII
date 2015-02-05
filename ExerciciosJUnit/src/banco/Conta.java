package banco;


public class Conta{

	private String codigo;
	private double saldo = 0;

	public Conta (String p_id, double p_saldo) { 
		this.saldo = p_saldo;
	    this.codigo = p_id;
	}
	
	public double getSaldo() {
		return saldo;
	} 
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double debitar (double valor) throws OperacaoIlegalException {
		
		
		if(valor > 0 && saldo >= valor){
	         saldo = saldo-valor; 
	    }
		else{
			throw new OperacaoIlegalException();
		}
	   return saldo;

	}


	public double creditar (double valor) throws OperacaoIlegalException {
		
		
		if(valor > 0 ){
	         saldo = saldo+valor; 
	    }
		else{
			throw new OperacaoIlegalException();
		}
	   return saldo;

	}
	
	public double transferir (double valor, Conta destino) throws OperacaoIlegalException {
		if(valor > 0 && saldo >= valor) {
			saldo = saldo - valor;
			destino.setSaldo(destino.getSaldo() + valor);
		} else {
			throw new OperacaoIlegalException();
		}
		return saldo;
	}
	
		
}

	

