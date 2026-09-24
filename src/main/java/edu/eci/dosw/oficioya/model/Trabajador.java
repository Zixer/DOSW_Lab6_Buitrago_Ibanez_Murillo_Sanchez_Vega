import java.math.BigDecimal;
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
}