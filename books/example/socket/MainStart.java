package socket;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainStart {
  public static void main(String[] args) {

    new Thread(new Runnable() {
      public void run() {
        JFrame frame = new JFrame();
        frame.setTitle("Client");
        // Image imag =
        // Toolkit.getDefaultToolkit().getImage(ResourcesIcon.frameIcon);
        // frame.setIconImage(imag);

        frame.setLayout(new BorderLayout());
        ClientContainer funclet = new ClientContainer();
        funclet.init();
        frame.add(funclet);
        frame.setSize(600, 200);
        frame.setLocation(100, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

      }
    }).start();

  }
}
