package work.sort;

import java.util.Arrays;

public class HeapSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 10, 16, 0 };
    hearpSort(arrays);
    System.out.println(Arrays.toString(arrays));
  }

  public static int[] hearpSort(int[] arrays) {
    creatheap(arrays);
    System.out.println(Arrays.toString(arrays));
    for (int i = arrays.length - 1; i > 0; i--) {
      swap(arrays, 0, i);
      mainHeap(arrays, 0, i);
    }
    return arrays;
  }

  public static int[] creatheap(int[] arrays) {
    for (int i = arrays.length / 2; i >= 0; i--) {
      mainHeap(arrays, i, arrays.length);
    }
    return arrays;
  }

  // ֶѵ
  private static void mainHeap(int[] arrays, int i, int length) {
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
      mainHeap(arrays, largest, length);
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
}
