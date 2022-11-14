/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Alumno Mañana
 */
public class Gymbros {
    private int idUsuario;
    private int idUsuarioAmigo;

    public Gymbros(int idUsuario, int idUsuarioAmigo) {
        this.idUsuario = idUsuario;
        this.idUsuarioAmigo = idUsuarioAmigo;
    }

    
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuarioAmigo() {
        return idUsuarioAmigo;
    }

    public void setIdUsuarioAmigo(int idUsuarioAmigo) {
        this.idUsuarioAmigo = idUsuarioAmigo;
    }
    
    
    
}
