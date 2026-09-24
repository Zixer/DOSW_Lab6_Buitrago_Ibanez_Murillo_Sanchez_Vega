package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.dto.AuthRequest;
import edu.eci.dosw.oficioya.dto.AuthResponse;

public interface AuthService {
    AuthResponse autenticar(AuthRequest request);
}
