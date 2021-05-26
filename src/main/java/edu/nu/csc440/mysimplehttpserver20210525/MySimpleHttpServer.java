package edu.nu.csc440.mysimplehttpserver20210525;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

/**
 * Here comes my very simple HTTP server :)
 *
 * @author omt
 */
public class MySimpleHttpServer {

    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        try {
            System.out.println("HTTP Server Demo1 (25 May 2021/Tue)");
            int portNo = 9100;
            int backlog = 0;
            String host = "0.0.0.0";
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(host, portNo), backlog);
            
            server.createContext("/demo1", new MyHandler());
            server.start();
            System.out.println("Server is starting at " + portNo);
        } catch (Exception ex) {
            System.out.println("Opps! " + ex.getMessage());
        }
    }
}
