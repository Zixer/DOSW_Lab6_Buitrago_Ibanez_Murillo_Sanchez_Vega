package edu.eci.dosw.oficioya.dto;

public class AuthResponse {
    private String mensaje;
    private String correo;
    private String nombre;

    public AuthResponse(String mensaje, String correo, String nombre){
        this.mensaje = mensaje;
        this.correo = correo;
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }
}
