package socket;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class TextListener implements DocumentListener {

  View attache;

  public TextListener(View view) {
    attache = view;
  }

  public void insertUpdate(DocumentEvent e) {
    int value = e.getDocument().getLength();
    try {
      String content = e.getDocument().getText(0, value);
      if (content.endsWith("\n")) {
        System.out.println("ͣ" + content);
        Model.getInstace().firePropertyChange("view", null, content);
      }
    } catch (BadLocationException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }

  public void removeUpdate(DocumentEvent e) {
    // TODO Auto-generated method stub

  }

  public void changedUpdate(DocumentEvent e) {
    // TODO Auto-generated method stub

  }

}
