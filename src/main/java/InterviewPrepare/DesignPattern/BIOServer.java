package main.java.InterviewPrepare.DesignPattern;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        ServerSocket serverSocket = null;

        try {
            //创建一个Socket服务，监听10000端口
            serverSocket = new ServerSocket(9000);
            System.out.println("服务器启动...");
            while(true){
                final Socket socket = serverSocket.accept();
                System.out.println("来了一个新的客户端连接");
                handler(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = null;

        try {
            //创建一个Socket服务，监听10000端口
            serverSocket = new ServerSocket(10000);
            System.out.println("服务器启动...");
            while(true){
                final Socket socket = serverSocket.accept();
                System.out.println("来了一个新的客户端连接");
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        handler(socket);
                    }
                });

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务handler
     */
    public static void handler(Socket socket){

        byte[] buffer = new byte[1024];
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            while(true){
                int read = inputStream.read(buffer);
                if(read!=-1){
                    System.out.println(new String(buffer,0,read));
                }
            }
        } catch (IOException e) {
            System.out.println("获取Socket的输入流失败！");
            e.printStackTrace();
        }
    }
}
