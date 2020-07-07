package main.java.InterviewPrepare.DesignPattern;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class Test {
    public static void main(String[] args) throws IOException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        String newData = "New String to write to file..." + System.currentTimeMillis();
        System.out.println(newData.length());
        RandomAccessFile aFile = null;
        aFile = new RandomAccessFile("upload/test.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer bf = ByteBuffer.allocate(48);
        bf.clear();
        bf.put(newData.getBytes());
        bf.flip();
        while (bf.hasRemaining()) {
            inChannel.write(bf);
        }
        long fileSize = inChannel.size();
        System.out.println("文件大小为：" + fileSize);
        int bytesRead = inChannel.read(bf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            bf.flip();
            while(bf.hasRemaining()){
                System.out.print((char) bf.get());
            }
            bf.clear();
            bytesRead = inChannel.read(bf);
        }
        inChannel.close();
        aFile.close();

    }
}
