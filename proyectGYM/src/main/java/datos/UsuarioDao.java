/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Alumno Mañana
 */
public class UsuarioDao {
    private static final String SQL_SELECT = "SELECT * FROM Usuario";
    private static final String SQL_INSERT = "INSERT INTO Usuario (Nombre, Correo, Clave, Gimnasio, Edad, Altura, Peso, Foto, FechaAlta) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Usuario SET Nombre=?, Correo=?, Clave=?, Gimnasio=?, Edad=?, Altura=?, Peso=?, Foto=?, FechaAlta=? WHERE idUsuario=?";
    private static final String SQL_DELETE = "DELETE FROM Usuario WHERE idUsuario=?";
}
