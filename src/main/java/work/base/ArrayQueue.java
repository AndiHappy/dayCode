package work.base;

import java.util.Arrays;

/**
 * @author zhailz
 *
 * @Date 2015年10月17日 下午1:07:12
 */
public class ArrayQueue<E> {

  private transient E[] elements;
  private transient int head;
  private transient int tail;
  private static final int MIN_INITIAL_CAPACITY = 8;

  @SuppressWarnings("unchecked")
  public ArrayQueue() {
    elements = (E[]) new Object[MIN_INITIAL_CAPACITY];
  }

  public void add(E e) {
    if (e == null) {
      throw new NullPointerException();
    }
    elements[tail] = e;
    int dex = (tail = (tail + 1) & (elements.length - 1));
    if (dex == head) {
      System.out.println("队列已满，扩容。");
      // doubleCapacity();
    }

  }

  public E popQueueHead() {
    if (elements.length <= 0) {
      throw new IllegalAccessError("队列中没有元素");
    }

    int h = head;
    E result = elements[h]; // Element is null if deque empty
    if (result == null)
      return null;
    elements[h] = null; // Must null out slot
    head = (h + 1) & (elements.length - 1);
    return result;
  }

  public boolean isEmpty() {
    if (elements.length == 0 || (head & elements.length - 1) == tail) {
      return true;
    } else {
      return false;
    }
  }

  @SuppressWarnings({ "unused", "unchecked" })
  private void doubleCapacity() {
    assert head == tail;
    int p = head;
    int n = elements.length;
    int r = n - p; // number of elements to the right of p
    int newCapacity = n << 1;
    if (newCapacity < 0)
      throw new IllegalStateException("Sorry, deque too big");
    Object[] a = new Object[newCapacity];
    System.arraycopy(elements, p, a, 0, r);
    System.arraycopy(elements, 0, a, r, p);
    elements = (E[]) a;
    head = 0;
    tail = n;
  }

  @Override
  public String toString() {
    return "ArrayQueue [elements=" + Arrays.toString(elements) + "]";
  }

  public static void main(String[] args) {
    ArrayQueue<String> queue = new ArrayQueue<String>();
    queue.add("1");
    queue.add("2");
    queue.add("3");
    queue.add("4");
    queue.add("5");
    queue.add("6");
    queue.add("7");
    queue.add("8");

    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.toString());
    queue.add("11");
    queue.add("12");
    queue.add("13");
    queue.add("05");
    queue.add("06");
    queue.add("07");
    queue.add("09");
    System.out.println(queue.toString());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.popQueueHead());
    System.out.println(queue.toString());
  }

}
