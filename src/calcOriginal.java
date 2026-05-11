
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Precious Aikhomun
 */
public class CalcOriginal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> array = new ArrayList<>();

        System.out.println("Hola, \nPara poder calcular la media, te ingresarás tus notas (entre 1 y 10)");
        System.out.println("Introduce un número menor que 1 para finalizar.");

        double nota;

        // Pedir nota mientras que sea menor que 10 y no parar hasta que le des un
        // número menor que 1
        do {
            System.out.print("Ingresa la nota: ");
            nota = scan.nextDouble();

            while (nota > 10) {
                System.out.println("Error, debe estar entre 1 y 10");
                nota = scan.nextDouble();
            }

            if (nota >= 1 && nota <= 10) {
                array.add(nota);
            }

        } while (nota >= 1);

        // Mostrar nº de notas agregado
        int modificar;
        System.out.println("Tus calificaciones:");
        for (int i = 0; i < array.size(); i++) {
            System.out.println((i + 1) + ". " + array.get(i));
        }

        // Modificar notas
        do {
            System.out.println("Te gustaria cambiar alguna nota?");
            System.out.println("1. Si \n2. No");
            modificar = scan.nextInt();

        } while (modificar < 1 || modificar > 2);

        while (modificar == 1) {

            System.out.print("Posicion a cambiar: ");
            int posicion = scan.nextInt();

            System.out.print("Nueva nota (1-10): ");
            double nuevaNota = scan.nextDouble();

            if (posicion >= 1 && posicion <= array.size() && nuevaNota >= 1 && nuevaNota <= 10) {

                array.set(posicion - 1, nuevaNota);
                System.out.println("Se ha cambiado correctamente.");

            } else {
                System.out.println("Datos inválidos.");
            }

            do {
                System.out.println("\nModificamos otra nota?");
                System.out.println("1: Sí \n2: No");
                modificar = scan.nextInt();
            } while (modificar < 1 || modificar > 2);
        }

        // Eliminar nota?
        int eliminar, pos;
        System.out.println("Eliminamos alguna nota? \n1: Sí \n2: No");
        eliminar = scan.nextInt();

        while (eliminar < 1 || eliminar > 2) {
            System.out.println("Error. Elige \n1: Sí \n2: No");
            eliminar = scan.nextInt();
        }

        // Eliminar notas
        while (eliminar == 1) {

            do {
                System.out.println("Cual es la posición de la nota a eliminar?");
                pos = scan.nextInt();

                if (pos < 1 || pos > array.size()) {
                    System.out.println("Posición inválida. Debe estar entre 1 y " + array.size());
                }
            } while (pos < 1 || pos > array.size());

            array.remove(pos - 1);

            // Mostrar listado actualizado
            if (array.size() > 0) {
                System.out.println("Listado actualizado de notas:");
                for (int i = 0; i < array.size(); i++) {
                    System.out.println((i + 1) + ". " + array.get(i));
                }

                System.out.println("¿Deseas eliminar otra nota? \n1: Sí \n2: No");
                eliminar = scan.nextInt();

                while (eliminar < 1 || eliminar > 2) {
                    System.out.println("Opción no válida. Por favor, elige 1: Sí - 2: No");
                    eliminar = scan.nextInt();
                }
            } else {// Lista vacía
                eliminar = 2;
            }
        }

        // Cálculo de la media
        if (!array.isEmpty()) {
            double suma = 0;
            for (double n : array) {
                suma += n;
            }
            double media = suma / array.size();
            System.out.println("La media es: " + media);
        } else {
            System.out.println("No se ingresaron notas válidas.");
        }
        scan.close();

    }
}
