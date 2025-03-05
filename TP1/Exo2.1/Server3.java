import java.io.*;
import java.net.*;
import java.util.Random;

public class Server3 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7777); // Démarrage du serveur sur le port 7777
            System.out.println("Serveur en attente d'une connexion...");

            Socket sock = server.accept(); 
            System.out.println("Client connecté!");

            // Création des flux de communication
            BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter output = new PrintWriter(sock.getOutputStream(), true);

            Random rand = new Random();
            int secretNumber = rand.nextInt(100) + 1;
            System.out.println("Le nombre secret est : " + secretNumber);

            boolean guessed = false;
            while (!guessed) {
                int guess = Integer.parseInt(input.readLine());
                System.out.println("Client a deviné : " + guess);

                if (guess < secretNumber) {
                    output.println("Plus grand");
                } else if (guess > secretNumber) {
                    output.println("Plus petit");
                } else {
                    output.println("Bravo !");
                    guessed = true;
                }
            }

            sock.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
