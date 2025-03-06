import java.rmi.Remote;
import java.rmi.RemoteException;
public interface InterfaceServer extends Remote {
    public void replycallBack (InterfaceCallback obj) throws RemoteException;
}