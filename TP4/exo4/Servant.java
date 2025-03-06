import java.rmi.*;

public class Servant extends Thread {
    private InterfaceCallback obj;

    public Servant(InterfaceCallback obj) {
        this.obj = obj;
    }

    public void run() {
        try {
            // Print the first message
            System.out.println("Bonjour");
            obj.doCallback("Bonjour");
            Thread.sleep(5000); // Wait 5 seconds

            // Print the second message
            System.out.println("J’utilise Java RMI");
            obj.doCallback("J’utilise Java RMI");
            Thread.sleep(5000); // Wait 5 seconds

            // Print the third message
            System.out.println("Fin");
            obj.doCallback("Fin");

        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e);
        } catch (RemoteException e) {
            System.err.println("Echec appel en retour : " + e);
        }
    }
}
