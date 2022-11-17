/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Usuario;
import java.sql.Connection;
import static datos.Conexion.getConnection;
import static datos.Conexion.close;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class UsuarioDao implements InterfazUsuario{
    private static final String SQL_SELECT = "SELECT * FROM Usuario";
    private static final String SQL_INSERT = "INSERT INTO Usuario (Nombre, Correo, Clave, Gimnasio, Edad, Altura, Peso, Foto, FechaAlta) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Usuario SET Nombre=?, Correo=?, Clave=?, Gimnasio=?, Edad=?, Altura=?, Peso=?, Foto=? WHERE idUsuario=?";
    private static final String SQL_DELETE = "DELETE FROM Usuario WHERE idUsuario=?";
    
    
    public List<Usuario> usuarios = new ArrayList<>();
    
    public int insertar(Usuario usuarios){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setString(1, usuarios.getNombre());
                stmt.setString(2, usuarios.getCorreo());
                stmt.setString(3, usuarios.getClave());
                stmt.setString(4, usuarios.getGimnasio());
                stmt.setInt(5, usuarios.getEdad());
                stmt.setInt(6, usuarios.getAltura());
                stmt.setInt(7, usuarios.getPeso());
                stmt.setString(8, usuarios.getFoto());
                stmt.setDate(9, usuarios.getFechaAlta());
                //stmt.setDate(9, (Date) Date.from(usuarios.getFechaAlta().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                
                registros = stmt.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }finally{
                try {
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }
    
        
    public int actualizar(Usuario usuarios){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt =conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, usuarios.getNombre());
            stmt.setString(2, usuarios.getCorreo());
            stmt.setString(3, usuarios.getClave());
            stmt.setString(4, usuarios.getGimnasio());
            stmt.setInt(5, usuarios.getEdad());
            stmt.setInt(6, usuarios.getAltura());
            stmt.setInt(7, usuarios.getPeso());
            stmt.setString(8, usuarios.getFoto());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }


    public int eliminar(Usuario usuarios){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt =conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, usuarios.getIdUsuario());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    
    public List<Usuario> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        conn = getConnection();
        stmt =conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int idUsuario = rs.getInt("idUsuario");
            String Nombre = rs.getString("Nombre");
            String Correo = rs.getString("Correo");
            String Clave = rs.getString("Clave");
            String Gimnasio = rs.getString("Gimnasio");
            int Edad = rs.getInt("Edad");
            int Altura = rs.getInt("Altura");
            int Peso = rs.getInt("Peso");
            String Foto = rs.getString("Foto");
            Date FechaAlta = rs.getDate("FechaAlta");
            
            
           
            
            usuarios.add(new Usuario (idUsuario, Nombre, Correo, Clave, Gimnasio, Edad, Altura, Peso, Foto, FechaAlta));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        return usuarios;
    }

  
    
    
}
