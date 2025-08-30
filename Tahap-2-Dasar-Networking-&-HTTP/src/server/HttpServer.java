package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server berjalan di http://localhost:" + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
           String requestLine = in.readLine();
           if (requestLine == null || requestLine.isEmpty()) {
                clientSocket.close();
                return;
           } 
           System.out.println("Request: " + requestLine);

           String path = "/";
           String[] parts = requestLine.split(" ");
           if (parts.length >= 2) {
            path = parts[1];
           }

           String responseBody;
           if (path.equals("/index") || path.equals("/")) {
                responseBody = "<html><body><h1>Halaman Index</h1><p>Selamat datang di index!</p></body></html>";
            } else if (path.equals("/about")) {
                responseBody = "<html><body><h1>Tentang Kami</h1><p>Ini adalah halaman about.</p></body></html>";
            } else {
                responseBody = "<html><body><h1>404</h1><p>Halaman tidak ditemukan.</p></body></html>";
            }

            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: " + responseBody.getBytes().length + "\r\n" +
                    "\r\n" +
                    responseBody;

            out.write(response);
            out.flush();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
