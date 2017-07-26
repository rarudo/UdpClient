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
        for(int i = 0; i < 1000; i++){
            sendPacket();
            Thread.sleep((long) 1000f);
        }
    }

    public static void sendPacket(){
        int port = 8800;
        //4byte16進数で色を表す
        //[1,2,......,8,9,a,b,c,d,e,f]が利用可能
        String colorStr = "1";
        String msg = "メッセージ";
        String sendMsg= colorStr + msg;
        byte request[] = sendMsg.getBytes();
        try {
            DatagramSocket socket = new DatagramSocket(); // ソケットの作成
            // 送信データ用 DatagramPacket の作成
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket sendPacket = new DatagramPacket(request,
                    request.length, serverAddress, port);
            socket.setSoTimeout(3000); // タイムアウトの設定 (3 秒)
            socket.send(sendPacket); // パケットの送信
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


