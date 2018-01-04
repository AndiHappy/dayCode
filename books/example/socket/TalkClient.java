package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {
  public void sendMsg(String msg) {
    try {
      Socket socket = new Socket("127.0.0.1", 4700);
      // 򱾻4700˿ڷͻ
      PrintWriter os = new PrintWriter(socket.getOutputStream());
      // SocketõPrintWriter
      BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // SocketõӦBufferedReader
      String readline = msg; // ϵͳ׼һַ
      os.println(readline);
      // ϵͳ׼ַServer
      os.flush();
      // ˢʹServerյַ
      os.close(); // رSocket
      is.close(); // رSocket
      socket.close(); // رSocket
    } catch (Exception e) {
      System.out.println("Error" + e); // ӡϢ
    }
  }

}