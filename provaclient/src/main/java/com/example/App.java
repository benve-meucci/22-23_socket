package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3000);

        // buffer input da tastiera
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        // buffer input dal socket
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        do {
            System.out.println("Inserisci il messaggio:");
            String stringaUtente = tastiera.readLine();
            out.writeBytes(stringaUtente + "\n");
            String str = in.readLine();
            System.out.println("Server ha inviato: " + str);
        } while (true);
    }
}
