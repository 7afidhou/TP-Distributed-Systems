package EXO2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);  // Connexion au serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            // Demander à l'utilisateur de choisir l'opération
            System.out.println("Choisissez une opération : ");
            System.out.println("1. Déposer");
            System.out.println("2. Retirer");
            System.out.println("3. Consulter le solde");
            System.out.print("Entrez le numéro de l'opération : ");
            int choix = scanner.nextInt();

            String operation = "";
            double montant = 0;

            switch (choix) {
                case 1: operation = "deposer"; break;
                case 2: operation = "retirer"; break;
                case 3: operation = "consulter"; break;
                default:
                    System.out.println("Opération invalide");
                    return;
            }

            out.println(operation);  // Envoi de l'opération

            // Si l'opération nécessite un montant, demander à l'utilisateur
            if (choix == 1 || choix == 2) {
                System.out.print("Entrez le montant : ");
                montant = scanner.nextDouble();
                out.println(montant);
            }

            // Lire la réponse du serveur et l'afficher
            String response = in.readLine();
            System.out.println(response);

            socket.close();  // Fermeture de la connexion
            scanner.close(); // Fermeture du scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}