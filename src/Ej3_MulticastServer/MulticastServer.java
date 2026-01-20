package Ej3_MulticastServer;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastServer {
    public static void main(String args[]) throws Exception {
        // Enviamos la información introducida por teclado hasta que se envíe un *
        Scanner sc = new Scanner(System.in);
        int puerto = 12345;

        //Se crea el socket multicast.
        MulticastSocket ms = new MulticastSocket(puerto);
        // Se escoge un puerto para el server
        // Se escoge una dirección para el grupo
        InetAddress grupoMulticast = InetAddress.getByName("225.0.0.1");
        ms.joinGroup(grupoMulticast);
        String cadena = "";
        while (!cadena.trim().equals("*")) {
            // El buffer se crea dentro del bucle para que se sobrescriba
            // con cada nuevo mensaje
            byte[] buf = new byte[1000];
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            //Recibe el paquete del servidor multicast
            ms.receive(paquete);
            cadena = new String(paquete.getData());

            System.out.println("Recibo: " + cadena.trim());
        }
        ms.leaveGroup(grupoMulticast);
        // Cerramos recursos
        ms.close();
        System.out.println("Socket cerrado...");
    }
}