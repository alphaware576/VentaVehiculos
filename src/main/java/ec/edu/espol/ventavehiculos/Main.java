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
        ArrayList<Vendedor> vendedores= Vendedor.readFile("vendedores.txt");
        ArrayList<Comprador> compradores=Comprador.readFile("compradores.txt");
        ArrayList<Vehiculo> vehiculos=Vehiculo.readFile("vehiculos.txt");
        ArrayList<Oferta> ofertas=Oferta.readFile("ofertas.txt",vendedores,vehiculos,compradores);
        Scanner sc=new Scanner(System.in);
        int first_opt;
        do{
            first_opt=Task.MenuOpciones(sc);
                 switch(first_opt){
                        case 1:
                            int second_opt=Task.MenuVendedor(sc);
                            switch(second_opt){
                                case 1:
                                    Task.RegistrarVendedor(sc,vendedores);
                                case 2:
                                    System.out.println("Seleccione el tipo de Vehiculo a registrar:");
                                    System.out.println("1: Carro");
                                    System.out.println("2: Camioneta");
                                    System.out.println("3: Motocicleta");
                                    int opcion=sc.nextInt();
                                    Task.RegistrarVehiculo(sc, vehiculos,opcion);
                                    break;
                                case 3:
                                    if(Task.AceptarOferta(sc,ofertas,vendedores)){
                                        //listo todas las ofertas
                                    }
                                case 4:
                                    break;
                            }
                        case 2:
                            Task.MenuComprador(sc);
                        default: 
                            break;
                    }
            }while(first_opt!=3);
       
        
    }
    
    
}
