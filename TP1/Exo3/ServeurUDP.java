import java.net.*;
import java.util.ArrayList;

class ServeurUDP {
    static byte buffer[] = new byte[1024];
    
    public static void main(String argv[]) throws Exception {
        DatagramSocket socket = new DatagramSocket(1000);
        while (true) {
            DatagramPacket data = new DatagramPacket(buffer, buffer.length);
            socket.receive(data);
            
            // Get the byte array from the received data and convert it to integers
            byte[] receivedData = data.getData();
            String receivedString = new String(receivedData, 0, data.getLength());
            String[] numberStrings = receivedString.split(",");
            ArrayList<Integer> numbers = new ArrayList<>();
            
            for (String numStr : numberStrings) {
                numbers.add(Integer.parseInt(numStr));
            }

            // Filter the even numbers
            ArrayList<Integer> evenNumbers = new ArrayList<>();
            for (Integer num : numbers) {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                }
            }

            // Convert the even numbers list back to a string and send the response
            String response = evenNumbers.toString();
            data.setData(response.getBytes());
            socket.send(data);
        }
    }
}
