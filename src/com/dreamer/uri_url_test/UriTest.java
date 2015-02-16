package com.dreamer.uri_url_test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Shishkov A.V. on 2/11/15.
 */
public class UriTest {
    public static void main(String[] args) throws URISyntaxException {
        parseUri(new URI("mailto:test@yandex.ru"));
        parseUri(new URI("http://yandex.ru"));
        parseUri(new URI("http://www.youtube.com/watch?v=gPyXdyUVPNw"));
        parseUri(new URI("http://yandex.ru/yandsearch?text=%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BD%D0%B0%20%D1%8F%D0%B2%D0%B5&from=os&clid=1836588"));
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
}
