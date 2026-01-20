package Ej3_MulticastServer;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastClient {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        //Se crea el socket multicast
        // El puerto debe ser el mismo en todos los clientes, ya que el
        // servidor multicast envía la información a la IP multicast y a un puerto
        int puerto = 12345;//Puerto multicast
        MulticastSocket ms = new MulticastSocket(puerto);
        //Nos unimos al grupo multicast
        InetAddress grupo = InetAddress.getByName("225.0.0.1");

        System.out.print("Datos a enviar al grupo: ");
        String cadena = sc.nextLine();
        // Enviamos el mensaje a todos los clientes que se hayan unido al grupo
        DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
        ms.send(paquete);
        // Abandonamos grupo
        // Cerramos recursos
        ms.close();
        System.out.println("Cliente cerrado...");
    }
}