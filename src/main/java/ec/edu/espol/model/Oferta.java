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
    private int idComprador;
    private Vehiculo vehiculo;
    private Vendedor vendedor;
    private Comprador comprador;
    private int preciOfertado;

    
    public Oferta(int id, Vehiculo vehiculo, Vendedor vendedor) {
        this.id = id;
        this.idVehiculo = vehiculo.getId();
        this.idVendedor = vendedor.getId();
        this.vendedor=vendedor;
        this.vehiculo=vehiculo;
        
    }
    public Oferta(int id, Vehiculo vehiculo,Comprador comprador,int preciofertado) {
        this.id = id;
        this.idVehiculo = vehiculo.getId();
        this.idVendedor = vehiculo.getIdVendedor();
        this.idComprador=comprador.getId();
        this.vendedor=vehiculo.getVendedor();
        this.vehiculo=vehiculo;
        this.comprador=comprador;
        this.preciOfertado=preciofertado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public int getPreciOfertado() {
        return preciOfertado;
    }

    public void setPreciOfertado(int preciOfertado) {
        this.preciOfertado = preciOfertado;
    }
       
    //carga la base de datos de ofertas desde archivos en texto plano al iniciar el programa principal o Main
    public static ArrayList<Oferta> readFile(String nomfile,ArrayList<Vendedor>vendedores, ArrayList<Vehiculo> vehiculos,ArrayList<Comprador> compradores){
        ArrayList<Oferta> ofertas = new ArrayList();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "id|idVehiculo|idVendedor|idComprador|precioOferta" identificador 0 para cuando no hay compradores para esa oferta
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Oferta o;
                Vehiculo vh=Vehiculo.searchByID(vehiculos, Integer.parseInt(tokens[1]));
                Vendedor v=Vendedor.searchByID(vendedores, Integer.parseInt(tokens[2]));
                Comprador c=Comprador.searchByID(compradores, Integer.parseInt(tokens[3]));
                o=new Oferta(Integer.parseInt(tokens[0]),vh,c,Integer.parseInt(tokens[4]));
                o.vendedor=v;
                c.addOferta(o);
                vh.addOferta(o);
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
    public static ArrayList<Oferta> searchByIDVendedor(ArrayList<Oferta> ofertas,int id){
        ArrayList<Oferta> ofertasFiltered=new ArrayList<>();
        for(Oferta o : ofertas){
            if(o.getVendedor().getId()==id)
            ofertasFiltered.add(o);    
        }
        return ofertasFiltered;
    }
@Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("\nCorreo: ");
        sb.append(this.comprador.correo);
        sb.append("\nPrecio ofertado: ");
        sb.append(this.preciOfertado);
        sb.append("\n");
        return sb.toString();        
    }
   
    
}
