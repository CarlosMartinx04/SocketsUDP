package Ej4_consultaHoraria;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej4_ClienteReloj {
    public static void main(String[] args) throws IOException {

        byte[] buffer = new byte[1024];
        Scanner sc = new Scanner(System.in);
        int puerto = 12345;

        MulticastSocket multicastSocket = new MulticastSocket(puerto);
        InetAddress grupoMulticast = InetAddress.getByName("225.0.0.1");

        multicastSocket.joinGroup(grupoMulticast);
        System.out.println("Escribe HORA para saber la hora actual.");
        String peticion = sc.next();

        DatagramPacket paquete = new DatagramPacket(peticion.getBytes(), peticion.length(), grupoMulticast, puerto);




    }
}
