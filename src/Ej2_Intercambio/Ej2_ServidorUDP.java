package Ej2_Intercambio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {

    public static void main(String[] argv) throws Exception {
        //Recibe el mensaje(Datagrama)
        byte [] bufer = new byte[1024];

        DatagramSocket socket = new DatagramSocket(12345);

        System.out.println("Esperando datagrama...");


        try{
            DatagramPacket datagramaRecibido = new DatagramPacket(bufer , bufer.length);
            socket.receive(datagramaRecibido);
            String mensajeRecibido = new String(datagramaRecibido.getData());
            System.out.println(mensajeRecibido.trim());

            String mensajeDeConfirmacion = "Mensaje recibido correctamente";

            bufer = mensajeDeConfirmacion.getBytes();
            DatagramPacket datagramaEnviado = new DatagramPacket(bufer, bufer.length);

            socket.send(datagramaEnviado);

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
