package edu.nu.csc440.mysimplehttpserver20210525;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Set;

/**
 * This is the simple handler for the demo1 context.
 * @author omt
 */
public class MyHandler implements HttpHandler {
    static int cntr = 0;
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        cntr++;
        System.out.println("Hey, we got the request # " + cntr + " at " + new Date());
        HttpContext ctx = exchange.getHttpContext();
        Headers headers = exchange.getRequestHeaders();
        Set<String> keys = headers.keySet();
        OutputStream output = exchange.getResponseBody();
        String response = "Req # " + cntr + " at " + new Date();
        
        // Let's see the header values...
        keys.stream().forEach(key -> {
            System.out.println(" * key: " + key + " val: " + headers.getFirst(key));
        });
        
        exchange.sendResponseHeaders(200, response.length());
        output.write(response.getBytes());
        output.flush();
        output.close();
    }
}
