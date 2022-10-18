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
            for (;;) {
                String str = in.readLine();
                if (str.equals("FINE")) {
                    System.out.println(whoami() + "Il client ha chiesto di chiudere la connessione");
                    s.close();
                    break;
                } else {
                    System.out.println(whoami() + "ricevuto " + str);
                    out.writeBytes(str.toUpperCase() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println(whoami() + e.getMessage());
        }
        System.out.println(whoami() + "sta terminando");
    }

    private String whoami(){
        return Thread.currentThread().getName() + ": "; 
    }
}
