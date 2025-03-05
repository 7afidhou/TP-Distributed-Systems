package EXO4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculSkeleton {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Démarrer le registre RMI
            CalculServer server = new CalculServer(); // Créer une instance du serveur
            Naming.rebind("CalculService", server); // Enregistrer l'objet dans RMI
            System.out.println("✅ Serveur RPC démarré sur le port 1099 !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

