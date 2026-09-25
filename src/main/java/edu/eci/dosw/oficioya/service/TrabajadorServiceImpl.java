package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.exception.CampoObligatorioException;
import edu.eci.dosw.oficioya.exception.TrabajadorNoEncontradoException;
import edu.eci.dosw.oficioya.model.Trabajador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(TrabajadorServiceImpl.class);

    private final Map<Long, Trabajador> trabajadores = new ConcurrentHashMap<>();

    private final AtomicLong contadorId = new AtomicLong(1);


    public TrabajadorServiceImpl() {

        log.info("Inicializando servicio de trabajadores");

    }


    @Override
    public List<Trabajador> listar() {

        log.debug("Consultando lista de trabajadores");

        List<Trabajador> lista = new ArrayList<>(trabajadores.values());

        log.info("Se encontraron {} trabajadores", lista.size());

        return lista;
    }


    @Override
    public Trabajador obtenerPorId(Long id) {

        log.debug("Buscando trabajador con id: {}", id);

        Trabajador trabajador = trabajadores.get(id);

        if (trabajador == null) {

            log.error("No se encontró trabajador con id: {}", id);
            throw new TrabajadorNoEncontradoException(id);
        }

        log.info("Trabajador encontrado con id: {}",id);

        return trabajador;
    }


    @Override
    public Trabajador crear(Trabajador trabajador) {

        log.debug("Iniciando creación de trabajador");

        validarCamposObligatorios(trabajador);

        Long id =contadorId.getAndIncrement();

        trabajador.setId(id);
        trabajador.setEliminadoLogico(false);
        trabajador.setFechaCreacion(LocalDateTime.now());
        trabajador.setFechaActualizacion(LocalDateTime.now());

        trabajadores.put(id, trabajador);

        log.info("Trabajador creado correctamente con id: {}", id);

        return trabajador;
    }


    @Override
    public Trabajador actualizar(Long id, Trabajador datosNuevos) {

        log.debug("Intentando actualizar trabajador con id: {}", id);

        Trabajador existente = obtenerPorId(id);

        if (Boolean.TRUE.equals(existente.getEliminadoLogico())) {

            log.error("No se puede actualizar el trabajador {} porque está inactivo",id);

            throw new IllegalStateException("No se puede modificar un trabajador inactivo");}

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

        log.info("Trabajador actualizado correctamente con id: {}",id);

        return existente;
    }


    @Override
    public Trabajador desactivar(Long id) {

        log.debug("Intentando inactivar trabajador con id: {}",id);

        Trabajador trabajador = obtenerPorId(id);

        trabajador.setEliminadoLogico(true);
        trabajador.setFechaActualizacion(LocalDateTime.now());

        log.info("Trabajador inactivado correctamente con id: {}", id );

        return trabajador;
    }


    @Override
    public Optional<Trabajador> buscarPorCorreo(String correo) {

        log.debug("Buscando trabajador por correo: {}", correo);

        Optional<Trabajador> resultado = trabajadores.values()
                        .stream()

                        .filter(t ->!Boolean.TRUE.equals(t.getEliminadoLogico()))

                        .filter(t ->t.getUsuario() != null)

                        .filter(t ->t.getUsuario().getCorreo() != null)

                        .filter(t -> t.getUsuario().getCorreo().equalsIgnoreCase(correo))

                        .findFirst();

        if (resultado.isPresent()) {

            log.info("Trabajador encontrado para el correo: {}", correo);} 
            
            else {

            log.warn("No se encontró trabajador para el correo: {}", correo);
        }

        return resultado;
    }


    private void validarCamposObligatorios(Trabajador trabajador) {

        log.debug("Validando campos obligatorios del trabajador");

        if (trabajador == null) {log.error("El trabajador recibido es null");
            throw new CampoObligatorioException("trabajador");
        }

        if (isVacio(trabajador.getNombreCompleto())) {

            log.error("Campo obligatorio nombre vacío");

            throw new CampoObligatorioException("nombre");
        }

        if (trabajador.getUsuario() == null) {

            log.error("Campo obligatorio usuario vacío");

            throw new CampoObligatorioException("usuario");
        }

        if (isVacio(trabajador.getUsuario().getCorreo())) {

            log.error("Campo obligatorio correo vacío");

            throw new CampoObligatorioException("correo");
        }

        if (isVacio(trabajador.getUsuario().getTelefono())) {

            log.error("Campo obligatorio teléfono vacío");

            throw new CampoObligatorioException("telefono");
        }

        if (isVacio(trabajador.getUsuario().getContrasena())) {

            log.error("Campo obligatorio contraseña vacío");

            throw new CampoObligatorioException("contrasena");
        }

        if (trabajador.getOficios() == null || trabajador.getOficios().isEmpty()) {

            log.error("Campo obligatorio oficio principal vacío");

            throw new CampoObligatorioException("oficio principal");
        }
    }


    private boolean isVacio(String valor) {
        return valor == null || valor.isBlank();
    }
}