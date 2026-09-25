package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.dto.AuthRequest;
import edu.eci.dosw.oficioya.dto.AuthResponse;
import edu.eci.dosw.oficioya.exception.CredencialesInvalidasException;
import edu.eci.dosw.oficioya.model.Trabajador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final TrabajadorService trabajadorService;

    public AuthServiceImpl(TrabajadorService trabajadorService) {

        this.trabajadorService =trabajadorService;
    }


    @Override
    public AuthResponse autenticar(AuthRequest request) {

        log.debug("Intentando autenticar usuario con correo: {}", request.getCorreo());

        Optional<Trabajador> encontrado = trabajadorService.buscarPorCorreo(request.getCorreo());

        if (encontrado.isEmpty()) {

            log.warn("Intento de autenticación fallido para correo: {}", request.getCorreo());

            throw new CredencialesInvalidasException();
        }

        Trabajador trabajador = encontrado.get();

        if (trabajador.getUsuario() == null || trabajador.getUsuario().getContrasena() == null || !trabajador.getUsuario().getContrasena().equals(request.getContrasena())) {

            log.warn("Contraseña incorrecta para correo: {}",request.getCorreo());

            throw new CredencialesInvalidasException();
        }

        log.info("Autenticación exitosa para correo: {}",request.getCorreo());

        return new AuthResponse("Autenticación exitosa",trabajador.getUsuario().getCorreo(),trabajador.getNombreCompleto());
    }
}