package com.xiaolinzi.nio.study.nio.study.bio;


import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xiaolinzi
 * @Date 2021/3/4 15:45
 * @email xiaolinzi95_27@163.com
 */
public class BIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);

        System.out.println("BIOServer等待连接。。");
        //阻塞方法   等待客户端的链接
        Socket clientSocket = serverSocket.accept();
        System.out.println("BIOServer有客户端连接了。。");
        doWork(clientSocket);


    }

    private static void doWork(Socket clientSocket) throws Exception {
        byte[] bytes = new byte[1024];
        System.out.println("准备read。。");
        //阻塞方法  等待客户端写数据，没有数据可读时就阻塞
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕。。");
        if (read != -1) {
            System.out.println("接收到客户端的数据：" + new String(bytes, 0, read));
        }
        clientSocket.getOutputStream().write("HelloClient".getBytes());
        clientSocket.getOutputStream().flush();
    }


}
