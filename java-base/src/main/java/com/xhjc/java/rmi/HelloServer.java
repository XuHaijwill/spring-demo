package com.xhjc.java.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 注册远程对象,向客户端提供远程对象服务.远程对象是在远程服务上创建的，你无法确切地知道远程服务器上的对象的名称 但是，将远程对象注册到RMI Service之后，客户端就可以通过RMI Service请求 到该远程服务对象的stub了，利用stub代理就可以访问远程服务对象
 */
public class HelloServer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Hello h = new HelloImpl(); /* 生成stub和skeleton,并返回stub代理引用 */
            String serverIp = "localhost";
            int listenPort = 12345;
            String serverURL = serverIp + ":" + listenPort;

            /*
             * 本地创建并启动RMI Service注册表，被创建的Registry将在指定的端口上侦听到来的请求
             */
            Registry registry = LocateRegistry.createRegistry(listenPort);
            // Registry registry = LocateRegistry.getRegistry("localhost", 12345);// 也可以获取远程RMI Service注册表，该RMI Service通过 rmiregistry -p 1099 启动

            /* 将stub代理绑定到Registry服务的URL上 */
            registry.bind("MyHello", h);// 通过RMI注册表绑定服务，不用指定完整RMI URL
            // Naming.bind("rmi://" + serverURL + "/MyHello", h);// 或者通过命名服务绑定服务，由于命名服务不止为RMI提供查询服务，故需指定完整RMI URL,java.lang.String://host:port/name

            System.out.println("HelloServer启动成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
