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
    private String tipo_v;
    private String placa;
    private String marca;
    private String modelo;
    private String tipo_motor;
    private String año;
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
    public Vehiculo(int id, String tV, String pl, String ma, String mo, String tM, 
            String a, int r, String c, String tC, String v, String trs, int p){
        this.tipo_v = tV;
        this.id = id;
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
    public Vehiculo(int id, String tV, String pl, String ma, String mo, String tM, 
            String a, int r, String c, String tC, String v, String trs, 
            String trc, int p){
        this.tipo_v = tV;
        this.id = id;
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
    public Vehiculo(int id, String tV, String pl, String ma, String mo, String tM, 
            String a, int r, String c, String tC, int p){
        this.tipo_v = tV;
        this.id = id;
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
    public void setId(int id){
        this.id = id;
    }
    
    public void settipo_Veh(String tV){
        this.tipo_v = tV;
    }
    
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
    
    public void setAño(String a){
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
    
    public int getId(){
        return this.id;
    }
    
    public String getTipo_Veh(){
        return this.tipo_v;
    }
    
    public String getPlaca(){
        return this.placa;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public String getTipo_M(){
        return this.tipo_motor;
    }
    
    public String getAño(){
        return this.año;
    }
    
    public int getRecorrido(){
        return this.recorrido;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public String getTipo_C(){
        return this.tipo_comb;
    }
    
    public String getVidrios(){
        return this.vidrios;
    }
    
    public String getTransmision(){
        return this.transmision;
    }
    
    public String getTraccion(){
        return this.traccion;
    }
    
    public int getPrecio(){
        return this.precio;
    }
    
    //crea un nuevo objeto vendedor si o solo si el vehiculo del nuevo ingreso no se encuentra registrado ya en la base de datos
    public static boolean nextVehiculo(Scanner sc, String nomfile,ArrayList<Vehiculo> vehiculos){
        sc.useDelimiter("\n");
        System.out.println("Ingrese el Tipo de Vehículo: ");
        System.out.println("1. Carro\n2. Camioneta\n3. Moto");
        int tipo_veh = sc.nextInt();
        System.out.println("Ingrese la Placa: ");
        String placa = sc.next();
        System.out.println("Ingrese la Marca:");
        String marca = sc.next();
        System.out.println("Ingrese el Modelo: ");
        String modelo = sc.next();
        System.out.println("Ingrese el tipo de Motor: ");
        String tipo_motor = sc.next();
        System.out.println("Ingrese el Año: ");
        String año = sc.next();
        System.out.println("Ingrese el Recorrido: ");
        int recorrido = sc.nextInt();
        System.out.println("Ingrese el Color: ");
        String color = sc.next();
        System.out.println("Ingrese el tipo de Combustible: ");
        String tipo_comb = sc.next();
        System.out.println("Ingrese el Precio: ");
        int precio = sc.nextInt();
        int id = Util.nextID(nomfile);
        if (tipo_veh == 1){
            System.out.println("Ingrese los Vidrios del Vehiculo: ");
            String vidrios = sc.next();
            System.out.println("Ingrese la Transmision: ");
            String transmision = sc.next();
            String tV = "Carro";
            if(searchByPlaca(vehiculos, placa)== null){
                Vehiculo v = new Vehiculo(id,tV,placa,marca,modelo,tipo_motor,año,
                recorrido,color,tipo_comb,vidrios,transmision,precio);
                //agrego a la memoria primero
                vehiculos.add(v);
                //agrego luego al archivo de texto
                v.saveFile(nomfile, tV);
                //retorno verdadero cuadno la operacion fue exitosa
                return true;
            }
            else
                //retorno falso cuando la operacion no se logro con exito
                return false;
        }
        if (tipo_veh == 2){
            System.out.println("Ingrese los Vidrios del Vehiculo: ");
            String vidrios = sc.next();
            System.out.println("Ingrese la Transmision: ");
            String transmision = sc.next();
            System.out.println("Ingrese la Tracción: ");
            String traccion = sc.next();
            String tV = "Camioneta";
            if(searchByPlaca(vehiculos, placa)== null){
                Vehiculo v = new Vehiculo(id,tV,placa,marca,modelo,tipo_motor,año,
                recorrido,color,tipo_comb,vidrios,transmision,traccion,precio);
                vehiculos.add(v);
                v.saveFile(nomfile, tV);
                return true;
            }
            else
                return false;
        }
        
        if (tipo_veh == 3){
            String tV = "Moto";
            if(searchByPlaca(vehiculos, placa)== null){
                Vehiculo v = new Vehiculo(id,tV,placa,marca,modelo,tipo_motor,año,
                recorrido,color,tipo_comb,precio);
                vehiculos.add(v);
                v.saveFile(nomfile, tV);
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    
    //guarda en un archivo de texto plano a una instancia de la clase vehiculo
    public void saveFile(String nomfile, String tV){
        //fileoutpustream permite abrir el archivo en modo append
        if (tV.equals("Carro")){
            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
                pw.println(this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipo_motor+"|"+this.año+"|"+this.recorrido+"|"+
                        this.color+"|"+this.tipo_comb+"|"+this.vidrios+"|"+this.transmision+"|"+this.precio);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        if (tV.equals("Camioneta")){
            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
                pw.println(this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipo_motor+"|"+this.año+"|"+this.recorrido+"|"+
                        this.color+"|"+this.tipo_comb+"|"+this.vidrios+"|"+this.transmision+"|"+this.traccion+"|"+this.precio);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        if (tV.equals("Moto")){
            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
                pw.println(this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipo_motor+"|"+this.año+"|"+this.recorrido+"|"+
                        this.color+"|"+this.tipo_comb+"|"+this.precio);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    //carga la base de datos de vehiculos desde archivos en texto plano al iniciar el programa principal o Main
    public static ArrayList<Vehiculo> readFile(String nomfile, String tV){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            if (tV.equals("Carro")){
                while(sc.hasNextLine()){
                    // linea = "1|Juan|Perez|jperez@example.com|1234567890|espol"
                    String linea = sc.nextLine();
                    String[] tokens = linea.split("\\|");
                    Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],
                            Integer.parseInt(tokens[7]),tokens[8],tokens[9],tokens[10],tokens[11],Integer.parseInt(tokens[12]));
                    vehiculos.add(v);
                }
            }
            if (tV.equals("Camioneta")){
                while(sc.hasNextLine()){
                    String linea = sc.nextLine();
                    String[] tokens = linea.split("\\|");
                    Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],
                            Integer.parseInt(tokens[7]),tokens[8],tokens[9],tokens[10],tokens[11],tokens[12],Integer.parseInt(tokens[13]));
                    vehiculos.add(v);
                }
            }
            if (tV.equals("Moto")){
                while(sc.hasNextLine()){
                    String linea = sc.nextLine();
                    String[] tokens = linea.split("\\|");
                    Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],
                            Integer.parseInt(tokens[7]),tokens[8],tokens[9],Integer.parseInt(tokens[10]));
                    vehiculos.add(v);
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
    
    //busca a un vehiculo por su identificador unico
    public static Vehiculo searchByID(ArrayList<Vehiculo> veh, int id)
    {
        for(Vehiculo v : veh)
        {
            if(v.id == id)
                return v;
        }
        return null;
    }
    
    //valida cuando se registra un vehiculo que la placa sea unica dentro de las que ya estan almacenados en la base de datos
    public static Vehiculo searchByPlaca(ArrayList<Vehiculo> veh, String placa){
        for(Vehiculo v : veh){
            if(v.placa.equals(placa))
                return v;
        }
        return null;
    }
    
}
