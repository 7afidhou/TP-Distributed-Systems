package EXO1;

import java.io.*;
import java.net.*;

public class RPCClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // User input for selecting operation
            System.out.println("Choisissez l'opération (multiplication, addition, subtraction, division):");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String operation = reader.readLine();

            System.out.println("Entrez le premier nombre:");
            int a = Integer.parseInt(reader.readLine());
            System.out.println("Entrez le deuxième nombre:");
            int b = Integer.parseInt(reader.readLine());


            out.println(operation);
            out.println(a);
            out.println(b);


            int result = Integer.parseInt(in.readLine());
            System.out.println("Résultat de " + operation + " : " + result);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
