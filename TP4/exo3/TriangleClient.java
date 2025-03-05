package exo3;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class TriangleClient {
    public static void main(String[] args) {
        try {
            // Récupération de l’objet distant
            TriangleService service = (TriangleService) Naming.lookup("rmi://localhost/TriangleService");

            // Interface utilisateur
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le nombre de lignes : ");
            int lines = scanner.nextInt();

            // Affichage du Triangle A
            System.out.println("\nFigure (a) :");
            List<String> triangleA = service.drawTriangleA(lines);
            for (String line : triangleA) {
                System.out.println(line);
            }

            // Affichage du Triangle B
            System.out.println("\nFigure (b) :");
            List<String> triangleB = service.drawTriangleB(lines);
            for (String line : triangleB) {
                System.out.println(line);
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
