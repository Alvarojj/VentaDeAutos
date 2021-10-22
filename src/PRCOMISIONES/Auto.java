/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRCOMISIONES;

/**
 *
 * @author Alvaro J
 */
public class Auto {
    //Atributos
    private static String sempresa= "Empresa Jimenez";
    private final String splaca;
    private String marca;
    private int emodelo;
    private int eprecio;
    private String scolor;
    private int ekil;
    private char cestado='D';
    
    //Metodos

    public Auto(String splaca, String marca, int emodelo, int eprecio, String scolor, int ekil) {
        this.splaca = splaca;
        this.marca = marca;
        this.emodelo = emodelo;
        this.eprecio = eprecio;
        this.scolor = scolor;
        this.ekil = ekil;
    }

    public String getSplaca() {
        return splaca;
    }

    public int getEprecio() {
        return eprecio;
    }

    public char getCestado() {
        return cestado;
    }

    public void setCestado(char cestado) {
        this.cestado = cestado;
    }
    public String Mostrar(){
        String salida;
        salida= "placa: "+ splaca + "\nPrecio: " + eprecio+ "\nEstado: " + cestado;
        return salida;
    }
}
