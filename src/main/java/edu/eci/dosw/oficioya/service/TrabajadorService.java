package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.model.Trabajador;
import java.util.List;
import java.util.Optional;

public interface TrabajadorService {
    List<Trabajador> listar();
    Trabajador obtenerPorId(Long id);
    Trabajador crear(Trabajador trabajador);
    Trabajador actualizar(Long id, Trabajador trabajador);
    Trabajador desactivar(Long id);
    Optional<Trabajador> buscarPorCorreo(String correo);
}

