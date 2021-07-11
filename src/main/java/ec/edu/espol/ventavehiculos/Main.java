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
                //VENDEDOR:
                case 1:
                    int opt=Task.MenuVendedor(sc);
                    //VENDEDOR:1-Registrar vendedor////////////////////////////////////////////////////
                    if(opt==1){
                        if(Vendedor.nextVendedor(sc,"vendedores.txt", vendedores))
                            System.out.println("Vendedor registrado con exito");
                        else
                            System.out.println("No se ha registrado vendedor");
                    }
                    //VENDEDOR:2-Ingresar un nuevo vehiculo///////////////////////////////////////////////
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
                    //VENDEDOR:3-aceptar una nueva oferta(INCOMPLETO)
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
                                   //for (Oferta o : of) {
                                   //    System.out.println(o.toString());
                                   //}
                                   int select=0,count=0;
                                   do{
                                           Oferta o=of.get(count);
                                           System.out.println(o.toString());
                                           //valido para cuando la lista de ofertas solo tiene una sola oferta el menu debe presentar solo aceptar oferta
                                           if(of.size()==1){
                                               System.out.println("1.-Siguiente oferta");
                                               System.out.println("3.- Aceptar oferta");
                                               select=temp.nextInt();
                                               if(select==3){
                                                   //elimino de las bases de datos generales
                                                   Vehiculo vh=Vehiculo.searchByID(vehiculos, o.getVehiculo().getId());
                                                   Oferta ofer=Oferta.searchByID(ofertas,o.getId());
                                                   ofertas.remove(ofer);
                                                   vehiculos.remove(vh);
                                                   //elimino la instacia de vehiculo en vendedor
                                                   vh.getVendedor().getVehiculos().remove(vh);
                                                   //elimino la instanncia de oferta en vehiculo
                                                   vh.getOfertas().remove(ofer);
                                                   //elimino la instancia de oferta en comprador
                                                   ofer.getComprador().getOfertas().remove(ofer);
                                                   System.out.println("vehiculos actualmente en el sistema "+vehiculos.size());
                                               }
                                               
                                           }
                                           
                                          
                                           
                                   }while(select!=3);
                               }

                           }    
                       }//fin de: login, si el usuario es null
                    }
                    break;
                //COMPRADOR:
                case 2:
                    int o = Task.MenuComprador(sc);
                    //COMPRADOR:1-Registrar un nuevo comprador////////////////////////////////////////////////////
                    if(o==1){
                        if(Comprador.nextComprador(sc,"compradores.txt", compradores))
                            System.out.println("Comprador registrado con exito");
                        else
                            System.out.println("No se ha registrado Comprador");
                    }
                    if(o==2){
                        //Ofertar por un vehiculo
                        //primero logueo al usuario y lo traigo desde la base de datos
                       Usuario user=login(vendedores, compradores);
                       if(user!=null){
                           Scanner temp=new Scanner(System.in);
                           temp.useDelimiter("\n");
                           Comprador c=(Comprador)user;
                           //validar que sea del tipo comprador y no vendedor
                           //filtros de busqueda
                           //seleccion de vehiculo para ofertar
                       }
                    }
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
