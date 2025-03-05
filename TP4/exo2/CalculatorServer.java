package exo2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Démarrer le registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);

            // Créer et enregistrer l’objet distant
            CalculatorServiceImpl server = new CalculatorServiceImpl();
            Naming.rebind("rmi://localhost/CalculatorService", server);

            System.out.println("✅ Serveur RMI de Calcul en cours d'exécution...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
