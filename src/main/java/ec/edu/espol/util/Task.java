/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Oferta;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author alpha
 */
public class Task {
    //nadie puede crear una instancia de tarea
    private Task(){
        
    }
    public static ArrayList<Vendedor> consolidarVendedoresDB(){
        //cargo a los objetos vendedores desde sus  base de datos en archivos de texto
        return Vendedor.readFile("vendedores.txt");    
    }
    public static ArrayList<Comprador> consolidarComparadoresDB(){
        //cargo a los objetos vendedores desde sus  base de datos en archivos de texto
        return Comprador.readFile("compradores.txt");    
    }
    public static ArrayList<Vehiculo> consolidarVehiculosDB(){
        //cargo a los objetos vendedores desde sus  base de datos en archivos de texto
        return Vehiculo.readFile("vehiculos.txt");    
    }
    public static ArrayList<Oferta> consolidarOfertasDB(){
        //cargo a los objetos vendedores desde sus  base de datos en archivos de texto
        return Vehiculo.readFile("ofertas.txt");    
    }
    public static int MenuOpciones(Scanner sc){
        System.out.println("Menu de opciones:\n");
        System.out.println("1. Vendedor");
        System.out.println("2. Comprador");
        System.out.println("3. Salir");
        int opt=sc.nextInt();
        return opt;
    }
    public static int MenuVendedor(Scanner sc){
        System.out.println("Opciones del Vendedor:\n");
        System.out.println("1. Registrar un nuevo vendedor");
        System.out.println("2. Ingresar un nuevo Vehiculo");
        System.out.println("3. Aceptar oferta");
        System.out.println("4. Regresar");
        int opt=sc.nextInt();
        return opt;
    }
    public static int MenuComprador(Scanner sc){
        System.out.println("Opciones del Comprador:\n");
        System.out.println("1. Registrar un nuevo comprador");
        System.out.println("2. Ofertar por un Vehiculo");
        System.out.println("3. Regresar");
        int opt=sc.nextInt();
        return opt;
    }
    public static int RegistrarComprador(Scanner sc){
        System.out.println("Registrando nuevo comprador");
        System.out.println("3. Regresar");
        int opt=sc.nextInt();
        return opt;
    }
    public static int RegistrarVendedor(Scanner sc, ArrayList<Vendedor> vendedores) {
        System.out.println("Registrando nuevo vendedor");
        if(Vendedor.nextVendedor(sc,"vendedores.txt",vendedores))
            System.out.println("Vendedor registrado con exito");
        else
            System.out.println("Vendedor ya registrado,use otro correo");
        System.out.println("3. Regresar");
        int opt=sc.nextInt();
        return opt;
    }
    public static int RegistrarVehiculo(Scanner sc,ArrayList<Vehiculo> vehiculos){
        System.out.println("Registrando un nuevo vehiculo");
        if(Vehiculo.nextVehiculo(sc,"vehiculos.txt", vehiculos))
            System.out.println("Vehiculo registrado con exito");
        else
            System.out.println("Vehiculo ya registrado,use otra placa");
        System.out.println("3. Regresar");
        int opt=sc.nextInt();
        return opt;
        
    }
    public static int AceptarOferta(Scanner sc,ArrayList<Oferta> ofertas){
        System.out.println("Registrando una nueva oferta");
        System.out.println("3. Regresar");
        int opt=sc.nextInt();
        return opt;
        
    }
    
    
}
