package entidade;

import java.text.SimpleDateFormat;
import java.util.Date;



public final class ProdutoUsado extends Produto {
	
	private static final SimpleDateFormat formatoData= new SimpleDateFormat("dd/MM/yyyy"); 
	
	private Date fabriçaoData;
	
	// construtores 
	public ProdutoUsado() {
		super();
	}
	public ProdutoUsado(String nome, Double preço, Date fabriçaoData) {
		super(nome, preço);
		this.fabriçaoData= fabriçaoData;
	}
	
	// get e set 
	public Date getFabricaoData() {
		return fabriçaoData;
	}
	public void setFabriçaoData(Date fabriçaoData) {
		this.fabriçaoData= fabriçaoData;
	}
	
	// metodos 
	// toString
	@Override
	public String toString() {
		return getNome()+ " (usado) - R$: "+String.format("%.2f", getPreço())+" "+ formatoData.format(fabriçaoData)+ " ";
	}
	
}
