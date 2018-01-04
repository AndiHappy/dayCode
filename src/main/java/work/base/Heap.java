package work.base;

import java.util.Arrays;

/**
 * @author zhailzh 
 */
public class Heap {

  public static void printMAXHeapByOrder(int[] heap) {
    for (int i = heap.length - 1; i > 0; i--) {
      swap(heap, 0, i);
      mainMAXHeap(heap, 0, i);
    }
    System.out.println(Arrays.toString(heap));
  }

  public static int[] creatMINheap(int[] arrays) {
    for (int i = arrays.length / 2; i >= 0; i--) {
      mainMINHeap(arrays, i, arrays.length);
    }
    return arrays;
  }

  public static int[] creatMINheap(int[] arrays, int begine, int end) {
    int length = end - begine + 1;
    for (int i = length / 2; i >= 0; i--) {
      mainMINHeap(arrays, i, length);
    }
    return arrays;
  }

  private static void mainMINHeap(int[] arrays, int i, int length) {
    // 
    int minest = i;
    if (left(i) < length && arrays[left(i)] < arrays[minest]) {
      minest = left(i);
    }

    // 
    if (right(i) < length && arrays[right(i)] < arrays[minest]) {
      minest = right(i);
    }

    if (minest != i) {
      swap(arrays, i, minest);
      mainMAXHeap(arrays, minest, length);
    }
  }

  public static int[] creatMAXheap(int[] arrays) {
    for (int i = arrays.length / 2; i >= 0; i--) {
      mainMAXHeap(arrays, i, arrays.length);
    }
    return arrays;
  }

  public static int[] creatMAXheap(int[] arrays, int begine, int end) {
    int length = end - begine + 1;
    for (int i = length / 2; i >= 0; i--) {
      mainMAXHeap(arrays, i, length);
    }
    return arrays;
  }

  private static void mainMAXHeap(int[] arrays, int i, int length) {
    // 
    int largest = i;
    if (left(i) < length && arrays[left(i)] > arrays[largest]) {
      largest = left(i);
    }

    if (right(i) < length && arrays[right(i)] > arrays[largest]) {
      largest = right(i);
    }

    if (largest != i) {
      swap(arrays, i, largest);
      mainMAXHeap(arrays, largest, length);
    }
  }

  private static void swap(int[] arrays, int i, int largest) {
    int temp = arrays[i];
    arrays[i] = arrays[largest];
    arrays[largest] = temp;
  }

  private static int left(int i) {
    return 2 * i + 1;
  }

  private static int right(int i) {
    return 2 * i + 2;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
