import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
class simpleUdpClient{
    public static void main(String args[]) throws InterruptedException {
        sendPacket("メッセージ!!!","FF0000");
    }

    //sendPacket("送信するメッセージ","色(16進数表記)")
    //sendPacket("黒色のメッセージ","000000") 黒色
    //sendPacket("てすとメッセージ","FFFFFF") 白色
    //sendPacket("てすとメッセージ","FF0000") 赤色
    public static void sendPacket(String message,String colorCode){
        //16進数で色を表す
        String sendMsg= colorCode + message;
        byte request[] = sendMsg.getBytes();
        try {
            int port = 8800;
            DatagramSocket socket = new DatagramSocket(); // ソケットの作成
            // 送信データ用 DatagramPacket の作成
            InetAddress serverAddress = InetAddress.getByName("10.180.100.222");
            DatagramPacket sendPacket = new DatagramPacket(request,
                    request.length, serverAddress, port);
            socket.setSoTimeout(3000); // タイムアウトの設定 (3 秒)
            socket.send(sendPacket); // パケットの送信
            System.out.println("パケットの送信"+message);
        } catch (Exception e) {
            System.out.println("例外エラーが発生しましたlol");
            e.printStackTrace();
        }
    }
}