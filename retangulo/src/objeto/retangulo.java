package objeto;

public class retangulo {
	
	public double largura;
	public double comprimento;
	
	
	public double area() {
		double areaN= largura* comprimento;
		return areaN;
		// return largura* comprimento;
	}
	
	public double perimetro() {
		double perimetroN= (2* largura)+ (2* comprimento);
		return perimetroN;
		// return (2* largura)+ (2* comprimento);
	}
	
	public double diagonal() {
		double diagonalN= Math.sqrt((Math.pow(largura, 2)+ Math.pow(comprimento, 2)));
		return diagonalN;
		// return Math.sqrt((Math.pow(largura, 2)+ Math.pow(comprimento, 2)));
	}
	
	
	
}
