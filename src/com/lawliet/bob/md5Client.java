package com.lawliet.bob;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class md5Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9090);
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("H:/md5.txt");
        byte[] buf = new byte[1024];
        int length = 0;
        while( (length = inputStream.read(buf)) != -1    ) {
            fileOutputStream.write(buf, 0, length);
        }
        fileOutputStream.close();
        socket.close();
    }

}