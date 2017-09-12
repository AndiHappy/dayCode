package socket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Funclet extends JPanel {

  private static final long serialVersionUID = 1006871899808680153L;

  JComboBox<String> dbtype = null;

  JButton findButton = null;

  JButton newAppicon = null;

  JTextArea table = new JTextArea();

  public void init() {
    this.setLayout(new BorderLayout());
    JPanel panel = Addition();
    this.add(panel, BorderLayout.NORTH);

    // 展示列表
    this.add(table, BorderLayout.CENTER);

    this.setVisible(true);

  }

  private JPanel Addition() {
    JPanel panel = new JPanel();
    panel.setBackground(Color.gray);
    panel.setLayout(new BorderLayout());
    dbtype.setPreferredSize(new Dimension(200, 30));
    findButton = new JButton("findAppIcon");
    panel.add(dbtype, BorderLayout.WEST);
    panel.add(findButton, BorderLayout.CENTER);

    newAppicon = new JButton("新增");
    panel.add(newAppicon, BorderLayout.EAST);

    return panel;
  }
}
