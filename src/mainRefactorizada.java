import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainRefactorizada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Double> notas = new HashMap<>();

        // Menú de opciones
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Añadir asignatura");
            System.out.println("2. Ver notas");
            System.out.println("3. Modificar nota");
            System.out.println("4. Eliminar asignatura");
            System.out.println("5. Calcular media");
            System.out.println("6. Salir");

            System.out.print("Elige una opción: ");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    agregarAsignaturas(notas, scan);
                    break;

                case 2:
                    mostrarNotas(notas);
                    break;

                case 3:
                    modificarNota(notas, scan);
                    break;

                case 4:
                    eliminarAsignatura(notas, scan);
                    break;

                case 5:
                    // Calcular media
                    if (!notas.isEmpty()) {

                        double media = calcularMedia(notas);
                        System.out.println("\nLa media final es: " + media);

                    } else {
                        System.out.println("\nNo hay notas para hacer media");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }
        scan.close();
    }

    public static void mostrarNotas(Map<String, Double> notas) {
        System.out.println("\n--- LISTADO DE NOTAS ---");
        for (String asignatura : notas.keySet()) {
            System.out.println(asignatura + " -> " + notas.get(asignatura));
        }
    }

    public static double calcularMedia(Map<String, Double> notas) {
        double suma = 0;

        for (Double nota : notas.values()) {
            suma += nota;
        }

        return suma / notas.size();
    }

    public static void agregarAsignaturas(Map<String, Double> notas, Scanner scan) {
        // Pedir Asignaturas
        System.out.println(
                "A continuacion te pediremos que introduzcas tu asignatura y seguido la nota. \n Cuando hayas terminado, escribe la palabra 'fin' para guardar.");

        boolean continuar = true;

        while (continuar) {

            System.out.println("Asignatura: ");
            String asignatura = scan.nextLine();

            if (asignatura.equalsIgnoreCase("fin")) {

                continuar = false;

            } else {

                System.out.println("Nota: ");
                double nota = scan.nextDouble();
                scan.nextLine();

                notas.put(asignatura, nota);
            }
        }
    }

    public static void modificarNota(Map<String, Double> notas, Scanner scan) {
        // Modificar Asignatura
        System.out.println("\n¿Deseas modificar alguna nota? \n 1. Sí \n 2. No");

        int opcionModificar = scan.nextInt();
        scan.nextLine();
        if (opcionModificar == 1) {

            while (opcionModificar == 1) {

                System.out.println("Asignatura a modificar: ");
                String asignaturaModificar = scan.nextLine();

                if (notas.containsKey(asignaturaModificar)) {

                    System.out.println("Nueva nota: ");
                    double nuevaNota = scan.nextDouble();
                    scan.nextLine();

                    notas.put(asignaturaModificar, nuevaNota);

                    System.out.println("Nota modificada correctamente.");
                } else {
                    System.out.println("La asignatura no existe.");
                }

                System.out.println("\n¿Deseas modificar otra nota? \n 1. Sí \n 2. No");

                opcionModificar = scan.nextInt();
                scan.nextLine();
            }
        }
    }

    public static void eliminarAsignatura(Map<String, Double> notas, Scanner scan) {
        // Eliminar nota
        mostrarNotas(notas);

        System.out.println("\n¿Deseas Eliminar alguna nota? \n 1. Sí \n 2. No");

        int opcionEliminar = scan.nextInt();
        scan.nextLine();

        while (opcionEliminar == 1 && !notas.isEmpty()) {

            System.out.println("Asignatura a eliminar: ");
            String asignaturaEliminar = scan.nextLine();

            if (notas.containsKey(asignaturaEliminar)) {

                notas.remove(asignaturaEliminar);

                System.out.println("Asignatura eliminada correctamente.");
            } else {
                System.out.println("La asignatura no existe.");
            }

            if (!notas.isEmpty()) {
                mostrarNotas(notas);

                System.out.println("\n¿Deseas eliminar otra nota? \n 1. Sí \n 2. No");

                opcionEliminar = scan.nextInt();
                scan.nextLine();
            }
        }
    }
}
