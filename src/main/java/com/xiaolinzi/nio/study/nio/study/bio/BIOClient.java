package com.xiaolinzi.nio.study.nio.study.bio;

import java.net.Socket;

/**
 * @author xiaolinzi
 * @Date 2021/3/4 16:02
 * @email xiaolinzi95_27@163.com
 */
public class BIOClient {
    public static void main(String[] args) throws Exception {
        //初始化客户端，这边一初始化，服务端的accept方法就会得到相应
        Socket socket = new Socket("localhost", 9000);
        //向服务端发送数据
        socket.getOutputStream().write("HelloServer".getBytes());
        socket.getOutputStream().flush();
        System.out.println("向服务端发送数据结束");
        byte[] bytes = new byte[1024];
        //阻塞方法，接收服务端回传的数据
        socket.getInputStream().read(bytes);
        System.out.println("接收到服务端的数据：" + new String(bytes));
        socket.close();
    }
}
