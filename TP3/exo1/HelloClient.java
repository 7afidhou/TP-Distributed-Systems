import HelloApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class HelloClient {
    public static void main(String args[]) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get reference to Naming Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Look up the Hello object
            Hello hello = HelloHelper.narrow(ncRef.resolve_str("Hello"));

            // Call the sayHello() method
            System.out.println("Server says: " + hello.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
