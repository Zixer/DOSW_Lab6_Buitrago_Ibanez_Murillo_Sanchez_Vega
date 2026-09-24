package edu.eci.dosw.oficioya.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Trabajador {

    private Long id;
    private String nombreCompleto;
    private String fotoPerfilUrl;
    private Double tarifaAproximada;
    private Boolean disponibleAhora;
    private Integer trabajosCompletados;
    private Double calificacionPromedio;
    private Double penalizacionAcumulada;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Boolean eliminadoLogico;
    private Usuario usuario;
    private List<DisponibilidadSemanal> horarios = new ArrayList<>();
    private List<OficioTrabajador> oficios = new ArrayList<>();


    public Trabajador() {
    }


    public Trabajador(Long id, String nombreCompleto, String fotoPerfilUrl,Double tarifaAproximada, Boolean disponibleAhora,Integer trabajosCompletados, Double calificacionPromedio,
                      Double penalizacionAcumulada, LocalDateTime fechaCreacion,LocalDateTime fechaActualizacion, Boolean eliminadoLogico,Usuario usuario) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.tarifaAproximada = tarifaAproximada;
        this.disponibleAhora = disponibleAhora;
        this.trabajosCompletados = trabajosCompletados;
        this.calificacionPromedio = calificacionPromedio;
        this.penalizacionAcumulada = penalizacionAcumulada;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.eliminadoLogico = eliminadoLogico;
        this.usuario = usuario;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }


    public Double getTarifaAproximada() {
        return tarifaAproximada;
    }

    public void setTarifaAproximada(Double tarifaAproximada) {
        this.tarifaAproximada = tarifaAproximada;
    }


    public Boolean getDisponibleAhora() {
        return disponibleAhora;
    }

    public void setDisponibleAhora(Boolean disponibleAhora) {
        this.disponibleAhora = disponibleAhora;
    }


    public Integer getTrabajosCompletados() {
        return trabajosCompletados;
    }

    public void setTrabajosCompletados(Integer trabajosCompletados) {
        this.trabajosCompletados = trabajosCompletados;
    }


    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }


    public Double getPenalizacionAcumulada() {
        return penalizacionAcumulada;
    }

    public void setPenalizacionAcumulada(Double penalizacionAcumulada) {
        this.penalizacionAcumulada = penalizacionAcumulada;
    }


    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }


    public Boolean getEliminadoLogico() {
        return eliminadoLogico;
    }

    public void setEliminadoLogico(Boolean eliminadoLogico) {
        this.eliminadoLogico = eliminadoLogico;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public List<DisponibilidadSemanal> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<DisponibilidadSemanal> horarios) {
        this.horarios = horarios;
    }


    public List<OficioTrabajador> getOficios() {
        return oficios;
    }

    public void setOficios(List<OficioTrabajador> oficios) {
        this.oficios = oficios;
    }
}