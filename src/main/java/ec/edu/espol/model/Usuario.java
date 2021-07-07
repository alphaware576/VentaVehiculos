/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.util.Scanner;

/**
 *
 * @author alpha
 */
public abstract class Usuario {
    protected int id;
    protected String nombres;
    protected String apellidos;
    protected String correo;
    protected String clave;
    protected String organizacion;
    
    public Usuario(int id, String nombres, String apellidos, String correo, String clave, String organizacion){
        this.id=id;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.correo=correo;
        this.clave=clave;
        this.organizacion=organizacion;     
    }

    
    
}
