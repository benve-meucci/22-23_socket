package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(3000);
        for (;;) {
            Socket s = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String str = in.readLine();
            out.writeBytes(str.toUpperCase() + "\n");
            s.close();
        }
        //ss.close();

    }
}
