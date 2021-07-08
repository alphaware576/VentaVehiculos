/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ventavehiculos;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.util.Task;
import java.security.NoSuchAlgorithmException;
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
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        ArrayList<Vendedor> vendedores= Task.consolidarVendedoresDB();
        ArrayList<Comprador> compradores=Task.consolidarComparadoresDB();
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
                                    
                                case 3:
                                
                            }
                        case 2:
                            Task.MenuComprador(sc);
                        default: 
                            break;
                    }
            }while(first_opt!=3);
       
        
    }
    
}
