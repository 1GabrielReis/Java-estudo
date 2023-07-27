package entidade;

public final class ProdutoImportado extends Produto {
	private Double preçoFrete;
	
	// construtores 
	public ProdutoImportado() {
		super();
	}
	public ProdutoImportado(String nome, Double preço, Double preçoFrete ) {
		super(nome, preço);
		this.preçoFrete= preçoFrete;
	}
	
	// get set
	public Double getPreçoFrete() {
		return preçoFrete;
	}
	public void setPreçoFrete(Double preçoFrete) {
		this.preçoFrete= preçoFrete;
	}
	
	// metodos
	
	public Double preçoTotal() { // prel=ço esta no modo protected
		return getPreço()+ preçoFrete;
	}
	
	@Override  
	public String toString() {
		return getNome()+ " - R$: "+String.format("%.2f", preçoTotal())+" Frete  R$: "+String.format("%.2f", preçoFrete);
	}
	

}
