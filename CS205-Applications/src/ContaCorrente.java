import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

	private int saldo;
	private int saldo_anterior;
	private String nome;
	private List<Deposito> deposito;

	public ContaCorrente() {
		this.nome = "James Grenning";
		this.saldo = 0;
		this.saldo_anterior = 0;
		deposito = new ArrayList<Deposito>();
	}

	public ContaCorrente(int saldo) {
		this.saldo = saldo;
		this.saldo_anterior = 0;
		this.nome = "James Grenning";
		deposito = new ArrayList<Deposito>();
	}

	public ContaCorrente(String nome) {
		this.nome = nome;
		this.saldo = 0;
		this.saldo_anterior = 0;
		deposito = new ArrayList<Deposito>();
	}

	public ContaCorrente(String nome, int saldo) {
		super();
		this.saldo = saldo;
		this.nome = nome;
		this.saldo_anterior = 0;
		deposito = new ArrayList<Deposito>();
	}

	public Object saldo() {
		return saldo;
	}

	public void creditar(Deposito dep) {
		deposito.add(dep);
		saldo += dep.valor();
	}

	public String extrato() {
		String retorno = "Conta de " + nome + "\n" +
				"Saldo Inicial $" + (deposito.isEmpty() ? saldo : saldo_anterior) +"\n" +
				"Saldo Final $" + saldo + "\n";
		if(deposito.isEmpty())
			retorno += "Nenhuma trasacao realizada\n"; 
		else	
			for(Deposito dep : deposito) 
				retorno += dep.data + "\tDeposito\t$" + dep.valor+"\n";
		
		return retorno;
	}
	
	public String verExtratoEmArquivo(ExtratoSalvo extratoSalvo) throws IOException {
		return extratoSalvo.ler();
	}
}
