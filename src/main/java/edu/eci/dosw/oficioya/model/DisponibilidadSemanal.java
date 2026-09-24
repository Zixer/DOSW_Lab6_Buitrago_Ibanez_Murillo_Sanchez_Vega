import java.time.DayOfWeek;
import java.time.LocalTime;

public class DisponibilidadSemanal {
    private Long id;
    private DayOfWeek diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean activa;
    private Trabajador trabajador;
}