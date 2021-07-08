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
 * @author Johnny D.Parrales
 */
public class Vendedor extends Usuario {
    private int idOferta;
    
    
    public Vendedor(int id, String nombres, String apellidos, String correo, String clave, String organizacion){
        super(id, nombres,apellidos,correo,clave,organizacion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
//permite el ingreo porr teclado para la posterior creacion de un objeto con plantilla de clase Vendedor   
    public static void nextVendedor(Scanner sc, String nomfile)
    {
        sc.useDelimiter("\n");
        System.out.println("Ingrese nombres>");
        String nombres = sc.next();
        System.out.println("Ingrese apellidos>");
        String apellidos = sc.next();
        System.out.println("Ingrese organizacion>");
        String organizacion = sc.next();
        System.out.println("Ingrese correo electronico>");
        String correo = sc.next();
        System.out.println("Ingrese clave>");
        String clave = sc.next();
        String clave_sha256 = Util.convertirSHA256(clave);
        int id = Util.nextID(nomfile);
        Vendedor v = new Vendedor(id,nombres,apellidos,correo,clave_sha256,organizacion);
        v.saveFile(nomfile);
    }
    //crea un nuevo objeto vendedor si o solo si el correo del nuevo ingreso no se encuentra registrado ya en la base de datos
    public static boolean nextVendedor(Scanner sc, String nomfile,ArrayList<Vendedor> vendedores) 
    {
        sc.useDelimiter("\n");
        System.out.println("Ingrese nombres>");
        String nombres = sc.next();
        System.out.println("Ingrese apellidos>");
        String apellidos = sc.next();
        System.out.println("Ingrese organizacion>");
        String organizacion = sc.next();
        System.out.println("Ingrese correo electronico>");
        String correo = sc.next();
        System.out.println("Ingrese clave>");
        String clave = sc.next();
        String clave_sha256 = Util.convertirSHA256(clave);
        System.out.println("Clave convertida>"+ clave_sha256);
        int id = Util.nextID(nomfile);
        if(searchByCorreo(vendedores, correo)== null){
                Vendedor v = new Vendedor(id,nombres,apellidos,correo,clave_sha256,organizacion);
                //adgrego a la memoria primero
                vendedores.add(v);
                //agrego luego al archivo de texto
                v.saveFile(nomfile);
                //retorno verdadero cuadno la operacion fue exitosa
                return true;
        }
        else
            //retorno falso cuando la operacion no se logro con exito
            return false;
    }
    
     //guarda en un archivo de tec=xto plano a una instancia de la clase vendedor       
    public void saveFile(String nomfile){
        //fileoutpustream permite abrir el archivo en pmodo append
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombres+"|"+this.apellidos+"|"+this.correo+"|"+this.clave+"|"+this.organizacion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //carga la base de datos de vendedores desde archivos en texto plano al iniciar el programa principal o Main
    public static ArrayList<Vendedor> readFile(String nomfile){
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "1|Juan|Perez|jperez@example.com|1234567890|espol"
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vendedor v = new Vendedor(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                vendedores.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vendedores;
    }
    //busca a un vendedor por su identificador unico
    public static Vendedor searchByID(ArrayList<Vendedor> vendedores, int id)
    {
        for(Vendedor v : vendedores)
        {
            if(v.id == id)
                return v;
        }
        return null;
    }
    //valida cuando se registra un vendedor que el correo sea unico dentro de los que ya estan almacenadosen la base de datos
    public static Vendedor searchByCorreo(ArrayList<Vendedor> vendedores, String correo)
    {
        for(Vendedor v : vendedores)
        {
            if(v.correo.equals(correo))
                return v;
        }
        return null;
    }
    
    
}
