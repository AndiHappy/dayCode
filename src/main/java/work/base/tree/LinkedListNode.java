package work.base.tree;

/**
 * Á´±í
 */
public class LinkedListNode<E> {

  transient Node<E> first;

  transient Node<E> last;

  private int size = 0;

  public boolean add(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<E>(l, e, null);
    last = newNode;
    if (l == null)
      setFirst(newNode);
    else
      l.next = newNode;
    size++;
    return true;
  }

  public Object[] toArray() {
    Object[] result = new Object[size];
    int i = 0;
    for (Node<E> x = first; x != null; x = x.next)
      result[i++] = x.item;
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (Node<E> x = first; x != null; x = x.next)
      builder.append(x.item.toString() + " ");
    return builder.toString();
  }

  public Node<E> getFirst() {
    return first;
  }

  public void setFirst(Node<E> first) {
    this.first = first;
  }

  private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
      this.item = element;
      this.next = next;
      this.prev = prev;
    }
  }
}