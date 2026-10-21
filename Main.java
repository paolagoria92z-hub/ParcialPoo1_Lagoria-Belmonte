import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del curso: ");
        String nombre = sc.nextLine();

        int cupo = 0;
        System.out.print("Cupo máximo: ");
        try {
            cupo = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido, se usará el cupo por defecto.");
        }

        Curso curso = new Curso(nombre, cupo);
        System.out.println("Curso '" + curso.getNombre() + "' creado con cupo máximo de "
                + curso.getCupoMaximo() + ".");

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Inscribir alumno");
            System.out.println("2. Cancelar inscripción");
            System.out.println("3. Ver inscriptos");
            System.out.println("4. Ver cupos disponibles");
            System.out.println("5. Salir");
            System.out.print("Elegí una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del alumno: ");
                    String alumno = sc.nextLine();
                    if (curso.inscribir(alumno)) {
                        System.out.println("Alumno inscripto correctamente.");
                    } else if (alumno.trim().isEmpty()) {
                        System.out.println("No se pudo inscribir: el nombre está vacío.");
                    } else if (curso.estaLleno()) {
                        System.out.println("No se pudo inscribir: el curso está lleno.");
                    } else {
                        System.out.println("No se pudo inscribir: el alumno ya está inscripto.");
                    }
                    break;
                case 2:
                    System.out.print("Nombre del alumno a cancelar: ");
                    String aCancelar = sc.nextLine();
                    if (curso.cancelarInscripcion(aCancelar)) {
                        System.out.println("Inscripción cancelada correctamente.");
                    } else {
                        System.out.println("No se pudo cancelar: el alumno no está inscripto.");
                    }
                    break;
                case 3:
                    curso.mostrarInscriptos();
                    break;
                case 4:
                    System.out.println("Cupos disponibles: " + curso.cuposDisponibles());
                    if (curso.estaLleno()) {
                        System.out.println("El curso está lleno.");
                    }
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Elegí un número del 1 al 5.");
            }
        } while (opcion != 5);

        sc.close();
    }
}

