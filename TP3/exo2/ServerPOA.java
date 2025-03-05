import convertisseur.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class ServerPOA {
    public static void main(String[] args) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get reference to root POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            // Activate the POA manager
            rootPOA.the_POAManager().activate();

            // Create the servant (implementation of the Euro object)
            EuroPOAImpl euroServant = new EuroPOAImpl();

            // Get the object reference from the servant
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(euroServant);
            Euro euroRef = EuroHelper.narrow(ref);

            // Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Bind the Euro object reference in the naming service
            String name = "Euro";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, euroRef);

            System.out.println("Euro Server ready and waiting...");

            // Wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}