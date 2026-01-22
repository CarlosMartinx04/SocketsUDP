package Ej4_consultaHoraria;

import Ej3_MulticastServer.MulticastServer;

import javax.xml.crypto.Data;
import java.io.CharArrayReader;
import java.io.IOException;
import java.net.*;
import java.time.LocalTime;

public class Ej4_ServidorReloj {
    public static void main(String[] args) throws IOException {
        LocalTime currentTime = LocalTime.now();
        int puerto = 12345;
        byte[] buffer = new byte[1024];
        InetAddress destino = InetAddress.getLocalHost();

        DatagramSocket socketServidor = new DatagramSocket(puerto);
        String cadena = "";
        while (true) {
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            System.out.println("Esperando a recibir paquete...");
            socketServidor.receive(paqueteRecibido);
            cadena = new String(paqueteRecibido.getData()).trim();
            int puertoCliente = paqueteRecibido.getPort();
            System.out.println("Cadena: " + cadena + ", Puerto del cliente: " + puertoCliente);

            String mensajEnviar;
            DatagramPacket paqueteEnviado;
            if (cadena.equals("HORA")) {
                mensajEnviar = "Hora: " + currentTime;
                paqueteEnviado = new DatagramPacket(mensajEnviar.getBytes(), mensajEnviar.length(), destino, puertoCliente);
                socketServidor.send(paqueteEnviado);

            } else {
                mensajEnviar = "Comando no reconocido";
                paqueteEnviado = new DatagramPacket(mensajEnviar.getBytes(), mensajEnviar.length(), destino, puertoCliente);
                socketServidor.send(paqueteEnviado);
            }

        }



    }
}
