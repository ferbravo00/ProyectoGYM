/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Alumno Mañana
 */
public class Usuario {
    private int idUsuario;
    private String Nombre;
    private String Correo;
    private String Clave;
    private String Gimnasio;
    private int Edad;
    private int Altura;
    private int Peso;
    private String Foto;
    private String FechaAlta;
    private int Usuario_idUsuario;

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(int idUsuario, String Nombre, String Correo, String Clave, String Gimnasio, int Edad, int Altura, int Peso, String Foto, String FechaAlta, int Usuario_idUsuario) {
        this.idUsuario = idUsuario;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Clave = Clave;
        this.Gimnasio = Gimnasio;
        this.Edad = Edad;
        this.Altura = Altura;
        this.Peso = Peso;
        this.Foto = Foto;
    }

    public Usuario(String Nombre, String Correo, String Clave, String Gimnasio, int Edad, int Altura, int Peso, String Foto) {
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Clave = Clave;
        this.Gimnasio = Gimnasio;
        this.Edad = Edad;
        this.Altura = Altura;
        this.Peso = Peso;
        this.Foto = Foto;
        LocalDate Fecha = LocalDate.now();
        this.FechaAlta = Fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.Usuario_idUsuario = 0;
        
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getGimnasio() {
        return Gimnasio;
    }

    public void setGimnasio(String Gimnasio) {
        this.Gimnasio = Gimnasio;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int Altura) {
        this.Altura = Altura;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{idUsuario=").append(idUsuario);
        sb.append(", Nombre=").append(Nombre);
        sb.append(", Correo=").append(Correo);
        sb.append(", Clave=").append(Clave);
        sb.append(", Gimnasio=").append(Gimnasio);
        sb.append(", Edad=").append(Edad);
        sb.append(", Altura=").append(Altura);
        sb.append(", Peso=").append(Peso);
        sb.append(", Foto=").append(Foto);
        sb.append(", FechaAlta=").append(FechaAlta);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
