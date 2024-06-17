/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author 52556
 */
import beans.Entidad;
public class Localidad implements java.io.Serializable{
    private int idLocalidad;
    private String nombreLocalidad;
    private int idEntidad;
    private Entidad entidad;
    
    public Localidad(){}
    
    public Localidad(int idLocalidad, String nombreLocalidad, 
            int idEntidad, Entidad entidad, Entidad Entidad){
        this.idLocalidad = idLocalidad;
        this.nombreLocalidad = nombreLocalidad;
        this.idEntidad = idEntidad;
        this.entidad = Entidad;
    }

    Localidad(int aInt, String string, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setEntidad(Entidad read) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}