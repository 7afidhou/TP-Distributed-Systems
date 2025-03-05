package exo3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TriangleServiceImpl extends UnicastRemoteObject implements TriangleService {

    protected TriangleServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<String> drawTriangleA(int lines) throws RemoteException {
        List<String> triangle = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            int stars = 2 * i + 1; // Nombre d'étoiles par ligne
            int spaces = lines - i - 1; // Espaces avant les étoiles
            triangle.add(" ".repeat(spaces) + "*".repeat(stars));
        }
        return triangle;
    }

    @Override
    public List<String> drawTriangleB(int lines) throws RemoteException {
        List<String> triangle = new ArrayList<>();
        for (int i = lines - 1; i >= 0; i--) {
            int stars = 2 * i + 1; // Nombre d'étoiles par ligne
            int spaces = lines - i - 1; // Espaces avant les étoiles
            triangle.add(" ".repeat(spaces) + "*".repeat(stars));
        }
        return triangle;
    }
}
