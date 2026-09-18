package edu.eci.dosw.oficioya.model;

public class Trabajador {

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String oficioPrincipal;
    private String contrasena;
    private EstadoTrabajador estado;

    public Trabajador() {
        this.estado = EstadoTrabajador.ACTIVO;
    }

    public Trabajador(Long id, String nombre, String correo, String telefono, String oficioPrincipal, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.oficioPrincipal = oficioPrincipal;
        this.contrasena = contrasena;
        this.estado = EstadoTrabajador.ACTIVO;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getOficioPrincipal() { return oficioPrincipal; }
    public void setOficioPrincipal(String oficioPrincipal) { this.oficioPrincipal = oficioPrincipal; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public EstadoTrabajador getEstado() { return estado; }
    public void setEstado(EstadoTrabajador estado) { this.estado = estado; }
}