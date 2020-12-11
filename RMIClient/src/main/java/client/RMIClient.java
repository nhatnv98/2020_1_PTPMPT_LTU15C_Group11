/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import bean.Bank;
import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.rmi.ssl.SslRMIClientSocketFactory;

/**
 *
 * @author HK
 */
public class RMIClient {

    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    private static final String HOST = "localhost";
    private static final int PORT = 8888;
    private static Registry registry;
    public RMIClient() {
        Registry registry;
        String host = "localhost";
        try {
//            setSettings();
//            registry = LocateRegistry.getRegistry(host, 8888, new SslRMIClientSocketFactory());
            registry = LocateRegistry.getRegistry(HOST, PORT);
            bank = (Bank) registry.lookup(Bank.class.getSimpleName());

        } catch (NotBoundException | RemoteException e) {
        }

    }

    private void setSettings() {
        String path = new File("").getAbsolutePath();
        String pass = "123456";
        System.setProperty("javax.net.ssl.debug", "all");
        System.setProperty("javax.net.ssl.keyStore", path + "/sslkey/clientKey/client.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", pass);
        System.setProperty("javax.net.ssl.trustStore", path + "/sslkey/clientKey/client.truststore");
        System.setProperty("javax.net.ssl.trustStorePassword", pass);
    }

}
