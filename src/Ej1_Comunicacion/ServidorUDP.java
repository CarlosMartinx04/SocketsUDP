package Ej1_Comunicacion;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ServidorUDP {

    public static void main(String[] argv) throws Exception {
        //Recibe el mensaje(Datagrama)
        byte [] bufer = new byte[1024];

        //socket que se asocia a un puerto para que se comunique con los clientes
        //Puerto que recibe un mensaje
        DatagramSocket socket = new DatagramSocket(12345);

        System.out.println("Esperando datagrama...");

        //Recibe el mensaje del socketCliente
        DatagramPacket datagramaRecibido = new DatagramPacket(bufer , bufer.length);

        try{
            //Se espera al mensaje
            socket.receive(datagramaRecibido);
            String mensajeRecibido = new String(datagramaRecibido.getData());

            //Informacion recibida
            System.out.println("Número de Bytes recibidos: " + datagramaRecibido.getLength());
            System.out.println("Contenido del Paquete : " + mensajeRecibido.trim());
            System.out.println("Puerto origen del mensaje: " + datagramaRecibido.getPort());
            System.out.println("IP de origen : " + datagramaRecibido.getAddress().getHostAddress());
            System.out.println("Puerto destino del mensaje:" + socket.getLocalPort());
            //Liberacion de recursos
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
