import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExtratoSalvo {
	
	private String texto;
	private String diretorio;
	
	public ExtratoSalvo() {
		super();
		this.texto = "";
		this.diretorio = "";
	}

	public ExtratoSalvo(String texto, String diretorio) {
		super();
		this.texto = texto;
		this.diretorio = diretorio;
	}

	public void salvar() throws IOException {
		salvar(texto, diretorio);
	}
	
	public void salvar(String texto, String diretorio) throws IOException {
		String caminho = diretorio + "/extrato.txt";
		File arquivo = new File(caminho);
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(
				arquivo.getAbsolutePath()));
		buffWrite.append(texto);
		buffWrite.close();
	}
	
	public String ler() throws IOException {
		return ler(diretorio);
	}
	
	public String ler(String diretorio) throws IOException {
		String caminho = diretorio + "/extrato.txt";
		BufferedReader buffRead = new BufferedReader(new FileReader(caminho)); 
		String retorno = "";
		String linha = "";
		while (true) { 
			if (linha != null) { 
				linha = buffRead.readLine(); 
			} 
			else 
				break; 
			
			if (linha != null) 
				retorno += (retorno != "" ? "\n" : "") + linha; 
		} 
		buffRead.close();
		
		return retorno + "\n";
	}

}
