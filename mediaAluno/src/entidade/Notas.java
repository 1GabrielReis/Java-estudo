package entidade;

public class Notas {
	
	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;

	
	
	public double media(){
		return nota1+ nota2+ nota3;
	}
	
	public String conclusao() {
		if (media()< 60) {
			return "REPROVADO";
		}
		else {
			return "APROVADO";
		}
	}
	
	public double reprovado() {
		return 60- media();
	}
	
}
