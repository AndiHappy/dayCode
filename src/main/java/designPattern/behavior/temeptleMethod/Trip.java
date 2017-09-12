package designPattern.behavior.temeptleMethod;

public abstract class Trip {
  public final void performTrip() {
    doComingTransport();
    doDayA();
    doDayB();
    doDayC();
    doReturningTransport();
    doOver();
  }

  public abstract void doComingTransport();

  public abstract void doDayA();

  public abstract void doDayB();

  public abstract void doDayC();

  public abstract void doReturningTransport();

  private void doOver() {
    System.out.println("最后的收尾的工作");
  }
}
