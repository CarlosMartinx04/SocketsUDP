package Ej2_Intercambio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;

        byte[] buffer = new byte[1024];

        System.out.println("Escibe el mensaje que quieres enviar");
        String mensajeEnviado = Arrays.toString(sc.next().toCharArray());
        buffer = mensajeEnviado.getBytes();

        DatagramPacket datagramaEnviado = new DatagramPacket(buffer, buffer.length, destino, port);

        try{
            DatagramSocket socket = new DatagramSocket();
            socket.send(datagramaEnviado);

            DatagramPacket datagramaRecibido = new DatagramPacket(buffer, buffer.length);
            socket.receive(datagramaRecibido);
            String mensajeRecibido = new String(datagramaRecibido.getData());

            System.out.println(mensajeRecibido.trim());

            socket.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
