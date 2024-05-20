/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Wahid
 */

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class server {
    static ServerSocket server;
    static Socket client;
    static boolean signal = false;

    public server (){
          try {
            System.out.println("Loading n Waitting");
           JOptionPane.showMessageDialog(null,"Server Activated");
            server = new ServerSocket(Parameter.PORT);
            signal = true;
        } catch (Exception ex) {
            signal = false;
        }

        if (signal == true) {
            new getConnection("RunServer");

        }

    }
  

    public static class getConnection implements Runnable {

        Thread t;

        getConnection(String imeNiti) {
            t = new Thread(this, imeNiti);
            t.start();
        }

        public void run() {
            while (true) {
                try {

                    try {

                        client = server.accept();
                        System.out.println("Client Access.....");
                    } catch (Exception ex) {
                        break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
