/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ventavehiculos;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.util.Task;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.util.Util;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author alpha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Vendedor> vendedores = Vendedor.readFile("vendedores.txt");
        ArrayList<Comprador> compradores = Comprador.readFile("compradores.txt");
        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile("vehiculos.txt", vendedores);
        ArrayList<Oferta> ofertas = Oferta.readFile("ofertas.txt", vendedores, vehiculos, compradores);
        Scanner sc = new Scanner(System.in);
        int first_opt = 0;
        do {
            first_opt = Task.MenuOpciones(sc);
            switch(first_opt){
                case 1:
                    int opt=Task.MenuVendedor(sc);
                    //registrar vendedor
                    if(opt==1){
                        if(Vendedor.nextVendedor(sc,"vendedores.txt", vendedores))
                            System.out.println("Vendedor registrado con exito");
                        else
                            System.out.println("No se ha registrado vendedor");
                    }
                    //Ingresar un nuevo vehiculo
                    if(opt==2){
                    //primero logueo al usuario y lo traigo desde la base de datos
                       Usuario user=login(vendedores, compradores);
                       if(user!=null){
                           Vendedor v=(Vendedor)user;
                           System.out.println("Ingreso el tipo de Vehiculo a registrar");
                            System.out.println("1. Carro");
                            System.out.println("2.Camioneta");
                            System.out.println("3.Motocicleta");
                            int op=sc.nextInt();
                           //validar que sea del tipo vendedor y no comprador
                           Vehiculo.RegistrarVehiculo( vehiculos, v, op);
                       } 
                    }
                    //aceptar una nueva oferta
                    if(opt==3){
                    //primero logueo al usuario y lo traigo desde la base de datos
                       Usuario user=login(vendedores, compradores);
                       if(user!=null){
                           Scanner temp=new Scanner(System.in);
                           temp.useDelimiter("\n");
                           Vendedor v=(Vendedor)user;
                           //validar que sea del tipo vendedor y no comprador
                           System.out.print("Ingrese la placa del vehiculo para revisar las ofertas: ");
                           String placa=temp.next();
                           //busco la placa en al array ded vehiculos que ha publicado el vendedor
                           Vehiculo _selected=Vehiculo.searchByPlaca(v.getVehiculos(), placa);
                           //valido que no este vacio el vehiculo
                           if(_selected==null) System.out.println("No existe vehiculo con esa placa asociado con este vendedor");
                           else {
                               System.out.println(_selected.toString());
                               //obtengo las ofertas del vehiculo en cuestion e imprimo
                               ArrayList<Oferta> of = _selected.getOfertas();//imprimir lista de ofertas
                               if (of.isEmpty()) {
                                   System.out.println("No existen ofertas para el vehiculo con placa " + _selected.getPlaca());
                               } else {
                                   System.out.println("Se han realizado " + of.size() + " ofertas");
                                   for (Oferta o : of) {
                                       System.out.println(o.toString());
                                   }
                               }

                           }    
                       }
                    }
                    break;
                case 2:
                    Task.MenuComprador(sc);
                    break;     
            }
            
        } while (first_opt != 3);
    }
 public static Usuario login(ArrayList<Vendedor> vendedores,ArrayList<Comprador>compradores){
     Scanner sc=new Scanner(System.in);
     sc.useDelimiter("\n");
     System.out.println("Ingrese su correo:");
     String correo=sc.next();
     System.out.println("Ingrese su clave: ");
     String clave=sc.next();
     Usuario user=Vendedor.searchByCorreo(vendedores, correo);
     if(user==null)
     {user=Comprador.searchByCorreo(compradores,correo);}
     //sc.close();
        if(user==null){
            System.out.println("Usuario no existe en la plataforma");
            return null;
        }
        if(user.getClave().equals(Util.convertirSHA256(clave))){
            System.out.println("Ingreso correcto");
            return user;
        }
        else{
            System.out.println("Correo o clave son incorrectos");
            return null;
        } 
     
 }   
    
}
