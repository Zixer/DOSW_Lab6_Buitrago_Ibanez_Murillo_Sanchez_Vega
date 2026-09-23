package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.exception.CampoObligatorioException;
import edu.eci.dosw.oficioya.exception.TrabajadorNoEncontradoException;
import edu.eci.dosw.oficioya.model.EstadoTrabajador;
import edu.eci.dosw.oficioya.model.Trabajador;
import org.springframework.stereotype.Service;

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
        trabajador.setEstado(EstadoTrabajador.ACTIVO);
        trabajadores.put(id, trabajador);
        return trabajador;
    }

    @Override
    public Trabajador actualizar(Long id, Trabajador datosNuevos) {
        Trabajador existente = obtenerPorId(id);
        validarCamposObligatorios(datosNuevos);

        existente.setNombre(datosNuevos.getNombre());
        existente.setCorreo(datosNuevos.getCorreo());
        existente.setTelefono(datosNuevos.getTelefono());
        existente.setOficioPrincipal(datosNuevos.getOficioPrincipal());
        existente.setOficiosSecundarios(datosNuevos.getOficiosSecundarios());
        existente.setZonaCobertura(datosNuevos.getZonaCobertura());
        existente.setTarifaAproximada(datosNuevos.getTarifaAproximada());
        existente.setDisponibilidadSemanal(datosNuevos.getDisponibilidadSemanal());
        existente.setDisponibleAhora(datosNuevos.getDisponibleAhora());
        existente.setFotoUrl(datosNuevos.getFotoUrl());

        return existente;
    }

    @Override
    public Trabajador desactivar(Long id) {
        Trabajador trabajador = obtenerPorId(id);
        trabajador.setEstado(EstadoTrabajador.INACTIVO);
        return trabajador;
    }

    @Override
    public Optional<Trabajador> buscarPorCorreo(String correo) {
        return trabajadores.values().stream()
                .filter(t -> t.getCorreo().equalsIgnoreCase(correo))
                .findFirst();
    }

    private void validarCamposObligatorios(Trabajador trabajador) {
        if (isVacio(trabajador.getNombre())) throw new CampoObligatorioException("nombre");
        if (isVacio(trabajador.getCorreo())) throw new CampoObligatorioException("correo");
        if (isVacio(trabajador.getTelefono())) throw new CampoObligatorioException("telefono");
        if (isVacio(trabajador.getOficioPrincipal())) throw new CampoObligatorioException("oficioPrincipal");
        if (isVacio(trabajador.getContrasena())) throw new CampoObligatorioException("contrasena");
    }

    private boolean isVacio(String valor) {
        return valor == null || valor.isBlank();
    }
}
