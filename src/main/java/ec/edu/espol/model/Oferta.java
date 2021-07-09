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

    public Oferta(int id, int idVehiculo, int idVendedor) {
        this.id = id;
        this.idVehiculo = idVehiculo;
        this.idVendedor = idVendedor;
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
       
    //carga la base de datos de vendedores desde archivos en texto plano al iniciar el programa principal o Main
    public static ArrayList<Oferta> readFile(String nomfile){
        ArrayList<Oferta> ofertas = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "1|Juan|Perez|jperez@example.com|1234567890|espol"
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Oferta o = new Oferta(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
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
