package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread {
    Socket s;
    public MioThread(Socket s) {
        this.s = s;
    }
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String str = in.readLine();
            out.writeBytes(str.toUpperCase() + "\n");
            s.close();
        } catch (Exception e) {}
    }
}
