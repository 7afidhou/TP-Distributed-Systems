package EXO4;

import java.rmi.Naming;


public class CalculStub {
    private Calcul calcul;

    public CalculStub(String serverAddress) {
        try {
            calcul = (Calcul) Naming.lookup("//" + serverAddress + "/CalculService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public int add(int a, int b) {
        try { return calcul.add(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }

    public int sub(int a, int b) {
        try { return calcul.sub(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }

    public int mul(int a, int b) {
        try { return calcul.mul(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }

    public int div(int a, int b) {
        try { return calcul.div(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }

    public int mod(int a, int b) {
        try { return calcul.mod(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }








    public float add(float a, float b) {
        try { return calcul.add(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }

    public float sub(float a, float b) {
        try { return calcul.sub(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }

    public float mul(float a, float b) {
        try { return calcul.mul(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }

    public float div(float a, float b) {
        try { return calcul.div(a, b); } catch (Exception e) { e.printStackTrace(); return 0; }
    }
}
