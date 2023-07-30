package com.xhjc.java.rmi;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        // String serverIp = "192.168.7.39";
        String serverIp = "localhost";
        int serverPort = 12345;
        String serverURL = serverIp + ":" + serverPort;
        Hello h = null;

        /* 从RMI Registry中请求stub */
        // h = (Hello) Naming.lookup("rmi://" + serverURL + "/MyHello");

        Registry registry = LocateRegistry.getRegistry(serverIp, serverPort);
        h = (Hello) registry.lookup("MyHello");

        /* 通过stub调用远程接口实现 */
        System.out.println(h.sayHello("hello"));
    }
}
