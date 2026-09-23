package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.dto.AuthRequest;
import edu.eci.dosw.oficioya.dto.AuthResponse;
import edu.eci.dosw.oficioya.exception.CredencialesInvalidasException;
import edu.eci.dosw.oficioya.model.Trabajador;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final TrabajadorService trabajadorService;

    public AuthServiceImpl(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @Override
    public AuthResponse autenticar(AuthRequest request) {
        Optional<Trabajador> encontrado = trabajadorService.buscarPorCorreo(request.getCorreo());

        if (encontrado.isEmpty() || !encontrado.get().getContrasena().equals(request.getContrasena())) {
            throw new CredencialesInvalidasException();
        }

        Trabajador trabajador = encontrado.get();
        return new AuthResponse("Autenticación exitosa", trabajador.getCorreo(), trabajador.getNombre());
    }
}
