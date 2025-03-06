import java.rmi.Naming;
public class Client {
    public static void main( String [ ] args ) throws Exception {
        Callback obj = new Callback ( ) ; /* création de l’objet callback (de type Remote)*/
        InterfaceServer serv = (InterfaceServer) Naming.lookup ("Server");
        System.out.println ("Début de l’appel");
        serv.replycallBack (obj); /* RMI classique */
    }
}