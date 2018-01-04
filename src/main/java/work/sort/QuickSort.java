package work.sort;

import java.util.Arrays;

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
      throw new IllegalArgumentException("");
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
