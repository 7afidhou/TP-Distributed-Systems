package EXO4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calcul extends Remote {
    int add(int a, int b) throws RemoteException;
    int sub(int a, int b) throws RemoteException;
    int mul(int a, int b) throws RemoteException;
    int div(int a, int b) throws RemoteException;
    int mod(int a, int b) throws RemoteException;

    float add(float a, float b) throws RemoteException;
    float sub(float a, float b) throws RemoteException;
    float mul(float a, float b) throws RemoteException;
    float div(float a, float b) throws RemoteException;
}
