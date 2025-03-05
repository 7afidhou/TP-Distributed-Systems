package exo2;

import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Récupération de l’objet distant
            CalculatorService service = (CalculatorService) Naming.lookup("rmi://localhost/CalculatorService");

            // Interface utilisateur simple
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le premier nombre : ");
            int a = scanner.nextInt();
            System.out.print("Entrez le deuxième nombre : ");
            int b = scanner.nextInt();

            System.out.println("Somme : " + service.add(a, b));
            System.out.println("Produit : " + service.multiply(a, b));
            System.out.println("Soustraction : " + service.subtract(a, b));

            try {
                System.out.println("Division : " + service.divide(a, b));
            } catch (ArithmeticException e) {
                System.out.println("Erreur : " + e.getMessage());
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

