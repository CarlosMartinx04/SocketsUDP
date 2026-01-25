package Ej3_MulticastServer;

import java.io.IOException;
import java.net.*;
import java.time.LocalTime;
import java.util.Scanner;


//Hice este ejercicio con multicast cuando podia haberlo hecho con sockets pero cumple con su funcionamiento
//public class MulticastServer {
//    public static void main(String args[]) throws Exception {
//        // Enviamos la información introducida por teclado hasta que se envíe un *
//        Scanner sc = new Scanner(System.in);
//        int puerto = 12345;
//
//        //Se crea el socket multicast.
//        MulticastSocket ms = new MulticastSocket(puerto);
//        // Se escoge un puerto para el server
//        // Se escoge una dirección para el grupo
//        InetAddress grupoMulticast = InetAddress.getByName("225.0.0.1");
//        ms.joinGroup(grupoMulticast);
//        String cadena = "";
//        while (!cadena.trim().equals("*")) {
//            // El buffer se crea dentro del bucle para que se sobrescriba
//            // con cada nuevo mensaje
//            byte[] buf = new byte[1000];
//            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
//            //Recibe el paquete del servidor multicast
//            ms.receive(paquete);
//            cadena = new String(paquete.getData());
//
//            System.out.println("Recibo: " + cadena.trim());
//        }
//        ms.leaveGroup(grupoMulticast);
//        // Cerramos recursos
//        ms.close();
//        System.out.println("Socket cerrado...");
//    }
//}


public class MulticastServer {
    public static void main(String[] args) throws IOException {
        LocalTime currentTime = LocalTime.now();
        int puerto = 12345;
        byte[] buffer = new byte[1024];
        InetAddress destino = InetAddress.getLocalHost();

        DatagramSocket socketServidor = new DatagramSocket(puerto);
        DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
        String cadena = "";
        while(true){
            socketServidor.receive(paqueteRecibido);
            cadena = new String(paqueteRecibido.getData()).trim();
            System.out.println("Puerto: "+paqueteRecibido.getPort()+", "+"Mensaje: "+cadena);
        }

    }
}