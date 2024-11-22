package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

public class HttpClientTravauxAPI {
    private static final String BASE_URL = "https://donnees.montreal.ca/api/3/action/datastore_search";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpClientTravauxAPI() {
    }

    public ApiResponse getData(String resourceId) {
        try {
            String encodedResourceId = URLEncoder.encode(resourceId, StandardCharsets.UTF_8);
            URI uri = new URI("https://donnees.montreal.ca/api/3/action/datastore_search?resource_id=" + encodedResourceId);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).header("Accept", "application/json").GET().build();
            HttpResponse<String> response = this.client.send(request, BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return new ApiResponse(response.statusCode(), "OK", (String)response.body());
            } else {
                System.out.println("Error: " + response.statusCode());
                return null;
            }
        } catch (InterruptedException | URISyntaxException | IOException var6) {
            return new ApiResponse(500, "Internal Server Error", "Exception occurred: " + var6.getMessage());
        }
    }
}
