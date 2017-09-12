package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {
  public void sendMsg(String msg) {
    try {
      Socket socket = new Socket("127.0.0.1", 4700);
      // �򱾻���4700�˿ڷ����ͻ�����
      PrintWriter os = new PrintWriter(socket.getOutputStream());
      // ��Socket����õ��������������PrintWriter����
      BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // ��Socket����õ�����������������Ӧ��BufferedReader����
      String readline = msg; // ��ϵͳ��׼�������һ�ַ���
      os.println(readline);
      // ����ϵͳ��׼���������ַ��������Server
      os.flush();
      // ˢ���������ʹServer�����յ����ַ���
      os.close(); // �ر�Socket�����
      is.close(); // �ر�Socket������
      socket.close(); // �ر�Socket
    } catch (Exception e) {
      System.out.println("Error" + e); // �������ӡ������Ϣ
    }
  }

}