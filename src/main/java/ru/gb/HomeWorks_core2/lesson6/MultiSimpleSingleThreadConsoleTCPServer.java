package ru.gb.HomeWorks_core2.lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiSimpleSingleThreadConsoleTCPServer {

    private static final int PORT = 6830;
    private Thread serverThread;
    private final ArrayList <Socket> clientList = new ArrayList<>();
    private final ArrayList <Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        new MultiSimpleSingleThreadConsoleTCPServer().start();
    }

    private void start() {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            startConsoleInput();
            System.out.println("точка 1");
            waitConnection(serverSocket);
            System.out.println("точка 2");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void shutdown() throws IOException {
        if (serverThread != null && serverThread.isAlive()){
            serverThread.interrupt();
            for (Socket s: clientList) {
                s.close();
            }
            for (Thread t: threads) {
                t.interrupt();
            }
        }
        System.out.println("Server stopped.");
    }

    private void startConsoleInput() {
        serverThread = new Thread(() -> {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter you message >>>>>>");
                while(!Thread.currentThread().isInterrupted()){
                    if (br.ready()){
                        String outcome = br.readLine();
                        String serverMessage = "Message send for client: ";
                        if (!clientList.isEmpty()) {
                            for (int i = 0; i < clientList.size(); i++) { // Цикл рассылает сообщение от сервера всем из списка клиентов.
                                var outOther = new DataOutputStream(clientList.get(i).getOutputStream());
                                outOther.writeUTF("Message from server: " + outcome);
                                if (i == 0){
                                    serverMessage = serverMessage + "#" + i;
                                } else {
                                    serverMessage = serverMessage + ", #" + i;
                                }
                            }
                            System.out.println(serverMessage);
                        } else {
                            System.out.println("No client");
                        }
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        });
        serverThread.start();
    }

    private void waitConnection(ServerSocket serverSocket) throws IOException {
        System.out.println("Waiting for connection...");

        while (!serverSocket.isClosed() && !serverThread.isInterrupted()) {
            int count = clientList.size();
            clientList.add(serverSocket.accept());
            Thread thread = clientStart(count);
            thread.start();
            threads.add(thread);
            System.out.println("Client #" + count + " connected.");
        }
    }

    private Thread clientStart(int count){
        return new Thread(() -> {
            try {
                var in = new DataInputStream(clientList.get(count).getInputStream());
                var out = new DataOutputStream(clientList.get(count).getOutputStream());

                while (true){
                    String income = in.readUTF();
                    if (income.startsWith("/end")){
                        shutdown();
                        break;
                    }
                    System.out.println("Received for client #" + count + ": " + income);
                    out.writeUTF("ECHO: " + income);

                    for (int i = 0; i < clientList.size(); i++) {       // Цикл пересылает сообщение от этого клиента всем остальным из списка клиентов, цикл можно закомментировать.
                        if (i != count) {
                            var outOther = new DataOutputStream(clientList.get(i).getOutputStream());
                            outOther.writeUTF("Message from #" + count + ": " + income);
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
