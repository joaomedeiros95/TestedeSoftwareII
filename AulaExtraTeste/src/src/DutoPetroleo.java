package src;

public class DutoPetroleo { 
	
	public Risco calculaRiscoExplosao(double percentual_cheio, int temperature_ambiente) {
		if(percentual_cheio >= 30.0 && percentual_cheio <= 70.0) {
			if(temperature_ambiente >= 15 && temperature_ambiente <= 30) {
				return Risco.BAIXO;
			} else if (temperature_ambiente >= 31 && temperature_ambiente <= 60) {
				return Risco.MEDIO;
			}
		} else if(temperature_ambiente > 60 || percentual_cheio > 70.0) {
			return Risco.ALTO;
		}
		
		return Risco.NAO_AVALIADO;
	}

}
