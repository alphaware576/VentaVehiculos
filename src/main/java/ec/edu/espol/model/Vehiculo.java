/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alpha
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String tipo_motor;
    private int año;
    private int recorrido;
    private String color;
    private String tipo_comb;
    private String vidrios;
    private String transmision;
    private String traccion;
    private int precio;
    
    
    public Vehiculo(){
    }
    //carro
    public Vehiculo(String pl, String ma, String mo, String tM, 
        int a, int r, String c, String tC, String v, String trs, int p){
        this.placa = pl;
        this.marca = ma;
        this.modelo = mo;
        this.tipo_motor = tM;
        this.año = a;
        this.recorrido = r;
        this.color = c;
        this.tipo_comb = tC;
        this.vidrios = v;
        this.transmision = trs;
        this.precio = p;
    }
    //camioneta
    public Vehiculo(String pl, String ma, String mo, String tM, 
            int a, int r, String c, String tC, String v, String trs, 
        String trc, int p){
        this.placa = pl;
        this.marca = ma;
        this.modelo = mo;
        this.tipo_motor = tM;
        this.año = a;
        this.recorrido = r;
        this.color = c;
        this.tipo_comb = tC;
        this.vidrios = v;
        this.transmision = trs;
        this.traccion = trc;
        this.precio = p;
    }
    //moto
    public Vehiculo(String pl, String ma, String mo, String tM, 
        int a, int r, String c, String tC, int p){
        this.placa = pl;
        this.marca = ma;
        this.modelo = mo;
        this.tipo_motor = tM;
        this.año = a;
        this.recorrido = r;
        this.color = c;
        this.tipo_comb = tC;
        this.precio = p;
    }
    
    //setters y getters
    public void setPlaca(String p){
        this.placa = p;
    }
    
    public void setMarca(String m){
        this.marca = m;
    }
    
    public void setModelo(String m){
        this.modelo = m;
    }
    
    public void setTipo_M(String tM){
        this.tipo_motor = tM;
    }
    
    public void setAño(int a){
        this.año = a;
    }
    
    public void setRecorrido(int r){
        this.recorrido = r;
    }
    
    public void setColor(String c){
        this.color = c;
    }
    
    public void setTipo_C(String c){
        this.tipo_comb = c;
    }
    
    public void setVidrios(String v){
        this.vidrios = v;
    }
    
    public void setTransmision(String t){
        this.transmision = t;
    }
    
    public void setTraccion(String t){
        this.traccion = t;
    }
    
    public void setPrecio(int p){
        this.precio = p;
    }
    
    public String setPlaca(){
        return this.placa;
    }
    
    public String setMarca(){
        return this.marca;
    }
    
    public String setModelo(){
        return this.modelo;
    }
    
    public String setTipo_M(){
        return this.tipo_motor;
    }
    
    public int setAño(){
        return this.año;
    }
    
    public int setRecorrido(){
        return this.recorrido;
    }
    
    public String setColor(){
        return this.color;
    }
    
    public String setTipo_C(){
        return this.tipo_comb;
    }
    
    public String setVidrios(){
        return this.vidrios;
    }
    
    public String setTransmision(){
        return this.transmision;
    }
    
    public String setTraccion(){
        return this.traccion;
    }
    
    public int setPrecio(){
        return this.precio;
    }
    public static void nextVehiculo(Scanner sc, String nomfile)
    {
        sc.useDelimiter("\n");
        System.out.println("Ingrese el tipo de vehiculo>");
        System.out.println("1.Camioneta 2.Carro 3.Moto");
        int opt = sc.nextInt();
        System.out.println("Ingrese marca>");
        String apellidos = sc.next();
        System.out.println("Ingrese Modelo>");
        String organizacion = sc.next();
        System.out.println("Ingrese Tipo >");
        String correo = sc.next();
        System.out.println("Ingrese clave>");
        String clave = sc.next();
        String clave_sha256 = Util.convertirSHA256(clave);
        int id = Util.nextID(nomfile);
        //Vendedor v = new Vendedor(id,nombres,apellidos,correo,clave_sha256,organizacion);
        //v.saveFile(nomfile);
    }
    public boolean validar(){
        List<String> lst = new ArrayList();
        for (int i = 0 ; i < lst.size() ; i++){
            if (this.placa.equals(lst.get(i)))
                return true;
        }
        return false;
    }
    
}
