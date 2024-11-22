package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientMaVille {
    private static final HttpClient client = HttpClient.newHttpClient();

    public HttpClientMaVille() {
    }

    public static HttpResponse<String> get(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Accept", "application/json").GET().build();
            return client.send(request, BodyHandlers.ofString());
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static HttpResponse<String> post(String url, String body) {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Accept", "application/json").header("Content-Type", "application/json").POST(BodyPublishers.ofString(body)).build();
            return client.send(request, BodyHandlers.ofString());
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }
}
