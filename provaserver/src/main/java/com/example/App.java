package com.example;

import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(3000);
        for (;;) {
            Socket s = ss.accept();
            MioThread t = new MioThread(s);
            t.start();
        }
        //ss.close();
    }
}
