package edu.eci.dosw.oficioya.model;

public class Contratante extends Usuario {
    private String fotoUrl;

    public Contratante() {
        super();
        getRoles().add(RolUsuario.CONTRATANTE);
    }

    public Contratante(Long id, String nombre, String correo, String telefono, String contrasena, String fotoUrl) {
        super(id, nombre, correo, telefono, contrasena);
        this.fotoUrl = fotoUrl;
        getRoles().add(RolUsuario.CONTRATANTE);
    }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
}