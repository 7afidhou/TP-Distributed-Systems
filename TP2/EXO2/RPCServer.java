package EXO2;

import java.io.*;
import java.net.*;

public class RPCServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Serveur RPC en cours d'exécution sur le port 8080...");

            // Création d'un compte initial
            Compte compte = new Compte(12345, 1000); // Numéro de compte 12345 avec un solde initial de 1000€

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request = in.readLine();

                // Traitement de la demande
                if (request.equals("deposer")) {
                    double montant = Double.parseDouble(in.readLine());
                    compte.deposer(montant);
                    out.println("Déposé avec succès");
                } else if (request.equals("retirer")) {
                    double montant = Double.parseDouble(in.readLine());
                    compte.retirer(montant);
                    out.println("Retrait effectué");
                } else if (request.equals("consulter")) {
                    out.println("Solde actuel : " + compte.consulter() + "€");
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}