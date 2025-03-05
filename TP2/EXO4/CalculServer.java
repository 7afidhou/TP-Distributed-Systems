package EXO4;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculServer extends UnicastRemoteObject implements Calcul {
    public CalculServer() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public int div(int a, int b) throws RemoteException {
        if (b == 0) throw new ArithmeticException("Division par zéro !");
        return a / b;
    }

    @Override
    public int mod(int a, int b) throws RemoteException {
        return a % b;
    }

    @Override
    public float add(float a, float b) throws RemoteException {
        return a + b;
    }

    @Override
    public float sub(float a, float b) throws RemoteException {
        return a - b;
    }

    @Override
    public float mul(float a, float b) throws RemoteException {
        return a * b;
    }

    @Override
    public float div(float a, float b) throws RemoteException {
        if (b == 0.0) throw new ArithmeticException("Division par zéro !");
        return a / b;
    }
}
