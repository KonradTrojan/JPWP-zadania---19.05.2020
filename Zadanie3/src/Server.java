import java.io.*;
import java.net.*;

class Server
{
    public static void main(String args[])throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        while(true)
        {
           //Uzupełnij pętle tak aby serwer zwracał wiadomość wysłaną przez klienta
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            receiveData = receivePacket.getData();
            String newMessage = new String(receiveData, 0, receivePacket.getLength());

            newMessage = newMessage.toUpperCase();
            newMessage = newMessage + "!";
            sendData = newMessage.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);
        }
    }
}