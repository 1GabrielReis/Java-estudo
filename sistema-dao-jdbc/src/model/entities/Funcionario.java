package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double salario;
	
	private Departamento departamento;
	
	public Funcionario() {
	}
	public Funcionario(Integer id, String nome, Double salario, Departamento departamento) {
		this.id= id;
		this.nome= nome;
		this.salario= salario;
		
		this.departamento= departamento;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id= id;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome) {
		this.nome= nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario= salario;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento= departamento;
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", salario=" + String.format("%.2f", salario) + ", departamento=" + departamento + "]";
	}
		
}
