package client;

import rmi.Constants;
import rmi.WeatherData;
import rmi.WeatherService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class Client {

    // Host or IP of Server
    private static final String HOST = "localhost";
    private static final int PORT = 8888;
    private static Registry registry;

    public static void main(String[] args) throws Exception {

        
        registry = LocateRegistry.getRegistry(HOST, PORT);

                WeatherService service = (WeatherService) registry
                .lookup(WeatherService.class.getSimpleName());

        Date today = new Date();


    }
}
