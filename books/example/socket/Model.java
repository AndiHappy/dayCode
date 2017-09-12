package socket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author zha
 *
 */
public class Model {

  private PropertyChangeSupport support = null;

  private static class SignalHolder {
    private static Model model = new Model();
  }

  private Model() {
    this.support = new PropertyChangeSupport(this);
  }

  public static Model getInstace() {
    return SignalHolder.model;
  }

  public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
    getSupport().addPropertyChangeListener(propertyName, listener);
  }

  public void removeAllPropertyChangeListener() {
    PropertyChangeListener[] listeners = getSupport().getPropertyChangeListeners();
    if ((listeners == null) || (listeners.length == 0)) {
      return;
    }
    for (PropertyChangeListener listener : listeners)
      getSupport().removePropertyChangeListener(listener);
  }

  public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    this.support.firePropertyChange(propertyName, oldValue, newValue);
  }

  public PropertyChangeSupport getSupport() {
    return support;
  }

  public void setSupport(PropertyChangeSupport support) {
    this.support = support;
  }

}
