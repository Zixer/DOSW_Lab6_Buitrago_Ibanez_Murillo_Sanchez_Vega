import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private Long id;
    private String email;
    private String passwordHash;
    private String telefono;
    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimoAcceso;
    private Boolean eliminadoLogico;
    private Trabajador trabajador;
}