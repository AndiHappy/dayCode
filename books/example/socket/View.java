package socket;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//œ‘ æUI
public class View extends JPanel {

  private static final long serialVersionUID = 1L;

  private JTextArea in = null;

  private JTextArea out = null;

  private JButton button = null;

  public View() {
    this.setLayout(new GridLayout());
    in = new JTextArea();
    in.setSize(new Dimension(100, 100));
    in.setRows(5);
    in.setWrapStyleWord(true);
    in.setLineWrap(true);
    in.getDocument().addDocumentListener(new TextListener(this));
    out = new JTextArea();
    out.setSize(new Dimension(100, 200));
    this.add(new JScrollPane(in), new GridLayout(1, 1));
    this.add(new Button("∑¢ÀÕ"), new GridLayout(1, 2));
    this.add(new JScrollPane(out), new GridLayout(1, 3));
    this.setSize(600, 200);
    this.setLocation(100, 200);
    this.setVisible(true);
  }

  public JTextArea getIn() {
    return in;
  }

  public void setIn(JTextArea in) {
    this.in = in;
  }

  public JTextArea getOut() {
    return out;
  }

  public void setOut(JTextArea out) {
    this.out = out;
  }

  public JButton getButton() {
    return button;
  }

  public void setButton(JButton button) {
    this.button = button;
  }

}
