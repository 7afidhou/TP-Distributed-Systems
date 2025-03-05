package EXO3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                Socket socket = new Socket("localhost", 8080);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                System.out.println("\n1. Inverser un mot");
                System.out.println("2. Vérifier si un mot est un palindrome");
                System.out.println("3. Vérifier si un mot contient un autre");
                System.out.println("4. Quitter");
                System.out.print("Choisissez une option : ");
                int choix = scanner.nextInt();
                scanner.nextLine();

                if (choix == 4) {
                    System.out.println("Fermeture du client...");
                    socket.close();
                    break;
                }

                System.out.print("Entrez un mot : ");
                String word = scanner.nextLine();

                if (choix == 3) {
                    System.out.print("Entrez le sous-mot : ");
                    String subword = scanner.nextLine();
                    out.println("contenir");
                    out.println(word);
                    out.println(subword);
                } else if (choix == 1) {
                    out.println("inverse");
                    out.println(word);
                } else if (choix == 2) {
                    out.println("palindrome");
                    out.println(word);
                } else {
                    System.out.println("Option invalide.");
                    socket.close();
                    continue;
                }

                String response = in.readLine();
                System.out.println("Résultat : " + response);

                socket.close();
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
