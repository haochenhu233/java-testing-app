package main;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> "Hello from Cloud Foundry!");
        get("/health", (req, res) -> {
            res.type("application/json");
            return "{\"status\":\"UP\"}";
        });
    }

    private static int getPort() {
        String port = System.getenv("PORT");
        return port != null ? Integer.parseInt(port) : 8080;
    }
}
