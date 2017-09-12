package designPattern.build.signalInstance;

/**
 * @author zhailzh
 */
public class SignalInstance {

  private SignalInstance() {}

  private static SignalInstance instance = null;

  private static class SignalInstanceHolder {
    private static SignalInstance instance = new SignalInstance();
  }

  public static SignalInstance getSignalInstance() {
    return SignalInstanceHolder.instance;
  }

  public static SignalInstance getInstance() {
    if (instance == null) {
      synchronized (instance) {
        if (instance == null) {
          instance = new SignalInstance();
        }
      }
    }
    return instance;
  }

  public static void main(String[] args) {
    System.out.println(SignalInstance.getSignalInstance().toString());
    System.out.println(SignalInstance.getSignalInstance().toString());

  }

}
