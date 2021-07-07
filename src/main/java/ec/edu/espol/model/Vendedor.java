/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Johnny D.Parrales
 */
public class Vendedor extends Usuario {
    private int idOferta;
    
    
    public Vendedor(int id, String nombres, String apellidos, String correo, String clave, String organizacion){
        super(id, nombres,apellidos,correo,clave,organizacion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
        
        public static void nextVendedor(Scanner sc, String nomfile)
    {
        System.out.println("Ingrese nombres>");
        String nombres = sc.next();
        System.out.println("Ingrese apellidos>");
        String apellidos = sc.next();
        System.out.println("Ingrese organizacion>");
        String organizacion = sc.next();
        System.out.println("Ingrese correo electronico>");
        String correo = sc.next();
        System.out.println("Ingrese clave>");
        String clave = sc.next();
        int id = Util.nextID(nomfile);
        Vendedor v = new Vendedor(id,nombres,apellidos,correo,clave,organizacion);
        v.saveFile(nomfile);
    }
            
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombres+"|"+this.apellidos+"|"+this.correo+"|"+this.clave+"|"+this.organizacion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Vendedor> readFile(String nomfile){
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "1|Juan|Perez|jperez@example.com|1234567890|espol"
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vendedor v = new Vendedor(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                vendedores.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vendedores;
    }
    
    public static Vendedor searchByID(ArrayList<Vendedor> vendedores, int id)
    {
        for(Vendedor v : vendedores)
        {
            if(v.id == id)
                return v;
        }
        return null;
    }
    
    public static Vendedor searchByCorreo(ArrayList<Vendedor> vendedores, String correo)
    {
        for(Vendedor v : vendedores)
        {
            if(v.correo.equals(correo))
                return v;
        }
        return null;
    }
    
    
}
