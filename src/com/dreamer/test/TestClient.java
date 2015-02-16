package com.dreamer.test;

import com.dreamer.client.HttpClient;
import org.json.JSONObject;

/**
 * Created by Shishkov A.V. on 2/13/15.
 */
public class TestClient {
    public static void main(String[] args) throws Exception {
        JSONObject json = new JSONObject();
        json.put("documentCode", 1);

        HttpClient client = new HttpClient("http://localhost:8080", 8080, json);
        client.sendPost();
    }
}
