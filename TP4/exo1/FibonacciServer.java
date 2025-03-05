package exo1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FibonacciServer {
    public static void main(String[] args) {
        try {
            // Start the RMI registry
            LocateRegistry.createRegistry(1099);

            // Create an instance of the service and bind it
            FibonacciServiceImpl server = new FibonacciServiceImpl();
            Naming.rebind("rmi://localhost/FibonacciService", server);

            System.out.println("✅ Fibonacci RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
