import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    private Alumno alumno;
    private Materia materia1;
    private Materia materia2;
    private Materia materia3;

    @BeforeEach
    public void setUp() {
        // Crear un alumno
        alumno = new Alumno("Juan", "Gomez");

        // Crear materias
        materia1 = new Materia("Matemática");
        materia2 = new Materia("Física");
        materia3 = new Materia("Química");

        // Aprobación de materias
        alumno.agregarMateriaAprobada(materia1);
    }

    // Test: Verificar que una materia puede agregar correlativas correctamente
    @Test
    public void testAgregarCorrelativasMateria() {
        materia2.agregarMateriaAprobada(materia1);

        assertTrue(materia2.getCorrelativas().contains(materia1));
    }

    // Test: Verificar que un alumno puede aprobar materias
    @Test
    public void testAgregarMateriaAprobadaAlumno() {
        alumno.agregarMateriaAprobada(materia2);

        assertTrue(alumno.getMateriasAprobadas().contains(materia2));
    }

    // Test: Verificar si el alumno puede inscribirse a una materia sin correlativas no aprobadas
    @Test
    public void testInscripcionAprobada() {
        materia2.agregarMateriaAprobada(materia1);
        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(materia2);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasACursar);

        assertTrue(inscripcion.aprobada());
    }

    // Test: Verificar que si todas las correlativas son aprobadas, la inscripción es correcta
    @Test
    public void testInscripcionCorrecta() {
        materia2.agregarMateriaAprobada(materia1);
        materia3.agregarMateriaAprobada(materia2);
        alumno.agregarMateriaAprobada(materia2);

        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(materia2);
        materiasACursar.add(materia3);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasACursar);

        assertTrue(inscripcion.aprobada());
    }

}