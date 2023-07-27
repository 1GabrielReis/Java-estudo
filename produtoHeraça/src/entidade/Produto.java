package entidade;

public class Produto {
	private String nome;
	private Double pre�o; 
	
	// construtores 
	public Produto() {
		
	}
	public Produto(String nome, Double pre�o) {
		this.nome=nome;
		this.pre�o=pre�o;
	}
	
	// get e set 
	public String getNome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome= nome;
	}
	
	public double getPre�o() {
		return pre�o;
	}
	public void setPre�o(Double pre�o) {
		this.pre�o=pre�o;
	}
	
	//metodo
	// toString
	public String toString() {
		return nome+ " - R$: "+String.format("%.2f", pre�o);
	}				
}
