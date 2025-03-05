import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7777); 
            System.out.println("Serveur en attente de connexions...");
            Random rand=new Random();
            int secretNumber = rand.nextInt(100) + 1;
            while (true) {
                Socket sock = server.accept(); 
                System.out.println("Nouveau client connecté !");
                new ClientHandler(sock,secretNumber).start(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Classe gérant chaque client individuellement
class ClientHandler extends Thread {
    private Socket sock;
    private BufferedReader input;
    private PrintWriter output;
    private int secretNumber;

    public ClientHandler(Socket sock,Integer secretNumber) {
        this.sock = sock;
        try {
            input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            output = new PrintWriter(sock.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
