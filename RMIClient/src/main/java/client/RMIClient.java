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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
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
        String host = "localhost";
        try {
//            setSettings();
//            registry = LocateRegistry.getRegistry(host, 8888, new SslRMIClientSocketFactory());
            registry = LocateRegistry.getRegistry(HOST, PORT);
            bank = (Bank) registry.lookup(Bank.class.getSimpleName());
        } catch (RemoteException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void setSettings() {
        String path = new File("").getAbsolutePath();
        String pass = "123456";
        System.setProperty("javax.net.ssl.debug", "all");
        System.setProperty("javax.net.ssl.keyStore", path + "/sslkey/serverKey/server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", pass);
        System.setProperty("javax.net.ssl.trustStore", path + "/sslkey/serverKey/server.truststore");
        System.setProperty("javax.net.ssl.trustStorePassword", pass);
    }
}
