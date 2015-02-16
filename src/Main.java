import java.net.InetAddress;
import java.net.URI;
import java.util.logging.Logger;

interface Showable {
    void display(String text);
}

public class Main {
    public static void main(String[] args) throws Exception {
        /*Socket socket = new Socket("www.opera.com", 80);
        System.out.println(socket);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        System.out.println(in.read());*/

        /*Showable showable = new Showable() {
            @Override
            public void display(String text) {
                System.out.println(text);
            }
        };

        showable.display("Hekko!");*/
        Logger LOG = Logger.getLogger(Main.class.getName());
        LOG.info("Hello");

        /*Uri uri = new Uri("http://tunein.com");
        URL url = new URL()
        System.out.println(uri.getHost());
        System.out.println();*/

        URI uri = new URI("http://www.tutorialspoint.com/json/json_java_example.htm");
        System.out.println(InetAddress.getByName(uri.getHost()).getHostAddress());
    }
}
