/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectgym;

import datos.EjercicioDao;
import datos.UsuarioDao;
import dominio.Gymbros;
import datos.GymbrosDao;
import datos.InterfazUsuario;
import dominio.Ejercicio;
import dominio.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class TestMysql {
    
    public static void main(String[] args) {
        
        InterfazUsuario usuarioDao = new UsuarioDao();
        GymbrosDao gymbrosDao = new GymbrosDao();
        EjercicioDao ejercicioDao = new EjercicioDao();
        
        Usuario u1 = new Usuario ("Fer", "fer@gmail.com", "contraseña", "centro del agua", 22, 176, 72, "foto");
        Usuario u2 = new Usuario ("Jon", "Jon@gmail.com", "contraseña", "elite", 22, 176, 72, "foto");
        Usuario u3 = new Usuario ("Nacho", "Nacho@gmail.com", "contraseña", "Karol", 22, 176, 72, "foto");
        Usuario u4 = new Usuario (7);
        Gymbros g1 = new Gymbros (8,9);
        
        Ejercicio e1 = new Ejercicio ("Remo unilateral", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Espalda");
        Ejercicio e2 = new Ejercicio ("Remo en punta", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Espalda");
        Ejercicio e3 = new Ejercicio ("Press banca", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Pecho");
        Ejercicio e4 = new Ejercicio ("Dominadas", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Espalda");
        Ejercicio e5 = new Ejercicio ("Sentadillas", "Foto", "Este es un ejercicio para trabajar la unilateralidad", "Pierna");
        Ejercicio e = new Ejercicio ("Espalda");
            //System.out.println(u1);
            //usuarioDao.eliminar(u1);
            //usuarioDao.actualizar(u4);
            //ejercicioDao.insertar(e5);
            //usuarioDao.insertar(u3);
            
  
        
        try {
            
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
            /*
            
            
            List<Ejercicio> ejercicios = ejercicioDao.mostrarCuerpo(e);
            ejercicios.forEach(u ->{
                System.out.println(u.getParteCuerpo()+": "+u.getNombre()+", "+u.getDescripcion()+", "+u.getFoto());
            });
            */
        } catch (SQLException ex) {
            Logger.getLogger(TestMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
