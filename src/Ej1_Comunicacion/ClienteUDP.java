package Ej1_Comunicacion;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Creacion del puerto al que se envia el datagrama
        InetAddress destino = InetAddress.getLocalHost();
        //puerto al que se envia el mensaje
        int port = 12345;

        //buffer para recibir el datagrama
        byte[] buffer = new byte[1024];

        //el mensaje a enviar se convierte a byte
        String mensajeEnviado = "Enviando Mensaje";
        //Convierte de string a byte
        buffer = mensajeEnviado.getBytes();

        //Se prepara el datagrama que se va a enviar
        DatagramPacket datagramaEnviado = new DatagramPacket(buffer, buffer.length, destino, port);

        try{
            //Puerto desde el que se envia el mensaje
            DatagramSocket socket = new DatagramSocket();


            System.out.println("Host destino : " + destino.getHostName());
            System.out.println("IP Destino : " + destino.getHostAddress());
            System.out.println("Puerto local del socket: " + socket.getLocalPort());
            System.out.println("Puerto al que envio: " + datagramaEnviado.getPort());

            socket.send(datagramaEnviado);
            socket.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
