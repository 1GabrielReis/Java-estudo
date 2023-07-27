package entidade;

public class Item {
	private Integer quantidade;
	private Double pre�o;
	
	private Produto produto;
	
	// Construtores 
	public Item() {
		
	}
	public Item(Integer quantidade, Double pre�o, Produto produto) {
		this.quantidade= quantidade;
		this.pre�o= pre�o;
		this.produto= produto;
	}
	
	//Get e Set
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade=quantidade;
	}
	public Double getPre�o() {
		return pre�o;
	}
	public void setPre�o(Double pre�o) {
		this.pre�o=pre�o;
	}
	
	//Metodo
	public Double total() {
		return quantidade*pre�o;
	}
	
	public String toString() {
		StringBuilder textoFormato= new StringBuilder();
		textoFormato.append(produto.getNome()+ ", ");
		textoFormato.append("$"+String.format("%.2f", getPre�o())+", ");
		textoFormato.append("Quantidade: "+getQuantidade()+", ");
		textoFormato.append("Total: $"+String.format("%.2f",total()));
		return textoFormato.toString();
		
	}
	
	

}
