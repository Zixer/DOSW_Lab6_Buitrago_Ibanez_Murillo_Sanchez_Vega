package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.exception.CampoObligatorioException;
import edu.eci.dosw.oficioya.exception.TrabajadorNoEncontradoException;
import edu.eci.dosw.oficioya.model.Trabajador;
import edu.eci.dosw.oficioya.model.Usuario;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    private final Map<Long, Trabajador> trabajadores = new ConcurrentHashMap<>();

    private final AtomicLong contadorId = new AtomicLong(1);

    public TrabajadorServiceImpl() {

        Usuario usuarioDemo = new Usuario();

        usuarioDemo.setId(1L);
        usuarioDemo.setNombre("Trabajador Demo");
        usuarioDemo.setCorreo("demo@ejemplo.com");
        usuarioDemo.setTelefono("3001234567");
        usuarioDemo.setContrasena("1234");

        Trabajador trabajadorDemo = new Trabajador();

        trabajadorDemo.setId(1L);
        trabajadorDemo.setNombreCompleto("Trabajador Demo");
        trabajadorDemo.setUsuario(usuarioDemo);
        trabajadorDemo.setDisponibleAhora(true);
        trabajadorDemo.setTrabajosCompletados(0);
        trabajadorDemo.setCalificacionPromedio(0.0);
        trabajadorDemo.setPenalizacionAcumulada(0.0);
        trabajadorDemo.setEliminadoLogico(false);
        trabajadorDemo.setFechaCreacion(LocalDateTime.now());
        trabajadorDemo.setFechaActualizacion(LocalDateTime.now());

        trabajadores.put(1L, trabajadorDemo);

        contadorId.set(2);
    }

    @Override
    public List<Trabajador> listar() {
        return new ArrayList<>(trabajadores.values());
    }


    @Override
    public Trabajador obtenerPorId(Long id) {

        Trabajador trabajador = trabajadores.get(id);

        if (trabajador == null) {
            throw new TrabajadorNoEncontradoException(id);
        }

        return trabajador;
    }


    @Override
    public Trabajador crear(Trabajador trabajador) {

        validarCamposObligatorios(trabajador);

        Long id = contadorId.getAndIncrement();

        trabajador.setId(id);
        trabajador.setEliminadoLogico(false);

        trabajador.setFechaCreacion(LocalDateTime.now());

        trabajador.setFechaActualizacion(
                LocalDateTime.now()
        );

        trabajadores.put(id, trabajador);

        return trabajador;
    }


    @Override
    public Trabajador actualizar(Long id,Trabajador datosNuevos) {

        Trabajador existente =obtenerPorId(id);

        if (Boolean.TRUE.equals(existente.getEliminadoLogico())) {
            throw new IllegalStateException(
                    "No se puede modificar un trabajador inactivo"
            );
        }

        validarCamposObligatorios(datosNuevos);

        existente.setNombreCompleto(datosNuevos.getNombreCompleto());

        existente.setFotoPerfilUrl(datosNuevos.getFotoPerfilUrl());

        existente.setTarifaAproximada(datosNuevos.getTarifaAproximada());

        existente.setDisponibleAhora(datosNuevos.getDisponibleAhora());

        existente.setTrabajosCompletados(datosNuevos.getTrabajosCompletados());

        existente.setCalificacionPromedio(datosNuevos.getCalificacionPromedio());

        existente.setPenalizacionAcumulada(datosNuevos.getPenalizacionAcumulada());

        existente.setUsuario(datosNuevos.getUsuario());

        existente.setHorarios(datosNuevos.getHorarios());

        existente.setOficios(datosNuevos.getOficios());

        existente.setFechaActualizacion(LocalDateTime.now());

        return existente;
    }


    @Override
    public Trabajador desactivar(Long id) {

        Trabajador trabajador =obtenerPorId(id);

        trabajador.setEliminadoLogico(true);

        trabajador.setFechaActualizacion(LocalDateTime.now());

        return trabajador;
    }


    @Override
    public Optional<Trabajador> buscarPorCorreo(
            String correo) {

        return trabajadores.values().stream().filter(t ->!Boolean.TRUE.equals(t.getEliminadoLogico()))
                .filter(t ->t.getUsuario() != null)

                .filter(t ->t.getUsuario().getCorreo() != null)

                .filter(t ->t.getUsuario().getCorreo().equalsIgnoreCase(correo))

                .findFirst();
    }


    private void validarCamposObligatorios(Trabajador trabajador) {

        if (trabajador == null) {
            throw new CampoObligatorioException(
                    "trabajador"
            );
        }

        if (isVacio(trabajador.getNombreCompleto())) {
            throw new CampoObligatorioException(
                    "nombre"
            );
        }

        if (trabajador.getUsuario() == null) {
            throw new CampoObligatorioException(
                    "usuario"
            );
        }

        if (isVacio(trabajador.getUsuario().getCorreo())) {
            throw new CampoObligatorioException(
                    "correo"
            );
        }

        if (isVacio(trabajador.getUsuario().getTelefono())) {
            throw new CampoObligatorioException(
                    "telefono"
            );
        }

        if (isVacio(trabajador.getUsuario().getContrasena())) {
            throw new CampoObligatorioException(
                    "contrasena"
            );
        }

        if (trabajador.getOficios() == null || trabajador.getOficios().isEmpty()) {
            throw new CampoObligatorioException(
                    "oficio principal"
            );
        }
    }


    private boolean isVacio(String valor) {
        return valor == null || valor.isBlank();
    }
}