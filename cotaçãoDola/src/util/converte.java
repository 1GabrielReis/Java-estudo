package util;

public class converte {

	public static final double IOF= 0.06;
	
	
	public static double converção(double cot, double valor) {
		return cot* valor;
	}
	
	public static double converçãoImposto(double cot, double valor) {
		return cot* valor* (1.0+ IOF);
	}
	
	
	
}
