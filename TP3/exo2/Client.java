import convertisseur.*;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {
    public static void main(String[] args) {
        try {

            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Euro";
            Euro euroRef = EuroHelper.narrow(ncRef.resolve_str(name));

            euroRef.setTaux(140.96);
            euroRef.setDevise("DZD");

            double amountInEuros = euroRef.toEuro(120.0);
            double amountInUSD = euroRef.toDevise(100.0);

            System.out.println("5000 DZD in Euros: " + amountInEuros);
            System.out.println("100 Euros in DZD: " + amountInUSD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}