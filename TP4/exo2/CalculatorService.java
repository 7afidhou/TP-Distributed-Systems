package exo2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorService extends Remote {
    int add(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
    double divide(int a, int b) throws RemoteException;
}
