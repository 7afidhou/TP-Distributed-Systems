package exo3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TriangleService extends Remote {
    List<String> drawTriangleA(int lines) throws RemoteException;
    List<String> drawTriangleB(int lines) throws RemoteException;
}
