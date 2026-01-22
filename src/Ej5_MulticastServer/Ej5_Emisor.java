package Ej5_MulticastServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class Ej5_Emisor {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int puerto = 4446;//Puerto del servidor
        System.out.println("Escribe un mensaje para enviar al grupo.");
        MulticastSocket ms = new MulticastSocket();
        InetAddress grupo = InetAddress.getByName("230.0.0.1");


    }
}
