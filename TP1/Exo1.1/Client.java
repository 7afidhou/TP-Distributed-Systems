import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Connexion au serveur...");
            Socket client = new Socket("localhost", 7777); // Connexion au serveur

            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            Scanner scan = new Scanner(System.in);
            System.out.print("Saisir un nombre : ");
            int nbre = scan.nextInt();

            output.write(nbre); 
            int result = input.read(); 

            System.out.println("Le resultat de " + nbre + " × 10 est : " + result);

            scan.close();
            client.close();
        } catch (UnknownHostException e) {
            System.err.println("Hôte inconnu.");
        } catch (IOException e) {
            System.err.println("Erreur d'entrée/sortie : " + e.getMessage());
        }
    }
}
