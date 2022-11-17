/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface InterfazUsuario {
    public int insertar(Usuario usuarios);
    public int actualizar(Usuario usuarios);
    public int eliminar(Usuario usuarios);
    public List<Usuario> seleccionar() throws SQLException;
}
