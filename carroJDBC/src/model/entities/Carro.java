package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String placa;
	private String cor;
	
	private Modelo modelo;
	
	public Carro() {
		
	}
	
	public Carro(Integer id, String placa, String cor, Modelo modelo) {
		this.id = id;
		this.placa = placa;
		this.cor = cor;
		this.modelo = modelo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
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
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", placa=" + placa + ", cor=" + cor + ", modelo=" + modelo.getId() + "]";
	}
	

}
