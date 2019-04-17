/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ehs
 */
public class Chat {
    public static void main(String a[]) throws  Exception{
        String host="";
        int port=0;
        String im ="";
        int serverPort = 2222;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Server started Listening on port "+serverPort+".......");
        new ChatServer(serverPort);
        while(true){
            if(host.equals("")){
                System.out.print("Enter cool name: ");
                im = keyboard.nextLine();
                System.out.print("Enter Host to chat with: ");
                host = keyboard.nextLine();
                System.out.print("Enter Port to chat with: ");
                port = keyboard.nextInt();
            }
        String msg = im+": "+keyboard.nextLine();
        send(msg,host, port);
        }
    }
    public static void send(String msg, String rhost, int rport) throws Exception {
        Socket client = new Socket(rhost, rport);
        OutputStream os = client.getOutputStream();
        os.write(msg.getBytes());
        client.close();
    }
}
class ChatServer implements Runnable{
    int port =0;
    public ChatServer(int port) {
        this.port = port;
        Thread t = new Thread(this);
        t.start();
    }

    public void run(){
        receive();
    }
    public void receive()  {
        try{



        ServerSocket server = new ServerSocket(port);
        
        while (true) {
            Socket client = server.accept();
            InputStream is = client.getInputStream();
            int c;
            String msg = "";
            while ((c = is.read()) != -1) {
                msg += (char) c;
            }
            System.out.println(msg);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}