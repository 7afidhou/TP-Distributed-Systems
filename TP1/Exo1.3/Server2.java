import java.io.*;
import java.net.*;

public class Server2 {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(7777); // socket de connexion
            System.out.println("Connecte");
            Socket sock = server.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter output = new PrintWriter(sock.getOutputStream(), true);
            String mot = input.readLine();
            output.println(mot.toUpperCase());
            server.close();
        } catch (IOException e) {
        }
    }
}