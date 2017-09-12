package work.algprithm;

import work.base.LinkedNode;

/**
 * @author zhailzh
 * 
 * @Date 2015��11��6��������4:46:12
 * 
 *       �ж������������Ƿ��ཻ���л����޻�
 * 
 *       �ཻ���ж����һ��λ���Ƿ��ཻ ��һ���ڵ㣬��Ϊ�����ӵĻ� �жϻ��ĵ�һ���ڵ�
 */
public class LinkedListJoin {

  public static void main(String[] args) {

  }

  // �ж����һ���ڵ�
  public boolean isConNLoop(LinkedNode<?> h1, LinkedNode<?> h2) {
    if (h1 == null || h2 == null)
      return false;
    LinkedNode<?> n1 = h1;
    LinkedNode<?> n2 = h2;
    while (n1.next != null)
      n1 = n1.next;
    while (n2.next != null)
      n2 = n2.next;

    if (n1 == n2)
      return true;
    return false;
  }

  // �ҵ������ڵ��ཻ�ĵط�
  public LinkedNode<?> findPointNLoop(LinkedNode<?> h1, LinkedNode<?> h2) {
    if (h1 == null || h2 == null)
      return null;
    LinkedNode<?> n1 = h1;
    LinkedNode<?> n2 = h2;
    int len1 = 0;
    int len2 = 0;
    while (n1 != null) {
      n1 = n1.next;
      len1++;
    }
    while (n2 != null) {
      n2 = n2.next;
      len2++;
    }

    n1 = h1;
    n2 = h2;
    if (len1 < len2) {
      n1 = h2;
      n2 = h1;
    }

    for (int i = len1 - len2; i > 0; i--)
      n1 = n1.next;

    while (n1 != null && n1 != n2) {
      n1 = n1.next;
      n2 = n2.next;
    }
    return n1;
  }

  public boolean isLoop(LinkedNode<?> h2) {
    return loopEntry(h2) != null;
  }

  // �ж��Ƿ��л�
  public LinkedNode<?> loopEntry(LinkedNode<?> head) {
    if (head == null)
      return null;
    LinkedNode<?> slow = head;
    LinkedNode<?> fast = slow.next;
    while (fast != null && fast.next != null && fast != slow) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast == slow) {
      fast = head;
      slow = slow.next;
      while (fast != slow) {
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
    }
    return null;
  }

}
