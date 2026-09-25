package edu.eci.dosw.oficioya.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;
    private List<RolUsuario> roles = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String correo,String telefono, String contrasena) {

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<RolUsuario> getRoles() {
        return roles;
    }

    public void setRoles(List<RolUsuario> roles) {
        this.roles = roles;
    }
}