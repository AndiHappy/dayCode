package work.sort;

import java.util.Arrays;

/**
 * 特性：unstable sort、In-place sort。
 * 最坏运行时间：当输入数组已排序时，时间为O(n^2)，当然可以通过随机化来改进（shuffle array 或者 randomized select
 * pivot）,使得期望运行时间为O(nlgn)。 最佳运行时间：O(nlgn) 快速排序的思想也是分治法。
 * 当输入数组的所有元素都一样时，不管是快速排序还是随机化快速排序的复杂度都为O(n^2)
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 0, 1, 2, 3, 8 };
    quickSort(arrays);
    System.out.println(Arrays.toString(arrays));
  }

  public static void quickSort(int[] arrays) {
    quickSort(arrays, 0, arrays.length - 1);
  }

  private static void quickSort(int[] arrays, int i, int j) {
    if (i < 0 || j > arrays.length - 1) {
      throw new IllegalArgumentException("传入的参数，超出了数组的范围");
    }

    if (i < j) {
      int index = quickSortContent(arrays, i, j);
      quickSort(arrays, i, index - 1);
      quickSort(arrays, index + 1, j);
    }
  }

  private static int quickSortContent(int[] arrays, int i, int j) {
    int key = arrays[i];
    int ii = i + 1;
    for (int k = i + 1; k <= j; k++) {
      if (arrays[k] <= key) {
        swap(arrays, ii, k);
        ii++;
      }
    }
    swap(arrays, ii - 1, i);
    return ii - 1;
  }

  private static void swap(int[] arrays, int ii, int k) {
    int temp = arrays[ii];
    arrays[ii] = arrays[k];
    arrays[k] = temp;
  }

}
