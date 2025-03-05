//package Exo2.2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

            System.out.println("Connexion au serveur...");
            Socket client = new Socket("localhost", 7777);

            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            boolean guessed = false;
            while (!guessed) {
                System.out.print("Devinez un nombre entre 1 et 100 : ");
                int guess = scanner.nextInt();
                output.println(guess);
                String response = input.readLine();
                System.out.println("Réponse du serveur : " + response);
                if (response.equals("Bravo !")) {
                    guessed = true;
                }
            }

            client.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
