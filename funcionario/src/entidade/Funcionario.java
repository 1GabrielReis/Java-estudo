package entidade;

public class Funcionario {
	
	public String nome;
	public double salario;
	public double imposto;
	
	
	
	
	
	public double salarioL() {
		double salarioLiquido= salario- imposto; 
		return salarioLiquido;
	}
	
	public void salarioN(double porcentagem) {
		salario= ((salario-imposto)* (porcentagem/100))+ (salario-imposto);
	
	}
	public String toString() {
		return "Dados atualizados: "+ nome+ " salario liquido: "+ String.format("%.2f", salario); 
	}
	
	
	
	
		
	

}
