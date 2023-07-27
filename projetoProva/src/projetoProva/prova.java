package projetoProva;

public class prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Elevador e=new Elevador();

	        e.setMarca("Otis");

	        e.transportar(1500); 

	        System.out.println("Passageiros: "+e.getPassageiros());

	        System.out.println("Carga: "+e.getCarga());

	}

}
