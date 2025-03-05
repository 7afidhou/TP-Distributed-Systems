import java.net.*;
import java.util.Arrays;

public class ClientUDP {
    byte buffer[] = new byte[1024];
    
    public static void main(String argv[]) throws Exception {
        InetAddress serveur = InetAddress.getByName("192.168.16.23");
        
        // Sending an array of integers as a comma-separated string
        int[] tab = {1, 5, 6, 3, 7, 11, 10, 12,18};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tab.length; i++) {
            sb.append(tab[i]);
            if (i < tab.length - 1) sb.append(",");
        }
        String mot = sb.toString();
        
        byte[] buffer = mot.getBytes();
        DatagramPacket donnerEnvoyer = new DatagramPacket(buffer, buffer.length, serveur, 1000);
        DatagramSocket socket = new DatagramSocket();
        
        // Send data to server
        socket.send(donnerEnvoyer);

        // Receive response from server
        DatagramPacket donnerRecu = new DatagramPacket(new byte[1024], 1024);
        socket.receive(donnerRecu);
        
        // Print received data (even numbers)
        System.out.println("Données reçues : " + new String(donnerRecu.getData(), 0, donnerRecu.getLength()));
        System.out.println("De : " + donnerRecu.getAddress() + ":" + donnerRecu.getPort());
    }
}
