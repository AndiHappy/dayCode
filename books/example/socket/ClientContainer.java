package socket;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ClientContainer extends JPanel {

  private static final long serialVersionUID = 1L;

  private Model model = Model.getInstace();

  private View view = null;

  private Action action = null;

  protected void addListener() {
    model.addPropertyChangeListener("view", this.action);
  }

  protected void init() {
    iniUI();
    resetModel();
    addListener();
  }

  private void iniUI() {
    setLayout(new BorderLayout());
    view = new View();
    add(this.view);
  }

  // 模型数据启动前的设置
  private void resetModel() {
    action = new Action(this.view, this.model);
  }
}
