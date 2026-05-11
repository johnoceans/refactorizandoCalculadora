import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainRefactorizada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Double> notas = new HashMap<>();

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

        System.out.println("\n--- LISTADO DE NOTAS ---");
        for (String asignatura : notas.keySet()) {
            System.out.println(asignatura + " -> " + notas.get(asignatura));
        }

        System.out.println("\n¿Deseas modificar alguna nota? \n 1. Sí \n 2. No");

        int opcionModificar = scan.nextInt();
        scan.nextLine();

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

        // Eliminar nota
        System.out.println("\n--- LISTADO DE NOTAS ---");
        for (String asignatura : notas.keySet()) {
            System.out.println(asignatura + " -> " + notas.get(asignatura));
        }

        System.out.println("\n¿Deseas Eliminar alguna nota? \n 1. Sí \n 2. No");

        int opcionEliminar = scan.nextInt();
        scan.nextLine();

        while (opcionEliminar == 1) {

            System.out.println("Asignatura a eliminar: ");
            String asignaturaEliminar = scan.nextLine();

            if (notas.containsKey(asignaturaEliminar)) {

                notas.remove(asignaturaEliminar);

                System.out.println("Asignatura eliminada correctamente.");
            } else {
                System.out.println("La asignatura no existe.");
            }

            if (!notas.isEmpty()) {
                System.out.println("\n--- LISTADO DE NOTAS ---");
                for (String asignatura : notas.keySet()) {
                    System.out.println(asignatura + " -> " + notas.get(asignatura));
                }
                System.out.println("\n¿Deseas eliminar otra nota? \n 1. Sí \n 2. No");

                opcionEliminar = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("No quedan asignaturas.");

                opcionEliminar = 2;
            }

        }

        //Calcular media
        double suma = 0;

        for (Double nota : notas.values()) {
            suma += nota;
        }

        if (!notas.isEmpty()) {
            
            double media = suma / notas.size();
            System.out.println("\nLa media final es: " + media);

        } else {
            System.out.println("\nNo hay notas para hacer media");
        }

        scan.close();
    }
}
