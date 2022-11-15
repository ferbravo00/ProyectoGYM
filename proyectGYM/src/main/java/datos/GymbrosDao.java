/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Gymbros;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class GymbrosDao {
    private static final String SQL_SELECTAMIGOS = "SELECT idUsuarioAmigo FROM gymbros where idUsuario=?";
    private static final String SQL_SELECT = "SELECT * FROM gymbros";
    private static final String SQL_INSERT = "INSERT INTO gymbros (idUsuario, idUsuarioAmigo) VALUE (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM gymbros WHERE idUsuarioAmigo=?";
    
    public List<Gymbros> amigos = new ArrayList<>();
    public List<Gymbros> amigo = new ArrayList<>();
    
    public int insertar(Gymbros amigos){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);

                stmt.setInt(1, amigos.getIdUsuario());
                stmt.setInt(2, amigos.getIdUsuarioAmigo());
                
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
    
    
    public int eliminar(Gymbros amigos){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt =conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, amigos.getIdUsuarioAmigo());

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
    

    public List<Gymbros> mostrar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        conn = getConnection();
        stmt =conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int idUsuario = rs.getInt("idUsuario");
            int idUsuarioAmigo = rs.getInt("idUsuarioAmigo");

            amigos.add(new Gymbros (idUsuario, idUsuarioAmigo));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        return amigos;
    }
    
    
}
