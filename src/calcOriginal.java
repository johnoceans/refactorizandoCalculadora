import java.util.Scanner;

public class calcOriginal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        double[] tempCalificaciones = new double[100]; 
        double calificacionIngresada;
        int contador = 0; 

        while (true) {
            System.out.print("Ingrese una calificación (menor a 1 para terminar): ");
            calificacionIngresada = scanner.nextDouble(); 

            if (calificacionIngresada >= 1.0) {
                tempCalificaciones[contador] = calificacionIngresada; 
                contador++; 
            } else {
                break; 
            }
        } 

        double[] calificaciones = new double[contador];
        
        for (int i = 0; i < contador; i++) {
            calificaciones[i] = tempCalificaciones[i]; 
        }

        System.out.println("\n--- Listado de Calificaciones Introducidas ---");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Posición " + i + ": " + calificaciones[i]);
        }

        String deseaModificar = ""; 
        boolean continuarModificando = true;
        
        while (continuarModificando) {
            System.out.print("\n¿Desea modificar alguna calificación? (si/no): ");
            deseaModificar = scanner.next();

            if (deseaModificar.equals("si")) { 
                System.out.print("Indique la posición a modificar (0 a " + (calificaciones.length - 1) + "): ");
                int posicionModificar = scanner.nextInt();
                
                System.out.print("Ingrese el nuevo valor: ");
                double nuevoValor = scanner.nextDouble();

                if (posicionModificar >= 0 && posicionModificar < calificaciones.length) {
                    calificaciones[posicionModificar] = nuevoValor;
                    System.out.println("Calificación en posición " + posicionModificar + " modificada a " + nuevoValor);
                } else {
                    System.out.println("Posición inválida.");
                }
            } else {
                continuarModificando = false; 
            }
        }
        
        String deseaEliminar = "";
        boolean continuarEliminando = true;

        while (continuarEliminando) {
            System.out.print("\n¿Desea eliminar alguna calificación? (si/no): ");
            deseaEliminar = scanner.next();

            if (deseaEliminar.equals("si")) {
                
                if (calificaciones.length == 0) {
                    System.out.println("No hay calificaciones para eliminar.");
                    continuarEliminando = false; 
                }

                System.out.print("Indique la posición a eliminar (0 a " + (calificaciones.length - 1) + "): ");
                int posicionEliminar = scanner.nextInt();

                if (posicionEliminar >= 0 && posicionEliminar < calificaciones.length) {
                    
                    double[] nuevoArray = new double[calificaciones.length - 1];
                    int j = 0;
                    
                    for (int i = 0; i < calificaciones.length; i++) {
                        if (i != posicionEliminar) { 
                            nuevoArray[j] = calificaciones[i];
                            j++;
                        }
                    }
                    
                    calificaciones = nuevoArray; 
                    System.out.println("Calificación en posición " + posicionEliminar + " eliminada.");

                    System.out.println("\n--- Listado Actualizado ---");
                    for (int i = 0; i < calificaciones.length; i++) {
                        System.out.println("Posición " + i + ": " + calificaciones[i]);
                    }
                    
                } else {
                    System.out.println("Posición inválida.");
                }
            } else {
                continuarEliminando = false; 
            }
        }

        double suma = 0.0;
        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i]; 
        }

        double media = 0.0;
        if (calificaciones.length > 0) { 
            media = suma / (double) calificaciones.length; 
        }

        System.out.println("\n--- Resultado Final ---");
        System.out.println("La media de todas las calificaciones introducidas es: " + media);

        scanner.close();
    }
}

