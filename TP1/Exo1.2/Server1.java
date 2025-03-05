import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class Server1 {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(7777); // socket de connexion
            System.out.println("Connecte");
            Socket sock = server.accept();
            InputStream input = sock.getInputStream();
            ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
            int nbre = input.read();
            ArrayList<Integer> multiplication = new ArrayList<>();
            for (int i = 1; i < 11; i++) {
                multiplication.add(nbre * i);
            }
            output.writeObject(multiplication);
            sock.close();
            server.close();
        } catch (IOException e) {
        }
    }
}