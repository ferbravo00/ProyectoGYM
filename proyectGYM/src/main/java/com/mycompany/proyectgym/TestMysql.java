/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectgym;

import datos.UsuarioDao;
import dominio.Gymbros;
import datos.GymbrosDao;
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
        
        UsuarioDao usuarioDao = new UsuarioDao();
        GymbrosDao gymbrosDao = new GymbrosDao();
        
        Usuario u1 = new Usuario ("Fer", "fer@gmail.com", "contraseña", "centro del agua", 22, 176, 72, "foto");
        Usuario u2 = new Usuario ("Jon", "Jon@gmail.com", "contraseña", "elite", 22, 176, 72, "foto");
        Usuario u3 = new Usuario ("Nacho", "Nacho@gmail.com", "contraseña", "Karol", 22, 176, 72, "foto");
        Usuario u4 = new Usuario (7);
        Gymbros g1 = new Gymbros (8,9);
        
       
        
            //System.out.println(u1);
            //usuarioDao.eliminar(u1);
            //usuarioDao.actualizar(u4);
            //usuarioDao.insertar(u2);
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
            /*
            for (int i = 0; i < gymbro.size(); i++) {
                System.out.println(gymbro.get(i));
            }*/
            
        } catch (SQLException ex) {
            Logger.getLogger(TestMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
