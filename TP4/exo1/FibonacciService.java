package exo1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FibonacciService extends Remote {
    List<Long> getFibonacci(int n) throws RemoteException;
}
