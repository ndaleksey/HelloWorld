package com.dreamer.server;

import com.sun.jndi.toolkit.url.Uri;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shishkov A.V. on 2/11/15.
 */
public class HttpServer implements Runnable {
    InputStream in;
    OutputStream out;
    ServerSocket serverSocket;
    Runnable thread;

    public HttpServer() throws Exception {
        this(8080);
    }

    public HttpServer(int port) throws Exception {
        serverSocket = new ServerSocket(port);
    }

    private void sendResponse() throws IOException {
        String content = "APU Server is listening now!";

        String response = String.format("HTTP/1.1 200 OK\r\n" +
                "Server: APUServer/%s\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: %d\r\n" +
                "Connection: close\r\n\r\n" +
                content, new SimpleDateFormat("dd-MM-YY").format(new Date()), content.length());

        out.write(response.getBytes());
        out.flush();
    }

    private void readRequests() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String request;

//        URL url = new URL()

        while ((request = reader.readLine()) != null && request.trim().length() > 0) {
            /*if (request.contains("GET")) {
                parseUri(request);
            }*/

            System.out.println(request);
        }
    }

    private void parseUri(String request) throws Exception {

        int from = request.indexOf(" ");
        int till = request.indexOf(" ", from + 1);
        String url = request.substring(from + 1, till);

        System.out.printf("from = %d\n", from);
        System.out.printf("till = %d\n", till);
        System.out.printf("url = %s\n", url);
        System.exit(-1);

        Uri uri = new Uri(url);
//        parseUri();

    }

    private static void parseUri(URI uri) {
        System.out.printf("Scheme:\t%s\n", uri.getScheme());
        System.out.printf("Scheme-specific part:\t%s\n", uri.getSchemeSpecificPart());
        System.out.printf("Authority:\t%s\n", uri.getAuthority());
        System.out.printf("UserInfo:\t%s\n", uri.getUserInfo());
        System.out.printf("Host:\t%s\n", uri.getHost());
        System.out.printf("Port:\t%s\n", uri.getPort());
        System.out.printf("Path:\t%s\n", uri.getPath());
        System.out.printf("Query:\t%s\n", uri.getQuery());
        System.out.printf("Fragment:\t%s\n", uri.getFragment());
        System.out.println();
    }

    @Override
    public void run() {
        System.out.println("Server is listening now:\r\n");

        try {
            while (true) {
                Socket socket = serverSocket.accept();

                in = socket.getInputStream();
                out = socket.getOutputStream();

                readRequests();
                System.out.println();
                sendResponse();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
