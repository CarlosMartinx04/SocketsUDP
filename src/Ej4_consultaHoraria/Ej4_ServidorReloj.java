package Ej4_consultaHoraria;

import Ej3_MulticastServer.MulticastServer;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.time.LocalTime;

public class Ej4_ServidorReloj {
    public static void main(String[] args) throws IOException {
        int puerto = 12345;
        LocalTime currentTime;
        MulticastSocket multicastServer = new MulticastSocket(puerto);
        InetAddress grupoMulticast = InetAddress.getByName("225.0.0.1");

        multicastServer.joinGroup(grupoMulticast);
        String cadena ="";
        while (!cadena.equals("*")){
            byte[] buffer = new byte[1024];//Se escribe dentro del bucle para que se sobreescriba con cada nuevo mensaje
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);//Crea un mensaje que va a tener que recibir
            multicastServer.receive(paqueteRecibido);//Espera a recibir el mensaje
            cadena = new String(paqueteRecibido.getData());//Vuelve el paquete a string para asi poder escribirlo por pantalla/cerrar el bucle

            DatagramPacket packeteEnviado;
            String mensaje;
            if(cadena.equals("HORA")){
                currentTime = LocalTime.now();
                mensaje = "Hora: "+currentTime;
                packeteEnviado = new DatagramPacket(mensaje.getBytes(), mensaje.length());

            } else {
                String mensajeError = "Comando no reconocido";
                packeteEnviado = new DatagramPacket();

            }

        }

        multicastServer.leaveGroup(grupoMulticast);
        multicastServer.close();

    }
}
