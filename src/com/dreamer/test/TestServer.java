package com.dreamer.test;

import com.dreamer.server.HttpServer;

/**
 * Created by Shishkov A.V. on 2/13/15.
 */
public class TestServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer();
        server.run();
    }
}
