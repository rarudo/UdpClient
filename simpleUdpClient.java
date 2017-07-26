import com.sun.tools.javadoc.Start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Random;

/**
 * Created by user on 2017/07/21.
 */

class simpleUdpClient{
    public static void main(String args[]) throws InterruptedException {
        for(int i = 0; i < 1000; i++) {
            i = 0;
            threadTes tt = new threadTes(i);
            tt.start();
            Thread.sleep((long) 1000f);
        }
    }
}

class threadTes extends Thread{
    private int num;

    threadTes(int i){
        this.num = i;
    }

    public void run() {
        byte[] buf = new byte[160 * 120 * 3];
        String[] colorStr = {
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "a",
                "b",
                "c",
                "d",
                "e",
                "f"
        };
        String[] msg= {
                "色が変わるかな",
                "色",
                "変われ",
                "Hello World"
        };
        Random rnd = new Random();
        int randomInt1 = rnd.nextInt(colorStr.length-1);
        int randomInt2 = rnd.nextInt(msg.length-1);
        String sendMsg= colorStr[randomInt1] + msg[randomInt2];
        byte request[] = sendMsg.getBytes();
        int port = 8800;
        try {
            DatagramSocket socket = new DatagramSocket(); // ソケットの作成
            // 送信データ用 DatagramPacket の作成
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket sendPacket = new DatagramPacket(request,
                    request.length, serverAddress, port);
            socket.setSoTimeout(3000); // タイムアウトの設定 (3 秒)
            socket.send(sendPacket); // REQUEST の送信
        } catch (Exception e) {
            System.out.println("Exception in init ");
            e.printStackTrace();
        }
    }
}
