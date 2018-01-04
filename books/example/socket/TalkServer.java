package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {

  public static void main(String args[]) {

    try {
      ServerSocket server = null;
      try {
        server = new ServerSocket(4700);
        // һServerSocketڶ˿4700ͻ
      } catch (Exception e) {
        System.out.println("can not listen to:" + e);
        // ӡϢ
      }

      Socket socket = null;
      try {
        socket = server.accept();
        // ʹaccept()ȴͻпͻ
        // һSocket󣬲ִ
      } catch (Exception e) {
        System.out.println("Error." + e);
        // ӡϢ
      }

      String line;
      BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // SocketõӦBufferedReader
      PrintWriter os = new PrintWriter(socket.getOutputStream());
      // SocketõPrintWriter
      BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
      // ϵͳ׼豸BufferedReader
      System.out.println("Client:" + is.readLine());
      // ڱ׼ϴӡӿͻ˶ַ
      line = sin.readLine();
      // ӱ׼һַ
      while (!line.equals("bye")) {
        // ַΪ "bye"ֹͣѭ
        os.println(line);
        // ͻַ
        os.flush();
        // ˢʹClientյַ
        System.out.println("Server:" + line);
        // ϵͳ׼ϴӡַ
        System.out.println("Client:" + is.readLine());
        // Clientһַӡ׼
        line = sin.readLine();
        // ϵͳ׼һַ
      } // ѭ
      os.close(); // رSocket
      is.close(); // رSocket
      socket.close(); // رSocket
      server.close(); // رServerSocket
    } catch (Exception e) {
      System.out.println("Error:" + e);
      // ӡϢ
    }

  }

}