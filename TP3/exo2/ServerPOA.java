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

            ORB orb = ORB.init(args, null);

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            EuroPOAImpl euroServant = new EuroPOAImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(euroServant);
            Euro euroRef = EuroHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Euro";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, euroRef);

            System.out.println("Euro Server ready and waiting...");


            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}