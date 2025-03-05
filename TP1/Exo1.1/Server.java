import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7777);
            System.out.println("Serveur en attente de connexion...");

            Socket sock = server.accept();
            System.out.println("Client connecté !");

            DataInputStream input = new DataInputStream(sock.getInputStream());
            DataOutputStream output = new DataOutputStream(sock.getOutputStream());

            int nbre = input.readInt();
            System.out.println("Nombre reçu : " + nbre);

            int result = nbre * 10;
            output.writeInt(result);

            System.out.println("Résultat envoyé : " + result);

            sock.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
