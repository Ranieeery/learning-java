import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class JavaServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        String host = "localhost";

        String response = "Starting server on port " + port + "...\r\n" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<h1>Hello World!</h1>";

        InetSocketAddress socketAddress = new InetSocketAddress(host, port);

        HttpServer httpServer = HttpServer.create(socketAddress , 0);

        httpServer.createContext("/", httpExchange -> {
            httpExchange.getResponseHeaders().set("Content-Type", "text/plain");
            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            httpExchange.getResponseBody().write(response.getBytes());
            httpExchange.close();
        });

        System.out.println("Servidor iniciado em http://localhost:8080/");

    }
}
