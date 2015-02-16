package com.dreamer.client;

import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

/**
 * Created by Shishkov A.V. on 2/13/15.
 */
public class HttpClient {
    private JSONObject json;
    private URI uri;
    private String hostName;
    private int port;
    private Socket socket;
    private OutputStream out;

    public HttpClient(String url, int port, JSONObject json) throws URISyntaxException, IOException {
        this.json = json;
        this.uri = new URI(url);
        this.port = port;
        hostName = InetAddress.getByName(uri.getHost()).getHostName();//.getHostAddress()

        socket = new Socket(hostName, port);
        out = socket.getOutputStream();
    }

    public void sendPost() throws Exception {
        String request = String.format("GET / HTTP/1.1\r\n" +
                "Host: %s\r\n\r\n", hostName);
        out.write(request.getBytes());
        out.flush();

        /*String urlParameters = json.toString();
        URL

        // Send post request
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());*/
    }
}
