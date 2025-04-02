import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


public class Inscripcion {
    private Set<Materia> materiasACursar;
    private boolean fueAprobada;
    private Alumno alumno;
    private LocalDateTime fechaDeEvaluacion;

    public Inscripcion(Alumno alumno, Set<Materia> materiasACursar) {
        this.alumno = alumno;
        this.materiasACursar = materiasACursar;
        this.fechaDeEvaluacion = LocalDateTime.now();
        this.fueAprobada = aprobada();
    }

    public boolean aprobada(){
        return materiasACursar.stream()
                .allMatch(m -> m.cumpleCorrelativas(alumno.getMateriasAprobadas()));
    }
}
