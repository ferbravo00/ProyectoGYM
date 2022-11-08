/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectgym;

import datos.UsuarioDao;
import dominio.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class TestMysql {
    
    public static void main(String[] args) {
        
        UsuarioDao usuarioDao = new UsuarioDao();
        
        Usuario u1 = new Usuario ("Fer", "fer@gmail.com", "contraseña", "centro del agua", 22, 176, 72, "foto");
        
        System.out.println(u1);
        
        usuarioDao.insertar(u1);
        
       
        
        try {
            
            usuarioDao.seleccionar();
        } catch (SQLException ex) {
            Logger.getLogger(TestMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
