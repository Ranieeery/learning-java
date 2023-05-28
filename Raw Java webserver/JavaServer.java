import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class JavaServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        String host = "localhost";

        String response = "<h1>Hello World!</h1>";
        int statusCode = 200;

        InetSocketAddress socketAddress = new InetSocketAddress(host, port);

        HttpServer httpServer = HttpServer.create(socketAddress, 0);

        httpServer.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().set("Content-Type", "text/html");
                httpExchange.sendResponseHeaders(statusCode, response.getBytes().length);
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();
            }
        });

        httpServer.start();

        System.out.println("Servidor iniciado em http://localhost:8080/");
    }
}
