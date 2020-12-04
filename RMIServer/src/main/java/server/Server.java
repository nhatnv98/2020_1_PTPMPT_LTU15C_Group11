package server;

import bean.Bank;
import rmi.WeatherService;

import javax.swing.*;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private static final int PORT = 8888;
    private static Registry registry;
    private JPanel panel1;

    public static void startRegistry() throws RemoteException {

        // Tạo một bộ đăng ký (Registry) tại Server.
        registry =  LocateRegistry.createRegistry(PORT);
    }

    public static void registerObject(String name, Remote remoteObj)
            throws RemoteException, AlreadyBoundException {
        // Đăng ký đối tượng vào bộ đăng ký.
        // Nó được gắn với cái tên nào đó.
        // Client sẽ tìm trên bộ đăng ký với tên này để có thể gọi đối tượng.


        registry.bind(name, remoteObj);
        System.out.println("Registered: " + name + " -> "
                + remoteObj.getClass().getName() + "[" + remoteObj + "]");
    }

//    public static void main(String[] args) throws Exception {
    public static void init()  {
        try {
        System.out.println("Server starting...");
        startRegistry();
            BannImpl impl = new BannImpl();
        registerObject(WeatherService.class.getSimpleName(), new WeatherServiceImpl());
        registerObject(Bank.class.getSimpleName(), new BannImpl());
        // Server đã được start, và đang lắng nghe các request từ Client.
        System.out.println("Server started!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
