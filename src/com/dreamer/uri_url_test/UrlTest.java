package com.dreamer.uri_url_test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Shishkov A.V. on 2/11/15.
 */
public class UrlTest {
    public static void main(String[] args) throws IOException {
        URL url = UrlTest.class.getResource("UrlTest.class");
        System.out.println(url);

        try (InputStream in = url.openStream()) {
            byte buf[] = new byte[2048];
            int bytesRead = in.read(buf);

            for (int i = 0; i < buf.length; i++) {
                if (i % 2 == 0) {
                    System.out.print("\t");
                }

                if (i % 16 == 0) {
                    System.out.println();
                }

                    System.out.printf("%02x", buf[i]);
            }
        }
    }
}
