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
        for(int i = 0; i < 1000000; i++){
            sendPacket();
            Thread.sleep((long) 500f);
        }
    }

    public static void sendPacket(){
        //4byte16進数で色を表す
        int r=(int)(Math.random()*256);
        int g=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);
        String colorStr =  String.format("%02x", r)+String.format("%02x", g)+String.format("%02x", b);
        String msg = "メッセージ→乱数" + String.valueOf(Math.random());
        String sendMsg= colorStr + msg;
        byte request[] = sendMsg.getBytes();
        try {
            int port = 8800;
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


