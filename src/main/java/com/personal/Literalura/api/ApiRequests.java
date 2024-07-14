package com.personal.Literalura.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiRequests {

    private Logger log = LoggerFactory.getLogger(ApiRequests.class);
    private HttpClient httpClient;

    public ApiRequests() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getBookByName(String name) {
        String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://gutendex.com/books/?search=" + encodedName))
                .build();
        String res = this.httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
        return res;
    }
}
