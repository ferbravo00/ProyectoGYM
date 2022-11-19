/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectgym;


import dominio.Gymbros;
import datos.*;
import dominio.Ejercicio;
import dominio.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class TestMysql {
    
    
    static Scanner ent = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {
        
        InterfazUsuario usuarioDao = new UsuarioDao();
        InterfazGymbros gymbrosDao = new GymbrosDao();
        InterfazEjercicio ejercicioDao = new EjercicioDao();
        
        Usuario u1 = new Usuario ("Fer", "fer@gmail.com", "1234", "centro del agua", 22, 176, 72, "foto");
        Usuario u2 = new Usuario ("Jon", "Jon@gmail.com", "contraseña", "elite", 22, 176, 72, "foto");
        Usuario u3 = new Usuario ("Nacho", "Nacho@gmail.com", "contraseña", "Karol", 22, 176, 72, "foto");
        Usuario u7 = new Usuario ("Ana", "Ana@gmail.com", "123", "centro del agua", 22, 176, 72, "foto");
        Usuario u4 = new Usuario (9);
        Gymbros g1 = new Gymbros (8,9);
        
        Ejercicio e1 = new Ejercicio ("Remo unilateral", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Espalda");
        Ejercicio e2 = new Ejercicio ("Remo en punta", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Espalda");
        Ejercicio e3 = new Ejercicio ("Press banca", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Pecho");
        Ejercicio e4 = new Ejercicio ("Dominadas", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Espalda");
        Ejercicio e5 = new Ejercicio ("Sentadillas", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Pierna");
        Ejercicio e = new Ejercicio ("Espalda");
            //System.out.println(u1);
            //usuarioDao.eliminar(7);
            //usuarioDao.actualizar(u1);
        //ejercicioDao.insertar(e1);
        //ejercicioDao.insertar(e2);
        //ejercicioDao.insertar(e3);
        //ejercicioDao.insertar(e4);
        //ejercicioDao.insertar(e5);
        //usuarioDao.insertar(u7);
        
        
        try {
            //System.out.println(usuarioDao.mostrarId(usuarioDao.mostrarNombre("Fer")));
            menu();
            
            /*
        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(u ->{
        System.out.println("Usuario: "+u);
        });
        List<Gymbros> gymbros = gymbrosDao.mostrar();
        gymbros.forEach(u ->{
        System.out.println("Gymbro: "+u);
        });
        //System.out.println(gymbrosDao.mostrarAmigos(u4));
        List<Gymbros> gymbro = gymbrosDao.mostrarAmigos(u4);
        gymbro.forEach(g ->{
        System.out.println("Gymbro: "+ g);
        });
        for (int i = 0; i < gymbro.size(); i++) {
        System.out.println(gymbro.get(i));
        }
        List<Ejercicio> ejercicio = ejercicioDao.mostrar();
        ejercicio.forEach(u ->{
        System.out.println("Ejercicio: "+u);
        });
        List<Ejercicio> ejercicios = ejercicioDao.mostrarCuerpo(e);
        ejercicios.forEach(u ->{
        System.out.println(u.getParteCuerpo()+": "+u.getNombre()+", "+u.getDescripcion()+", "+u.getFoto());
        });
*/
        } catch (SQLException ex) {
        Logger.getLogger(TestMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
             }
    
    public static void menu() throws SQLException{
        
        InterfazUsuario usuarioDao = new UsuarioDao();
        //Usuario u = new Usuario();
        int opcion=-1;
        while(opcion!=0){
            System.out.println("\n\n\t=============");
            System.out.println("\t=  APP GYM  =");
            System.out.println("\t=============\n");
            System.out.printf("\t(1) - Iniciar Sesión\n");
            System.out.printf("\t(2) - Registrarse\n");
            System.out.printf("\t(0) - SALIR\n");
            opcion = ent.nextInt();
            switch(opcion){
                case 1:
                    
                    System.out.println("Ingresa tu Nombre: ");
                    ent.nextLine();
                    String nombre = ent.nextLine();
                    System.out.println("Ingresa tu Clave: ");
                    String clave = ent.nextLine();
                    if (usuarioDao.comprobar(nombre, clave)==1) {
                        System.out.println("Hola "+nombre+", a darle duro :)");
                        int idUser = usuarioDao.mostrarNombre(nombre);
                        menuUsuario(idUser,nombre);
                    }else if(nombre.equalsIgnoreCase("toor") && clave.equalsIgnoreCase("1234")){
                        menuAdmin();
                    }else{
                        System.out.println("ERROR (Usuario y/o contraseña Incorrectos)");
                    }

                    break;
                case 2:
                    ent.nextLine();
                    System.out.println("Ingresa tu Nombre: ");
                    String name = ent.nextLine();
                    while(usuarioDao.comprobar(name)==1){
                        System.out.println(name+" ya esta en uso, pruebe otro");
                        System.out.println("Ingresa tu Nombre: ");
                        name = ent.nextLine();
                    }
                    
                    System.out.println("Ingresa tu Clave: ");
                    String pass = ent.nextLine();
                    System.out.println("Ingresa tu correo: ");
                    String correo = ent.nextLine();
                    System.out.println("Ingresa tu Gimnasio(Opcional): ");
                    String gym = ent.nextLine();
                    System.out.println("Ingresa tu Edad: ");
                    int edad = ent.nextInt();
                    System.out.println("Ingresa tu Altura(cm): ");
                    int altura = ent.nextInt();
                    System.out.println("Ingresa tu Peso: ");
                    int peso = ent.nextInt();
                    System.out.println("Ingresa una Foto(Opcional): ");
                    String foto = ent.nextLine();
                    Usuario u = new Usuario (name, correo, pass, gym, edad, altura, peso, foto);
                    usuarioDao.insertar(u);
                    System.out.println("BIENVENIDO/A "+name.toUpperCase()+" A ESTA GRAN FAMILIA :)");
                    break;
                case 0:
                    System.out.println("\n\nGracias por usar la aplicación :)\n");
                    break;
                default:
                    System.out.printf("\nElija entre 0 y 2\n\n");
                    break;
            }
            ent.nextLine();      
        }
    }
    
    public static void menuUsuario(int id, String nombre) throws SQLException{
        InterfazGymbros gymbrosDao = new GymbrosDao();
        InterfazUsuario usuarioDao = new UsuarioDao();
        int opcion=-1;
        while(opcion!=0){
            System.out.println("\n\n\t=============");
            System.out.println("\t=  USUARIO  =");
            System.out.println("\t=============\n");
            System.out.printf("\t(1) - Perfil\n");
            System.out.printf("\t(2) - Editar Perfil\n");
            System.out.printf("\t(2) - Mostrar Amigos\n");
            System.out.printf("\t(0) - VOLVER\n");
            opcion = ent.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(usuarioDao.mostrarId(id));

                    break;
                case 2:
                    ent.nextLine();
                    System.out.println("Ingresa tu Nombre: ");
                    String name = ent.nextLine();
                    while(usuarioDao.comprobar(name)==1 && name.compareToIgnoreCase(nombre)!=0){
                        System.out.println(name+" ya esta en uso, pruebe otro");
                        System.out.println("Ingresa tu Nombre: ");
                        name = ent.nextLine();
                    }
                    
                    System.out.println("Ingresa tu Clave: ");
                    String pass = ent.nextLine();
                    System.out.println("Ingresa tu correo: ");
                    String correo = ent.nextLine();
                    System.out.println("Ingresa tu Gimnasio(Opcional): ");
                    String gym = ent.nextLine();
                    System.out.println("Ingresa tu Edad: ");
                    int edad = ent.nextInt();
                    System.out.println("Ingresa tu Altura(cm): ");
                    int altura = ent.nextInt();
                    System.out.println("Ingresa tu Peso: ");
                    int peso = ent.nextInt();
                    System.out.println("Ingresa una Foto(Opcional): ");
                    String foto = ent.nextLine();
                    Usuario u = new Usuario (id, name, correo, pass, gym, edad, altura, peso, foto);
                    usuarioDao.actualizar(u);
                    System.out.println("Datos actualizados correctamente :)");
                    break;
                case 3:
                    gymbrosDao.mostrarAmigos(id);
                    break;
                case 0:
                    System.out.println("\n\nGracias por usar la aplicación :)\n");
                    break;
                default:
                    System.out.printf("\nElija entre 0 y 2\n\n");
                    break;
            }
            ent.nextLine();      
        }
    }
    
    public static void menuAdmin() throws SQLException{
        
        InterfazUsuario usuarioDao = new UsuarioDao();
        Usuario u = new Usuario();
        int opcion=-1;
        while(opcion!=0){
            System.out.println("\n\n\t===================");
            System.out.println("\t=  ADMINISTRADOR  =");
            System.out.println("\t===================\n");
            System.out.printf("\t(1) - Usuarios\n");
            System.out.printf("\t(2) - Ejercicios\n");
            System.out.printf("\t(0) - VOLVER\n");
            opcion = ent.nextInt();
            switch(opcion){
                case 1:
                    menuAdminUsu();
                    break;
                case 2:
                    menuAdminEjer();
                    break;
                case 0:
                    System.out.println("\n\nGracias por usar la aplicación :)\n");
                    break;
                default:
                    System.out.printf("\nElija entre 0 y 2\n\n");
                    break;
            }
            ent.nextLine();      
        }
    }
    
    public static void menuAdminUsu() throws SQLException{      //Este menu se abre cuando el admin inicia sesion y elije la opcion usuarios
        
        InterfazUsuario usuarioDao = new UsuarioDao();
        //Usuario u = new Usuario();
        int opcion=-1;
        while(opcion!=0){
            System.out.println("\n\n\t===================");
            System.out.println("\t=  ADMINISTRADOR  =");
            System.out.println("\t===================\n");
            System.out.printf("\t(1) - Buscar por id de Usuario\n");
            System.out.printf("\t(2) - Mostrar todos los Usuarios\n");
            System.out.printf("\t(3) - Eliminar Usuarios\n");
            System.out.printf("\t(0) - VOLVER\n");
            opcion = ent.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Introduzca el ID del Usuario:");
                    System.out.println(usuarioDao.mostrarId(ent.nextInt()));
                    break;
                case 2:
                    List<Usuario> usuarios = usuarioDao.seleccionar();
                    usuarios.forEach(usu ->{
                    System.out.println("Usuario: "+usu);
                    });
                    break;
                case 3:
                    System.out.println("Introduzca el ID del Usuario que desea eliminar:");
                    //int ert =ent.nextInt();
                    usuarioDao.eliminar(ent.nextInt());
                    System.out.println("Usuario eliminado correctamente :) ");
                    
                    break;    
                case 0:
                    
                    break;
                default:
                    System.out.printf("\nElija entre 0 y 2\n\n");
                    break;
            }
            ent.nextLine();      
        }
    }
    
    public static void menuAdminEjer() throws SQLException{         //Este menu se abre cuando el admin inicia sesion y elije la opcion ejercicios
        
        InterfazEjercicio ejercicioDao = new EjercicioDao();
        int opcion=-1;
        while(opcion!=0){
            System.out.println("\n\n\t===================");
            System.out.println("\t=  ADMINISTRADOR  =");
            System.out.println("\t===================\n");
            System.out.printf("\t(1) - Insertar nuevo Ejercicio\n");
            System.out.printf("\t(2) - Modificar un Ejercicio\n");
            System.out.printf("\t(3) - Eliminar un Ejercicio\n");
            System.out.printf("\t(0) - VOLVER\n");
            opcion = ent.nextInt();
            switch(opcion){
                case 1:
                    ent.nextLine();
                    System.out.println("Ingrese el Nombre: ");
                    String Nombre = ent.nextLine();
                    System.out.println("Ingrese una Descripcion: ");
                    String Descripcion = ent.nextLine();
                    System.out.println("Ingrese una Foto(Opcional): ");
                    String Foto = ent.nextLine();
                    System.out.println("A que grupo muscular pertenece?(Espalda, Pecho, Pierna, etc): ");
                    String muscular = ent.nextLine();
                    Ejercicio e = new Ejercicio(Nombre, Foto, Descripcion, muscular);
                    ejercicioDao.insertar(e);
                    System.out.println("Ejercicio añadido correctamente :)");
                    break;
                case 2:
                    List<Ejercicio> ejercicio = ejercicioDao.mostrar();
                    ejercicio.forEach(u ->{
                    System.out.println("Ejercicio: "+u);
                    });
                    System.out.println("Ingrese el ID del ejercicio a modificar:");
                    int id= ent.nextInt();
                    ent.nextLine();
                    System.out.println("Ingrese el Nombre: ");
                    String Nom = ent.nextLine();
                    System.out.println("Ingrese una Descripcion: ");
                    String Des = ent.nextLine();
                    System.out.println("Ingrese una Foto(Opcional): ");
                    String Fot = ent.nextLine();
                    System.out.println("A que grupo muscular pertenece?(Espalda, Pecho, Pierna, etc): ");
                    String muscu = ent.nextLine();
                    Ejercicio e1 = new Ejercicio(id,Nom, Fot, Des, muscu);
                    ejercicioDao.actualizar(e1);
                    System.out.println("Ejercicio modificado correctamente :)");
                    break;
                case 3:
                    ejercicio = ejercicioDao.mostrar();
                    ejercicio.forEach(u ->{
                    System.out.println("Ejercicio: "+u);
                    });
                    System.out.println("Ingrese el ID del ejercicio que desea eliminar:");
                    ejercicioDao.eliminar(ent.nextInt());
                    break;
                case 0:
                    break;
                default:
                    System.out.printf("\nElija entre 0 y 2\n\n");
                    break;
            }
            ent.nextLine();      
        }
    }
    
}
