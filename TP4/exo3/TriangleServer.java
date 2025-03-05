package exo3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TriangleServer {
    public static void main(String[] args) {
        try {
            // Démarrer le registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);

            // Créer et enregistrer l’objet distant
            TriangleServiceImpl server = new TriangleServiceImpl();
            Naming.rebind("rmi://localhost/TriangleService", server);

            System.out.println("✅ Serveur RMI Triangle en cours d'exécution...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
