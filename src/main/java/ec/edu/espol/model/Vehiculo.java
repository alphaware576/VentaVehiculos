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
 * @author alpha
 */
public class Vehiculo {
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private String tipo_motor;
    private int año;
    private String recorrido;
    private String color;
    private String tipo_comb;
    private String vidrios;
    private String transmision;
    private String traccion;
    private int precio;
    
    //carro
    public Vehiculo(int id,String placa, String marca, String modelo, String tM, int a, String recorrido, String color, String tC, String vidrios, String transmision,String traccion, int precio){
        this.id=id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_motor = tM;
        this.año = a;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_comb = tC;
        this.vidrios = vidrios;
        this.transmision=transmision;
        this.traccion=traccion;
        this.precio = precio;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_comb() {
        return tipo_comb;
    }

    public void setTipo_comb(String tipo_comb) {
        this.tipo_comb = tipo_comb;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public int getPrecio() {
        return precio;
    }

    //setters y getters
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public static boolean nextVehiculoCarro(Scanner sc, String nomfile,ArrayList<Vehiculo> vehiculos) {
        sc.useDelimiter("\n");
        System.out.println("Ingrese placa>");
        String placa = sc.next();
        System.out.println("Ingrese marca>");
        String marca = sc.next();
        System.out.println("Ingrese Modelo>");
        String modelo = sc.next();
        System.out.println("Ingrese tipo de motor >");
        String tM = sc.next();
        System.out.println("Ingrese el año >");
        int a = sc.nextInt();
        System.out.println("Ingrese el recorrido>");
        String recorrido = sc.next();
        System.out.println("Ingrese el color>");
        String color = sc.next();
        System.out.println("Ingrese el tipo de combustible>");
        String tC=sc.next();
        System.out.println("Ingrese el numero de vidrios>");
        String vidrios=sc.next();
        System.out.println("Ingrese el tipo de transmision>");
        String transmision=sc.next();
        System.out.println("Ingrese el precio>");
        int precio=sc.nextInt();
        int id = Util.nextID(nomfile);
        if(searchByPlaca(vehiculos, placa)==null){
            Vehiculo v = new Vehiculo(id, placa, marca, modelo,tM,a, recorrido,color,  tC,  vidrios, transmision,"##",precio);
            v.saveFile(nomfile);
            return true;
        }
        else
            return false;
            
        
    }
    public static boolean nextVehiculoCamioneta(Scanner sc, String nomfile,ArrayList<Vehiculo> vehiculos) {
        sc.useDelimiter("\n");
        System.out.println("Ingrese placa>");
        String placa = sc.next();
        System.out.println("Ingrese marca>");
        String marca = sc.next();
        System.out.println("Ingrese Modelo>");
        String modelo = sc.next();
        System.out.println("Ingrese tipo de motor >");
        String tM = sc.next();
        System.out.println("Ingrese el año >");
        int a = sc.nextInt();
        System.out.println("Ingrese el recorrido>");
        String recorrido = sc.next();
        System.out.println("Ingrese el color>");
        String color = sc.next();
        System.out.println("Ingrese el tipo de combustible>");
        String tC=sc.next();
        System.out.println("Ingrese el numero de vidrios>");
        String vidrios=sc.next();
        System.out.println("Ingrese el tipo de transmision>");
        String transmision=sc.next();
        System.out.println("Ingrese el tipo de traccion>");
        String traccion=sc.next();
        System.out.println("Ingrese el precio>");
        int precio=sc.nextInt();
        int id = Util.nextID(nomfile);
        if(searchByPlaca(vehiculos, placa)==null){
            Vehiculo v = new Vehiculo(id, placa, marca, modelo,tM,a, recorrido,color,  tC,  vidrios, transmision,traccion,precio);
            v.saveFile(nomfile);
            return true;
        }
        else
            return false;
        
    }
    public static boolean nextVehiculoMotocicleta(Scanner sc, String nomfile,ArrayList<Vehiculo> vehiculos) {
        sc.useDelimiter("\n");
        System.out.println("Ingrese placa>");
        String placa = sc.next();
        System.out.println("Ingrese marca>");
        String marca = sc.next();
        System.out.println("Ingrese Modelo>");
        String modelo = sc.next();
        System.out.println("Ingrese tipo de motor >");
        String tM = sc.next();
        System.out.println("Ingrese el año >");
        int a = sc.nextInt();
        System.out.println("Ingrese el recorrido>");
        String recorrido = sc.next();
        System.out.println("Ingrese el color>");
        String color = sc.next();
        System.out.println("Ingrese el tipo de combustible>");
        String tC=sc.next();
        //System.out.println("Ingrese el numero de vidrios>");
        //String vidrios=sc.next();
        //System.out.println("Ingrese el tipo de transmision>");
        //String transmision=sc.next();
        //System.out.println("Ingrese el tipo de traccion>");
        //String traccion=sc.next();
        System.out.println("Ingrese el precio>");
        int precio=sc.nextInt();
        int id = Util.nextID(nomfile);
        if(searchByPlaca(vehiculos, placa)==null){
        Vehiculo v = new Vehiculo(id, placa, marca, modelo,tM,a, recorrido,color,  tC, "##", "##","##",precio);
        v.saveFile(nomfile);
        return true;
        }
        else return false;
    }
     //guarda en un archivo de tec=xto plano a una instancia de la clase vendedor       
    public void saveFile(String nomfile){
        //fileoutpustream permite abrir el archivo en pmodo append
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipo_motor+"|"+this.año+"|"+this.recorrido+"|"+this.color+"|"+this.tipo_comb+"|"+this.vidrios+"|"+this.transmision+"|"+this.traccion+"|"+this.precio);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //carga la base de datos de vendedores desde archivos en texto plano al iniciar el programa principal o Main
    public static ArrayList<Vehiculo> readFile(String nomfile){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "1|Juan|Perez|jperez@example.com|1234567890|espol"
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],Integer.parseInt(tokens[5]),tokens[6],tokens[7],tokens[8],tokens[9],tokens[10],tokens[11],Integer.parseInt(tokens[12]));
                vehiculos.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
    //busca a un vendedor por su identificador unico
    public static Vehiculo searchByID(ArrayList<Vehiculo> vehiculos, int id)
    {
        for(Vehiculo v : vehiculos)
        {
            if(v.id == id)
                return v;
        }
        return null;
    }
    //valida cuando se registra un vendedor que el correo sea unico dentro de los que ya estan almacenadosen la base de datos
    public static Vehiculo searchByPlaca(ArrayList<Vehiculo> vehiculos, String placa)
    {
        for(Vehiculo v : vehiculos)
        {
            if(v.placa.equals(placa))
                return v;
        }
        return null;
    }
    
}
