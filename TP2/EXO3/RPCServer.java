package EXO3;

import java.io.*;
import java.net.*;

public class RPCServer {

    public String inverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }


    public boolean palindrome(String word) {
        return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
    }


    public boolean contenir(String word, String subword) {
        return word.contains(subword);
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Serveur RPC en cours d'exécution sur le port 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request = in.readLine();
                String word = in.readLine();
                String result = "";

                RPCServer server = new RPCServer();

                switch (request) {
                    case "inverse":
                        result = server.inverse(word);
                        break;
                    case "palindrome":
                        result = server.palindrome(word) ? "true" : "false";
                        break;
                    case "contenir":
                        String subword = in.readLine();
                        result = server.contenir(word, subword) ? "true" : "false";
                        break;
                    default:
                        result = "Opération non reconnue";
                }

                out.println(result);
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
