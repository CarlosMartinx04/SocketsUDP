package Ej2_Intercambio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Ej2_ClienteUDP {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        InetAddress destino = InetAddress.getLocalHost();
        //PUERTO DEL SERVIDOR
        int port = 12345;
        byte[] buffer = new byte[1024];

        System.out.println("Escribe un mensaje");
        String mensajeEnviado = sc.next();
        //Convertimos el mensaje que se va a enviar a BYTES
        buffer = mensajeEnviado.getBytes();

        //Guardamos en DATAGRAMA el contenido del buffer y al destino que se va a enviar
        DatagramPacket datagramaEnviado = new DatagramPacket(buffer, buffer.length, destino, port);

        //Puerto del socket
        DatagramSocket socketCliente = new DatagramSocket(12346);
        socketCliente.send(datagramaEnviado);

        byte[] bufferEnviado = new byte[1024];
        DatagramPacket datagramaRecibido = new DatagramPacket(bufferEnviado, bufferEnviado.length);

        //El cliente va a ESPERAR un nuevo DATAGRAMA
        socketCliente.receive(datagramaRecibido);
        //Convertimos el datagrama a String
        String mensajeRecibido = new String(datagramaRecibido.getData());
        System.out.println(datagramaRecibido.getPort()+": "+mensajeRecibido.trim());

        socketCliente.close();






    }
}
