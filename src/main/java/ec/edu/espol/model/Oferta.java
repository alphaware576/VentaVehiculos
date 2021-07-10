/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alpha
 */
public class Oferta {
    private int id;
    private int idVehiculo;
    private int idVendedor;
    private Vehiculo vehiculo;
    private Vendedor vendedor;
    private ArrayList<Comprador> compradores;
    
    public Oferta(int id, Vehiculo vehiculo, Vendedor vendedor) {
        this.id = id;
        this.idVehiculo = vehiculo.getId();
        this.idVendedor = vendedor.getId();
        this.vendedor=vendedor;
        this.vehiculo=vehiculo;
        
    }
    public Oferta(int id, Vehiculo vehiculo, Vendedor vendedor,Comprador c) {
        this.id = id;
        this.idVehiculo = vehiculo.getId();
        this.idVendedor = vendedor.getId();
        this.vendedor=vendedor;
        this.vehiculo=vehiculo;
        this.compradores= new ArrayList<>();
        this.compradores.add(c);
    }
    
    public int getIdOferta() {
        return id;
    }

    public void setIdOferta(int idOferta) {
        this.id = idOferta;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
       
    //carga la base de datos de ofertas desde archivos en texto plano al iniciar el programa principal o Main
    public static ArrayList<Oferta> readFile(String nomfile,ArrayList<Vendedor>vendedores, ArrayList<Vehiculo> vehiculos,ArrayList<Comprador> compradores){
        ArrayList<Oferta> ofertas = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "id|idVehiculo|idVendedor|idComprador" identificador 0 para cuando no hay compradores para esa oferta
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Oferta o;
                Vehiculo vh=Vehiculo.searchByID(vehiculos, Integer.parseInt(tokens[1]));
                Vendedor v=Vendedor.searchByID(vendedores, Integer.parseInt(tokens[2]));
                Comprador c=Comprador.searchByID(compradores, Integer.parseInt(tokens[3]));
                if(c==null){ o= new Oferta(Integer.parseInt(tokens[0]),vh,v);}
                else {o = new Oferta(Integer.parseInt(tokens[0]),vh,v,c);}
                ofertas.add(o);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ofertas;
    }
    //busca a un vendedor por su identificador unico
    public static Oferta searchByID(ArrayList<Oferta> ofertas, int id)
    {
        for(Oferta o : ofertas)
        {
            if(o.id == id)
                return o;
        }
        return null;
    }
   
    
}
