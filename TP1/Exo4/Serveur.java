//package Exo4;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Serveur {
    private static Joueur[] joueurs = {
            new Joueur(7, "Mahrez", 34, "Ailier droit"),
            new Joueur(10, "Pogba", 32, "Milieu"),
            new Joueur(7, "Ronaldo ", 40, "Attaquant" ),
            new Joueur(30, "Messi ", 38, "Attaquant"),
            new Joueur(9, "Benzema", 38, "Attaquant"),
            new Joueur(30, "Neuer", 39, "Gardien")
    };

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Serveur en attente de connexions...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connecté !");
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String request = input.readLine();

            List<Joueur> result = new ArrayList<>();

            try {
                int ageOrNumber = Integer.parseInt(request);
                for (Joueur j : joueurs) {
                    if (j.getAge() == ageOrNumber || j.getNumero() == ageOrNumber) {
                        result.add(j);
                    }
                }
            } catch (NumberFormatException e) {
                for (Joueur j : joueurs) {
                    if (j.getPoste().equalsIgnoreCase(request)) {
                        result.add(j);
                    }
                }
            }

            if (result.isEmpty()) {
                output.println("Aucun joueur trouvé.");
            } else {
                for (Joueur j : result) {
                    output.println(j);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}