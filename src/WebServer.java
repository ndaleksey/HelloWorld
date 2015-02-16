import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Shishkov A.V. on 2/6/15.
 */
class PageGenerator {
    ServerSocket serverSocket;

    public PageGenerator() throws IOException {
        serverSocket = new ServerSocket(8080);
    }

    public void generate() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            makePage(socket);
        }
    }

    private void makePage(Socket socket) throws IOException {
        String htmlBody =
                "<html>" +
                    "<head>" +
                        "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>" +
                    "</head>" +
                    "<body>" +
                        "<h1>Добро пожаловать на мой сервачок, гости дорогие! Welcome, так сказать!!!!!!!!!!!!!!!!</h1>" +
                    "</body>" +
                "</html>";

//        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        OutputStream out = socket.getOutputStream();

        String response = "HTTP/1.1 404 OK\r\n" +
                "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + (htmlBody.length() + 10) + "\r\n" +
                "Connection: close\r\n\r\n";
//        out.writeUTF(response + htmlBody);
        String result = response + htmlBody;
        out.write(result.getBytes());
        out.flush();
    }
}

public class WebServer {
    public static void main(String[] args) {
        Runnable thread = new Runnable(){
            @Override
            public void run() {
                try {
                    new PageGenerator().generate();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.run();
    }

    /*public static void serve() {

    }*/
}
