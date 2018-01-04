package work.algprithm;

import work.base.Heap;
import work.base.createData.DataFromFile;
import work.sort.QuickSort;

/**
 * @author zhailzh СKԪ
 */
public class Al05FindMinK {

  public static void main(String[] args) {
    int[] arrays = DataFromFile.readIntData(0, 100);
    QuickSort.quickSort(arrays);
    int k = 4;
    for (int i = 0; i < k; i++) {
      System.out.print(arrays[i] + " ");
    }

    // int[] mink = findMink1(arrays, k);
    // for (int i = 0; i < k; i++) {
    // System.out.print(mink[i] + " ");
    // }

    int[] mingheap = findMink2(arrays, 4);
    Heap.printMAXHeapByOrder(mingheap);
  }

  public static int[] findMink2(int[] arrays, int k) {
    int[] mingheap = new int[k];
    for (int i = 0; i < k; i++) {
      mingheap[i] = arrays[i];
    }

    Heap.creatMAXheap(mingheap);

    for (int i = k; i < arrays.length; i++) {
      int temp = arrays[i];
      sortHead(temp, mingheap);
    }
    return mingheap;
  }

  private static void sortHead(int temp, int[] mingheap) {

    if (temp >= mingheap[0]) {
      return;
    } else {
      mingheap[0] = temp;
      Heap.creatMAXheap(mingheap);
    }

  }

  public static int[] findMink1(int[] arrays, int k) {
    int[] mink = new int[k];
    for (int i = 0; i < k; i++) {
      mink[i] = arrays[i];
    }

    QuickSort.quickSort(mink);

    for (int i = k; i < arrays.length; i++) {
      sortk(arrays[i], mink);
    }
    return mink;
  }

  public static void sortk(int value, int[] mink) {

    if (value >= mink[mink.length - 1]) {
      return;
    }

    if (value < mink[0]) {
      mink[0] = value;
    }

    for (int i = mink.length - 1; i > 0; i--) {
      if (value < mink[i]) {
        mink[i] = mink[i - 1];
      } else {
        mink[i + 1] = value;
      }
    }

  }
}
