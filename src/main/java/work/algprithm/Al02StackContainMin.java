package work.algprithm;

public class Al02StackContainMin<E extends Comparable<E>> {

  protected Object[] elementData;

  protected Object[] elementmin;

  protected int length = -1;

  protected E min = null;

  public Al02StackContainMin(int length) {
    this.elementData = new Object[length];
    this.elementmin = new Object[length];
  }

  public void push(E e) {
    if (length >= elementData.length) {
      throw new IllegalStateException("栈已满");
    } else {
      length++;
      E min = matainmin(e);
      elementData[length] = e;
      elementmin[length] = min;
    }
  }

  @SuppressWarnings("unchecked")
  public E min() {
    return (E) elementmin[length];
  }

  public E pop() {
    if (length >= elementData.length) {
      throw new IllegalStateException("栈已空");
    } else if (length < 0) {
      throw new IllegalStateException("栈已空");
    } else {
      @SuppressWarnings("unchecked")
      E result = (E) elementData[length];
      elementData[length] = null;
      elementmin[length] = null;
      length--;
      return result;
    }
  }

  private E matainmin(E e) {
    if (min == null || compare(e, min) < 0) {
      min = e;
      return e;
    }
    return min;
  }

  private int compare(E e, E min2) {
    return e.compareTo(min2);
  }

  public static void main(String[] args) {

    Al02StackContainMin<Integer> stack = new Al02StackContainMin<Integer>(10);
    stack.push(1);
    System.out.println(stack.min());
    stack.push(0);
    System.out.println(stack.min());
    stack.push(2);
    stack.push(3);
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    stack.pop();
  }
}
