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
public class Vendedor {
    //Atributos
    private final String scedula;
    private String snombre;
    private int ecomision=0;
    
    //Metodos

    public Vendedor(String scedula, String snombre) {
        this.scedula = scedula;
        this.snombre = snombre;
    }

    public String getScedula() {
        return scedula;
    }

    public void setEconmision(int ecomision) {
        this.ecomision = this.ecomision + ecomision;
    }
    
    public String Mostrar(){
        String salida;
        salida= "Cedula: " + scedula +"\nNombre: " + snombre;
        return salida;
    }
    //Mostrar con la comision agregada
    public String MostrarL(){
        String salida;
        salida = "Cedula: " + scedula +"\nNombre: " + snombre +"\nComisiones: " + ecomision;
        return salida;
    }
}
