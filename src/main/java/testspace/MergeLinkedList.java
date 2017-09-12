package testspace;

import java.util.Arrays;

import work.base.LinkedNode;

/**
 * @author zhailzh
 */
public class MergeLinkedList {
  /**
   */
  static void MergeArray(int a[], int alen, int b[], int blen) {
    int len = alen + blen - 1;
    alen--;
    blen--;
    while (alen >= 0 && blen >= 0) {
      if (a[alen] > b[blen]) {
        a[len--] = a[alen--];
      } else {
        a[len--] = b[blen--];
      }
    }

    while (alen >= 0) {
      a[len--] = a[alen--];
    }
    while (blen >= 0) {
      a[len--] = b[blen--];
    }
  }

  static void MergeArrayTest() {
    int a[] = { 2, 4, 6, 8, 10, 0, 0, 0, 0, 0 };
    int b[] = { 1, 3, 5, 7, 9 };
    MergeArray(a, 5, b, 5);
    System.out.println(Arrays.toString(a));
  }

  static LinkedNode<Integer> mergeLinkedList(LinkedNode<Integer> head1, LinkedNode<Integer> head2) {
    if (head1 == null)
      return head2;
    if (head2 == null)
      return head1;
    LinkedNode<Integer> head = null;
    LinkedNode<Integer> temp = null;
    while (head1 != null && head2 != null) {
      if (head1.item > head2.item) {
        head = head2;
        head2 = head2.next;

      } else {
        head = head1;
        head1 = head1.next;
      }

      if (temp == null) {
        temp = head;
      }
    }

    if (head1 != null) {
      head.next = head1;
    }
    if (head2 != null) {
      head.next = head2;
    }

    return temp;
  }

  public static void testMergeLinkedList() {
    LinkedNode<Integer> head1 = new LinkedNode<Integer>(null, 0, null);
    head1.next = new LinkedNode<Integer>(null, 1, null);
    System.out.println(head1.toAllAfterString());

    LinkedNode<Integer> head2 = new LinkedNode<Integer>(null, 3, null);
    head2.next = new LinkedNode<Integer>(null, 4, null);
    System.out.println(head2.toAllAfterString());

    System.out.println(mergeLinkedList(head1, head2).toAllAfterString());
  }

  public static void main(String[] args) {
    testMergeLinkedList();
  }
}
