package socket;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Action implements PropertyChangeListener {

  private View view = null;
  private Model model = null;

  // ����������ҵ���߼�
  private TalkClient client = new TalkClient();

  public Action(View view, Model model) {
    this.view = view;
    this.model = model;
  }

  public void propertyChange(PropertyChangeEvent evt) {
    System.out.println("�����¼���  " + evt.getPropertyName());
    if (evt.getPropertyName().equalsIgnoreCase("view")) {
      this.getView().getIn().setText("");
      String value = (String) evt.getNewValue();

    }
  }

  public View getView() {
    return view;
  }

  public void setView(View view) {
    this.view = view;
  }

  public Model getModel() {
    return model;
  }

  public void setModel(Model model) {
    this.model = model;
  }
}
