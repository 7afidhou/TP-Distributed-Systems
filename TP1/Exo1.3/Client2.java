import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try {
            System.out.println("Connexion vers la machine serveur :");
            Socket client = new Socket("192.168.16.23", 7777); // socket de connexion
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            System.out.println("Saisir un mot");
            Scanner scan = new Scanner(System.in);
            String mot = scan.nextLine();
            output.println(mot);
            System.out.println("Le majuscule de" + mot + "est :" + input.readLine());
            scan.close();
            client.close();
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
}