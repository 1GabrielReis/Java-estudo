package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Fabricante implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String paisOrigem;
	
	public Fabricante() {
	}

	public Fabricante(Integer id, String nome, String paisOrigem) {
		this.id = id;
		this.nome = nome;
		this.paisOrigem = paisOrigem;
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

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, paisOrigem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(paisOrigem, other.paisOrigem);
	}

	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", nome=" + nome + ", paisOrigem=" + paisOrigem + "]";
	}
	
	
}
