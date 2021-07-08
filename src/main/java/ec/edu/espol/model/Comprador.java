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
 * @author isaac
 */
public class Comprador extends Usuario{
       
     public Comprador(int id, String nombres, String apellidos, String correo, String clave, String organizacion){
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
     //permite el ingreo porr teclado para la posterior creacion de un objeto con plantilla de clase Comprador  
    public static void nextComprador(Scanner sc, String nomfile)
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
        String clave = sc.next();String clave_sha256 = Util.convertirSHA256(clave);
        int id = Util.nextID(nomfile);
        Comprador c = new Comprador(id,nombres,apellidos,correo,clave_sha256,organizacion);
        c.saveFile(nomfile);
    }
    
    //crea un nuevo objeto vendedor si o solo si el correo del nuevo ingreso no se encuentra registrado ya en la base de datos
    public static boolean nextVendedor(Scanner sc, String nomfile,ArrayList<Comprador> compradores) 
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
        if(searchByCorreo(compradores, correo)== null){
                Comprador c = new Comprador(id,nombres,apellidos,correo,clave_sha256,organizacion);
                //adgrego a la memoria primero
                compradores.add(c);
                //agrego luego al archivo de texto
                c.saveFile(nomfile);
                //retorno verdadero cuadno la operacion fue exitosa
                return true;
        }
        else
            //retorno falso cuando la operacion no se logro con exito
            return false;
    }
     //guarda en un archivo de tec=xto plano a una instancia de la clase vendedor       
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombres+"|"+this.apellidos+"|"+this.correo+"|"+this.clave+"|"+this.organizacion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //carga la base de datos de compradores desde archivos en texto plano al iniciar el programa principal o Main
    public static ArrayList<Comprador> readFile(String nomfile){
        ArrayList<Comprador> compradores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "1|Juan|Perez|jperez@example.com|1234567890|espol"
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Comprador c = new Comprador(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                compradores.add(c);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return compradores;
    }
    //busca a un comprador por su identificador unico
    public static Comprador searchByID(ArrayList<Comprador> compradores, int id)
    {
        for(Comprador c : compradores)
        {
            if(c.id == id)
                return c;
        }
        return null;
    }
    //valida cuando se registra un comprador que el correo sea unico dentro de los que ya estan almacenadosen la base de datos
    public static Comprador searchByCorreo(ArrayList<Comprador> compradores, String correo)
    {
        for(Comprador c : compradores)
        {
            if(c.correo.equals(correo))
                return c;
        }
        return null;
    }
    
    
}
