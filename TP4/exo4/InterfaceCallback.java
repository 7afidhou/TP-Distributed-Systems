import java.rmi.Remote ;
import java.rmi.RemoteException ;
public interface InterfaceCallback extends Remote {
    public void doCallback (String chaine) throws RemoteException;
}