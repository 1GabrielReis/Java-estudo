package entidade;

public class Item {
	private Integer quantidade;
	private Double preço;
	
	private Produto produto;
	
	// Construtores 
	public Item() {
		
	}
	public Item(Integer quantidade, Double preço, Produto produto) {
		this.quantidade= quantidade;
		this.preço= preço;
		this.produto= produto;
	}
	
	//Get e Set
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade=quantidade;
	}
	public Double getPreço() {
		return preço;
	}
	public void setPreço(Double preço) {
		this.preço=preço;
	}
	
	//Metodo
	public Double total() {
		return quantidade*preço;
	}
	
	public String toString() {
		StringBuilder textoFormato= new StringBuilder();
		textoFormato.append(produto.getNome()+ ", ");
		textoFormato.append("$"+String.format("%.2f", getPreço())+", ");
		textoFormato.append("Quantidade: "+getQuantidade()+", ");
		textoFormato.append("Total: $"+String.format("%.2f",total()));
		return textoFormato.toString();
		
	}
	
	

}
