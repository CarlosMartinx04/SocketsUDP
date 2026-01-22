package Ej4_consultaHoraria;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Ej4_ClienteReloj {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int puertoServidor = 12345;
        InetAddress destino = InetAddress.getLocalHost();
        byte[] buffer = new byte[1024];

        System.out.println("Escibre HORA para recibir la hora actual");
        String mensaje = sc.next();
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), mensaje.length(), destino, puertoServidor);
        socket.send(paquete);


        DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
        socket.receive(paqueteRecibido);
        String mensajeRecibido = new String(paqueteRecibido.getData()).trim();
        System.out.println(mensajeRecibido);

        socket.close();
        System.out.println("Socker cerrado.");
    }
}
