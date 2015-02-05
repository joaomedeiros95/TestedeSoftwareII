package parameter;

public class CalculoImpostoRenda {
	
	public static void calculaImposto(double valor) {
	       //Declaração de Variáveis
	       double imposto;
	       double impostotot;
	       String porcento;

	        if (valor >= 1201 && valor <= 5000) {
	                 imposto = 1.1;
	                 porcento = "10%";
	                 impostotot = 0.1;
	        } else if(valor >= 5001 && valor <= 10000){
	                 imposto = 1.15;
	                 porcento = "15%";
	                 impostotot = 0.15;
	       } else{
	                imposto = 1.2;
	                porcento = "20%";
	                impostotot = 0.2;
	       }
	     
	       //Saída de dados
	       System.out.println("Valor:   R$ " + valor);
	       System.out.println("Imposto pago:  " + porcento + " | Valor em Dinheiro: R$" + (valor*impostotot));
	       System.out.println("Valor Total Pago  R$ " + (valor * imposto));
	    }
	
	
	public static void main(String[] args) {
		calculaImposto(200.5);
	}
}
