import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		String product1 ="Computer";
		String product2 = "office desk";
		
		byte age = 30;
		short code = 5290;
		char gender = 'F';
		
		double prince1 = 2100.00;
		double prince2 = 650.50;
		double measure = 53.234567;
		
		Locale.setDefault(Locale.US);
		System.out.println("Products:");
		System.out.println( product1 + ", which price is $ "+ prince1 );
		System.out.println( product2 + ", whitch price is $ "+ prince2);
		System.out.println("");
		System.out.println("Record: " + age + " years old, code "+ code + " and gender: "+ gender );
		System.out.println("");
		System.out.printf("Measue with eight decimal place: %.9f %n", measure);
		System.out.printf("Rouded (three decimal place): %.3f %n", measure);
		System.out.printf("Us decimal point: %.3f %n", measure);
		
		
		
		
		//double x= 10.35784;
		
		//System.out.println("boa noite");

		//System.out.printf("%.2f%n", x);
		//Locale.setDefault(Locale.US);
		//System.out.printf("%.2f%n", x);
		
		//System.out.println("Resultafo= "+ x +" metros");
		//System.out.printf("Resultado= %.2f metros%n", x);

	}

}
