package edu.eci.dosw.oficioya.model;

import java.util.ArrayList;
import java.util.List;

public class Trabajador extends Usuario {
    private String fotoUrl;
    private String oficioPrincipal;
    private List<String> oficiosSecundarios = new ArrayList<>();
    private List<String> zonaCobertura = new ArrayList<>();
    private Double tarifaAproximada;
    private String disponibilidadSemanal;
    private Boolean disponibleAhora = false;
    private Integer trabajosCompletados = 0;
    private Double calificacionPromedio = 0.0;
    private EstadoTrabajador estado = EstadoTrabajador.ACTIVO;

    public Trabajador() {
        super();
        getRoles().add(RolUsuario.TRABAJADOR);
    }

    public Trabajador(Long id, String nombre, String correo, String telefono, String oficioPrincipal, String contrasena) {
        super(id, nombre, correo, telefono, contrasena);
        this.oficioPrincipal = oficioPrincipal;
        getRoles().add(RolUsuario.TRABAJADOR);
    }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public String getOficioPrincipal() { return oficioPrincipal; }
    public void setOficioPrincipal(String oficioPrincipal) { this.oficioPrincipal = oficioPrincipal; }
    public List<String> getOficiosSecundarios() { return oficiosSecundarios; }
    public void setOficiosSecundarios(List<String> oficiosSecundarios) { this.oficiosSecundarios = oficiosSecundarios; }
    public List<String> getZonaCobertura() { return zonaCobertura; }
    public void setZonaCobertura(List<String> zonaCobertura) { this.zonaCobertura = zonaCobertura; }
    public Double getTarifaAproximada() { return tarifaAproximada; }
    public void setTarifaAproximada(Double tarifaAproximada) { this.tarifaAproximada = tarifaAproximada; }
    public String getDisponibilidadSemanal() { return disponibilidadSemanal; }
    public void setDisponibilidadSemanal(String disponibilidadSemanal) { this.disponibilidadSemanal = disponibilidadSemanal; }
    public Boolean getDisponibleAhora() { return disponibleAhora; }
    public void setDisponibleAhora(Boolean disponibleAhora) { this.disponibleAhora = disponibleAhora; }
    public Integer getTrabajosCompletados() { return trabajosCompletados; }
    public void setTrabajosCompletados(Integer trabajosCompletados) { this.trabajosCompletados = trabajosCompletados; }
    public Double getCalificacionPromedio() { return calificacionPromedio; }
    public void setCalificacionPromedio(Double calificacionPromedio) { this.calificacionPromedio = calificacionPromedio; }
    public EstadoTrabajador getEstado() { return estado; }
    public void setEstado(EstadoTrabajador estado) { this.estado = estado; }
}