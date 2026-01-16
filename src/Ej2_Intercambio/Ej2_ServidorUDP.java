package Ej2_Intercambio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ej2_ServidorUDP {

    public static void main(String[] argv) throws Exception {
        //Recibe el mensaje(Datagrama)
        byte [] buffer = new byte[1024];
        InetAddress destino = InetAddress.getLocalHost();
        //PUERTO AL QUE VA A IR EL MENSAJE
        int port = 12346;


        DatagramSocket socketServidor = new DatagramSocket(12345);

        System.out.println("Esperando datagrama");

        //Objeto que almacenara el mensaje
        DatagramPacket datagramaRecibido = new DatagramPacket(buffer, buffer.length);
        //Aqui se recibe el "mensaje" y lo guarda en daragramaRecibido
        socketServidor.receive(datagramaRecibido);
        //Convertimos el datagrama a string
        String mensajeRecibido = new String(datagramaRecibido.getData());
        //Mostramos en pantalla el mensaje recibido
        System.out.println(datagramaRecibido.getPort()+": "+mensajeRecibido.trim());

        String mensajeEnviado = "Servidor "+destino+": Mensaje recibido";
        //Convertimos el string de mensajeEnviado a bytes
        buffer = mensajeEnviado.getBytes();
        //Ahora lo convertimos a datagrama
        DatagramPacket datagramaEnviado = new DatagramPacket(buffer, buffer.length, destino, port );
        //Ahora el servidor enviara el DATAGRAMA al cliente
        socketServidor.send(datagramaEnviado);
        socketServidor.close();


    }

}
