package exo1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class FibonacciServiceImpl extends UnicastRemoteObject implements FibonacciService {

    protected FibonacciServiceImpl() throws RemoteException {
        super();
    }

    private long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    @Override
    public List<Long> getFibonacci(int n) throws RemoteException {
        List<Long> fibonacci = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fibonacci.add(fibonacci(i));  // Recursive call
        }
        return fibonacci;
    }
}
