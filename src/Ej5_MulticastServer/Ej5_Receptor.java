package Ej5_MulticastServer;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Ej5_Receptor {
    public static void main(String args[]) throws Exception {
        //Se crea el socket multicast
        // El puerto debe ser el mismo en todos los clientes, ya que el
        // servidor multicast envía la información a la IP multicast y aun puerto
        int puerto = 4446;//Puerto multicast
        MulticastSocket ms = new MulticastSocket(puerto);
        //Nos unimos al grupo multicast
        InetAddress grupo = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(grupo);
        String msg = "";
        while (!msg.trim().equals("*")) {
            // El buffer se crea dentro del bucle para que se sobrescriba
            // con cada nuevo mensaje
            byte[] buf = new byte[1000];
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            //Recibe el paquete del servidor multicast
            ms.receive(paquete);
            msg = new String(paquete.getData());
            System.out.println("Recibo: " + msg.trim());
        }
        // Abandonamos grupo
        ms.leaveGroup(grupo);
        // Cerramos recursos
        ms.close();
        System.out.println("Socket cerrado...");
    }
}
