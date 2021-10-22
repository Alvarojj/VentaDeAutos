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
public class Venta {

    //Atributos
    private String splaca;
    private String scedula;
    private int evalor;
    //Metodos

    public Venta(String splaca, String scedula, int evalor) {
        this.splaca = splaca;
        this.scedula = scedula;
        this.evalor = evalor;
    }

    public int getEvalor() {
        return evalor;
    }

    public String getSplaca() {
        return splaca;
    }

    public String getScedula() {
        return scedula;
    }
    
    public String Mostrar() {
        String salida;
        salida = "placa: " + splaca +"\nCC vendedor: "+ scedula+ "\nPrecio: " + evalor;
        return salida;
    }

}
