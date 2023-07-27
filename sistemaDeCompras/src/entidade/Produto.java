package entidade;

public class Produto {
	private String nome;
	private Double preço;
	
	// Construtores 
	public Produto() {
		
	}
	public Produto(String nome, Double preço) {
		this.nome=nome;
		this.preço=preço;
	}
	
	// Get e Set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public Double getPreço() {
		return preço;
	}
	public void setPreço(Double preço) {
		this.preço=preço;
	}
	
	public String toString() {
		StringBuilder textoFormato= new StringBuilder();
		textoFormato.append(getNome());
		return textoFormato.toString();
	}
	

}
