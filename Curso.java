import java.util.ArrayList;

public class Curso { 
    private String nombre;
    private int cupoMaximo;
    private ArrayList<String> inscriptos;

    public Curso(String nombre, int cupoMaximo) {
        this.nombre = nombre;
        this.cupoMaximo = (cupoMaximo <= 0) ? 10 : cupoMaximo;
        this.inscriptos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    
    private int buscar(String alumno) {
        for (int i = 0; i < inscriptos.size(); i++) {
            if (inscriptos.get(i).equalsIgnoreCase(alumno)) {
                return i;
            }
        }
        return -1;
    }

    public boolean inscribir(String alumno) {
        if (alumno == null || alumno.trim().isEmpty()) {
            return false;
        }
        alumno = alumno.trim();
        if (estaLleno() || buscar(alumno) != -1) {
            return false;
        }
        inscriptos.add(alumno);
        return true;
    }

    public boolean cancelarInscripcion(String alumno) {
        if (alumno == null) {
            return false;
        }
        int indice = buscar(alumno.trim());
        if (indice == -1) {
            return false;
        }
        inscriptos.remove(indice);
        return true;
    }

    public int cuposDisponibles() {
        return cupoMaximo - inscriptos.size();
    }

    public boolean estaLleno() {
        return inscriptos.size() >= cupoMaximo;
    }

    public void mostrarInscriptos() {
        if (inscriptos.isEmpty()) {
            System.out.println("No hay alumnos inscriptos en el curso.");
            return;
        }
        System.out.println("Inscriptos en " + nombre + ":");
        for (int i = 0; i < inscriptos.size(); i++) {
            System.out.println((i + 1) + ". " + inscriptos.get(i));
        }
    }
}