package entidade;

public class Produto {
	private String nome;
	private Double preço; 
	
	// construtores 
	public Produto() {
		
	}
	public Produto(String nome, Double preço) {
		this.nome=nome;
		this.preço=preço;
	}
	
	// get e set 
	public String getNome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome= nome;
	}
	
	public double getPreço() {
		return preço;
	}
	public void setPreço(Double preço) {
		this.preço=preço;
	}
	
	//metodo
	// toString
	public String toString() {
		return nome+ " - R$: "+String.format("%.2f", preço);
	}				
}
