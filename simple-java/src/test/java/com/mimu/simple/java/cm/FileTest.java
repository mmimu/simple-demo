package com.mimu.simple.java.cm;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * author: mimu
 * date: 2019/10/8
 */
public class FileTest {

    @Test
    public void info() {
        Path path = Paths.get(this.getClass().getName()).toAbsolutePath().getParent();
        String s = Paths.get(this.getClass().getName()).toString().replaceAll("\\.", "\\/");
        Path resolve = path.resolve(s);
        System.out.println(resolve.toString().concat(".class"));
    }

    /**
     * a fileChannel transfer data to socketChannel
     *
     * @throws IOException
     */
    @Test
    public void info1() throws IOException {
        File file = new File("a.txt");
        OutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = ((FileOutputStream) outputStream).getChannel();
        int capacity = 1024, index = 0;
        ByteBuffer data = ByteBuffer.allocate(capacity);
        while (data.remaining() > 0) {
            data.put(String.valueOf(index++).getBytes());
        }
        data.flip();
        channel.write(data);

        InputStream inputStream = new FileInputStream(file);
        FileChannel source = ((FileInputStream) inputStream).getChannel();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        SocketChannel socketChannel = serverSocketChannel.accept();
        source.transferTo(0, source.size(), socketChannel);

    }

    /**
     * get data from socketChannel which the data form a fileChannel
     *
     * @throws IOException
     */
    @Test
    public void info2() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
        int capacity = 1024;
        ByteBuffer data = ByteBuffer.allocate(capacity);
        socketChannel.read(data);
        data.flip();
        System.out.println(data);
        while (data.remaining() > 0) {
            System.out.println(data.get());
        }
    }
}