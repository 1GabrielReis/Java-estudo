package projetoProva;

public class Elevador {
	private double carga; 

    private String marca;

    private int passageiros; 


    public void transportar(int passageiros) {

        if (passageiros >= 0 && passageiros <= 14) {

            this.passageiros = passageiros;

            System.out.println("Atribuído com sucesso");

        } else {

            System.out.println("Valor inválido!");

        }

    }


    public int getPassageiros() {

        return passageiros;

    }


    public void setMarca(String marca) {

        this.marca = marca;

    }


    public String getMarca() {

        return marca;

    }


    public double getCarga() {

        return carga;

    }


    public void transportar(double carga) {

        if (carga < 0 || carga > 1500) {

            System.out.println("Valor inválido!");

        } else {

            this.carga = carga;

        }

    }



}
