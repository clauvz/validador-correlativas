import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    @Getter
    private Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public void agregarMateriaAprobada(Materia materia) {
        correlativas.add(materia);
    }

    public boolean cumpleCorrelativas(Set<Materia> materiasAprobadas) {
        return materiasAprobadas.containsAll(correlativas);
    }

}
