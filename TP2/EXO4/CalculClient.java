package EXO4;

public class CalculClient {
    public static void main(String[] args) {
        CalculStub stub = new CalculStub("localhost");
        float a = 10.5f, b = 5.5f;
        System.out.println("Addition : " + stub.add(a, b));
        System.out.println("Soustraction : " + stub.sub(a, b));
        System.out.println("Multiplication : " + stub.mul(a, b));
        System.out.println("Division : " + stub.div(a, b));
        //System.out.println("Modulo : " + stub.mod(a, b));
    }
}
