package Ej3_MulticastServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastClient {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje que quieras enviar al servidor: ");
        String mensaje = sc.nextLine();
        int puertoServidor = 12345;
        InetAddress destino = InetAddress.getLocalHost();
        DatagramSocket socketCliente = new DatagramSocket();
        //Convertimos el mensaje a paquete
        DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), mensaje.length(), destino,puertoServidor);
        socketCliente.send(paquete);
        socketCliente.close();

    }
}