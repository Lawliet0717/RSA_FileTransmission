package com.lawliet.alice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;


public class md5Service extends Thread {

    Socket socket;

    static HashSet<String> ips = new HashSet<String>();
    public md5Service(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            OutputStream outputstream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream("G:/md5.txt");
            byte[] buf = new byte[1024];
            int length = 0;
            while((length = fileInputStream.read(buf))!=-1) {

                outputstream.write(buf,0,length);
            }
            String ip = socket.getInetAddress().getHostAddress();
            if(ips.add(ip)) {
                System.out.println("恭喜" + ip + "同学下载md5签名成功！");
            }
            fileInputStream.close();
            socket.close();

        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(9090);
        while(true) {
            Socket socket = serverSocket.accept();
            new md5Service(socket).start();
        }
    }
}
