package util;

public class converte {

	public static final double IOF= 0.06;
	
	
	public static double conver��o(double cot, double valor) {
		return cot* valor;
	}
	
	public static double conver��oImposto(double cot, double valor) {
		return cot* valor* (1.0+ IOF);
	}
	
	
	
}
