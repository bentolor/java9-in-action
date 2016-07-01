package de.exxcellent.java9.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import static java.lang.System.out;

public class HttpClientExample {

    /**
     * The HTTP API functions asynchronously & synchronously. In asynchronous mode,
     * work is done on the threads supplied by the client's ExecutorService.
     */
    public static void main(String[] args) throws Exception {
        HttpClient.getDefault()
                .request(URI.create("https://www.exxcellent.de"))
                .GET()
                .responseAsync() // CompletableFuture :D
                .thenAccept(httpResponse ->
                                    out.println(httpResponse.body(HttpResponse.asString()))
                );

        Thread.sleep(999); // Give worker thread some time.
    }
}