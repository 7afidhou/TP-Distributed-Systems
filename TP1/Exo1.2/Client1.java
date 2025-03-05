import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client1 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        try {
            System.out.println("Connexion vers la machine serveur :");
            Socket client = new Socket("172.20.10.9", 7777); 
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            OutputStream output = client.getOutputStream();
            System.out.println("Saisir un nombre");
            Scanner scan = new Scanner(System.in);
            int nbre = scan.nextInt();
            output.write(nbre);
            ArrayList<Integer> receivedList = (ArrayList<Integer>) input.readObject();
            System.out.println("Le resultat de multiplication de" + nbre + " jusqua 10 est :" + receivedList);
            client.close();
            scan.close();
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
}