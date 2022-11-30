package ru.gb.SpringEE.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerHello {
    public static void main(String[] args) {

    /*
    HTTP/1.1 200 OK
    Content-Type: text/html
    Connection: close
    Content-Length: 44
     */

        try(ServerSocket serverSocket = new ServerSocket(6830)){
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                String line = br.readLine();
                if (line != null){
                    System.out.println(line);
                    if (line.equals("")){
                        String output = "<html>\n<body>\n<h2>Hello</h2>\n</body>\n</html>\n";

                        socket.getOutputStream().write("HTTP/1.1 200 OK\n".getBytes());
                        socket.getOutputStream().write("Content-Type: text/html\n".getBytes());
                        socket.getOutputStream().write("Connection: close\n".getBytes());
                        socket.getOutputStream().write(("Content-Length: " + output.length() + "\n").getBytes());
                        socket.getOutputStream().write("\n".getBytes());
                        socket.getOutputStream().write(output.getBytes());
                        socket.getOutputStream().write("\n".getBytes());
                        break;
                    }
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
