package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descri��o;
	
	private Departamento departamaneto;
	
	public Projeto() {
	}

	
	public Projeto(Integer id, String nome, String descri��o, Departamento departamaneto) {
		this.id = id;
		this.nome = nome;
		this.descri��o = descri��o;
		this.departamaneto = departamaneto;
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


	public String getDescri��o() {
		return descri��o;
	}


	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
	}


	public Departamento getDepartamaneto() {
		return departamaneto;
	}


	public void setDepartamaneto(Departamento departamaneto) {
		this.departamaneto = departamaneto;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", descri��o=" + descri��o + ", departamaneto=" + departamaneto.getId()
				+ "]";
	}

	
	
}
