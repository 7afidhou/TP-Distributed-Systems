package EXO1;

import java.io.*;
import java.net.*;

public class RPCServer {
    public int multiplication(int a, int b) {
        return a * b;
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            return Integer.MIN_VALUE;
        }
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

                int a = Integer.parseInt(in.readLine());
                int b = Integer.parseInt(in.readLine());
                int result = 0;

                switch (request) {
                    case "multiplication":
                        result = new RPCServer().multiplication(a, b);
                        break;
                    case "addition":
                        result = new RPCServer().addition(a, b);
                        break;
                    case "subtraction":
                        result = new RPCServer().subtraction(a, b);
                        break;
                    case "division":
                        result = new RPCServer().division(a, b);
                        break;
                    default:
                        out.println("Opération non reconnue");
                        clientSocket.close();
                        continue;
                }

                out.println(result);
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
