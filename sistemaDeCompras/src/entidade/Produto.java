package entidade;

public class Produto {
	private String nome;
	private Double pre�o;
	
	// Construtores 
	public Produto() {
		
	}
	public Produto(String nome, Double pre�o) {
		this.nome=nome;
		this.pre�o=pre�o;
	}
	
	// Get e Set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public Double getPre�o() {
		return pre�o;
	}
	public void setPre�o(Double pre�o) {
		this.pre�o=pre�o;
	}
	
	public String toString() {
		StringBuilder textoFormato= new StringBuilder();
		textoFormato.append(getNome());
		return textoFormato.toString();
	}
	

}
