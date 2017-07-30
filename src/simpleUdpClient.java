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
        sendPacket("メッセージ!!!",255,12,44);
    }

    public static void sendPacket(String message,int r,int g,int b){
        //4byte16進数で色を表す
        String colorStr =  String.format("%02x", r)+String.format("%02x", g)+String.format("%02x", b);
        String sendMsg= colorStr + message;
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


