import HelloApp.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;


public class HelloServer {
    public static void main(String args[]) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA and activate the POA manager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create and register the Hello servant
            HelloImpl helloImpl = new HelloImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Hello helloRef = HelloHelper.narrow(ref);

            // Bind the object in the CORBA Naming Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent path[] = ncRef.to_name("Hello");
            ncRef.rebind(path, helloRef);

            System.out.println("CORBA Hello Server is running...");

            // Keep server running
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
