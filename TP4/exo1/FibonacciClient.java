package exo1;
import java.rmi.Naming;
import java.util.List;

public class FibonacciClient {
    public static void main(String[] args) {
        try {
            FibonacciService service = (FibonacciService) Naming.lookup("rmi://localhost/FibonacciService");

            // Call remote method
            List<Long> fibonacciList = service.getFibonacci(20);
            System.out.println("🟢 First 20 Fibonacci numbers (Recursive):");
            for (Long num : fibonacciList) {
                System.out.println("U"+fibonacciList.indexOf(num)+"="+fibonacciList.get(fibonacciList.indexOf(num)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}