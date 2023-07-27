package entities;

public class Conta {
		// Atributos 
		private Integer id;  
		private String nome;
		private Double salario;
		
		// construtor 
		public Conta() {
			
		}
		
		public Conta(Integer id, String nome, Double salario) {
			this.id= id;
			this.nome= nome;
			this.salario= salario;
		}
		
		// get e set
		public Integer getId () {
			return id;
		}
		public void setId(Integer id) {
			this.id= id;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome= nome;
		}
		
		public Double getSalario() {
			return salario;
		}
		
		
		//metodos 
		
		public void novoSalario(double taxa) {
		  salario *= (1+taxa/100) ;
		}
		
		public String toString() {
			return getId()+ ", "+ getNome()+ ", "+ String.format("%.2f", getSalario());
		}
		
		
		
}
