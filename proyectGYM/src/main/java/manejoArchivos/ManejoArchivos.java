/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Fer
 */
public class ManejoArchivos {
    
    public static void escribir(String nombre, String contenido){
        String direccion = "src/main/java/ManejoArchivos/"+nombre;
        PrintWriter salida = null;
        File archivo = new File(direccion);
        
         try{
            salida = new PrintWriter(archivo);
            salida.print(contenido);
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
            
        }finally{
             salida.close(); //siempre se ejecuta
         }
    }
}
