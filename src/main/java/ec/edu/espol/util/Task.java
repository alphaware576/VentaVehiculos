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
    public static int RegistrarVehiculo(Scanner sc,ArrayList<Vehiculo> vehiculos,int opcion){
        System.out.println("Registrando un nuevo vehiculo");
        switch(opcion){
            case 1:
                    if(Vehiculo.nextVehiculoCarro(sc,"vehiculos.txt", vehiculos))
                    System.out.println("Vehiculo tipo carro registrado con exito");
                    else
                    System.out.println("Vehiculo ya registrado,use otra placa");
                 break;
            case 2:
                if(Vehiculo.nextVehiculoCamioneta(sc,"vehiculos.txt", vehiculos))
                    System.out.println("Vehiculo tipo camioneta registrado con exito");
                    else
                    System.out.println("Vehiculo ya registrado,use otra placa");
                break;
            case 3:
                 if(Vehiculo.nextVehiculoMotocicleta(sc,"vehiculos.txt", vehiculos))
                    System.out.println("Vehiculo tipo mmotocicleta registrado con exito");
                    else
                    System.out.println("Vehiculo ya registrado,use otra placa");
                 break;
            default:
                System.out.println("No existe ese tipo de vehiculo selecionado");
                break;
        }
        
        System.out.println("3. Regresar");
        int opt=sc.nextInt();
        return opt;
        
    }
    public static boolean AceptarOferta(Scanner sc,ArrayList<Oferta> ofertas, ArrayList<Vendedor> vendedores){
        System.out.println("Registrando una nueva oferta");
        System.out.println("Ingrese su correo:");
        sc.useDelimiter("\n");
        String correo = sc.next();
        System.out.println("Ingrese su clave");
        sc.useDelimiter("\n");
        String clave = sc.next();
        Vendedor v=Vendedor.searchByCorreo(vendedores, correo);
        if(v==null){
            System.out.println("Usuario no existe en la plataforma");
            return false;
        }
        if(v.getClave().equals(Util.convertirSHA256(clave))){
            //Hacer comportamiento listar ofertas
            System.out.println("Listando ofertas");
            return true;
        }
        else{
            System.out.println("Usuario no existe en la plataforma");
            return false;
        }
        //System.out.println("3. Regresar");
  
        
    }

    
    
    
}
