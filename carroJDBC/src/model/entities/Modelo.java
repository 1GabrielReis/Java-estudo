package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Modelo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer ano;
	private Fabricante fabricante;
	
	public Modelo() {
	}
	
	public Modelo(Integer id, String nome, Integer ano, Fabricante fabricante) {
		super();
		this.id = id;
		this.nome = nome;
		this.ano = ano;
		this.fabricante = fabricante;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public Fabricante getFabricante() {
		return fabricante;
	}


	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ano, fabricante, id, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(fabricante, other.fabricante)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}


	@Override
	public String toString() {
		return "Modelo [id=" + id + ", nome=" + nome + ", ano=" + ano + ", fabricanteId=" + fabricante.getId() + "]";
	}

}
