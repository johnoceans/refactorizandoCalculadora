import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainRefactorizada {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Map<String, Double> notas = new HashMap<>();

        //Pedir Asignaturas
        boolean continuar = true;
        while (continuar) {

             System.out.println("Asignatura: ");
             String asignatura = scan.nextLine();

             if (asignatura.equalsIgnoreCase("fin")) {

                continuar = false;    

             } else {

                System.out.println("Nota: ");
                double nota= scan.nextDouble();
                scan.nextLine();

                notas.put(asignatura, nota);
             }
    }
}
