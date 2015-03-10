package pck;
/**
 * Classe que contem informacoes sobre o recrutamento de candidatos.
 *
 */
public class RecrutamentoFuncionario {
	
	/**
	 * Metodo que indica se um candidado pode ser recrutado ou nao, de acordo com sua idade.
	 * 
	 * @param idade
	 * @return
	 * @throws Exception
	 */
	public static TipoEmprego empregar(int idade) throws Exception {
		if (idade < 0 || idade > 99)
			throw new Exception("Idade Invalida");
		if (idade < 16 || idade > 55)
			return TipoEmprego.NAO_EMPREGAR;
		else if (idade >= 16 && idade < 18)
			return TipoEmprego.EMPREGAR_PARCIALMENTE;
		else return TipoEmprego.EMPREGAR;
	}
	
}
