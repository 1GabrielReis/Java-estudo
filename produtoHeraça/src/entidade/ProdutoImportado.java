package entidade;

public final class ProdutoImportado extends Produto {
	private Double pre�oFrete;
	
	// construtores 
	public ProdutoImportado() {
		super();
	}
	public ProdutoImportado(String nome, Double pre�o, Double pre�oFrete ) {
		super(nome, pre�o);
		this.pre�oFrete= pre�oFrete;
	}
	
	// get set
	public Double getPre�oFrete() {
		return pre�oFrete;
	}
	public void setPre�oFrete(Double pre�oFrete) {
		this.pre�oFrete= pre�oFrete;
	}
	
	// metodos
	
	public Double pre�oTotal() { // prel=�o esta no modo protected
		return getPre�o()+ pre�oFrete;
	}
	
	@Override  
	public String toString() {
		return getNome()+ " - R$: "+String.format("%.2f", pre�oTotal())+" Frete  R$: "+String.format("%.2f", pre�oFrete);
	}
	

}
