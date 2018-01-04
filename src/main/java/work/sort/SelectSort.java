package work.sort;

import java.util.Arrays;

public class SelectSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 0, 1, 2, 3, 8 };
    arrays = selectSort(arrays);
    System.out.println(Arrays.toString(arrays));
  }

  public static int[] selectSort(int[] arrays) {

    for (int i = 0; i < arrays.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < arrays.length; j++) {
        if (arrays[j] < arrays[min]) {
          min = j;
        }
      }

      int temp = arrays[i];
      arrays[i] = arrays[min];
      arrays[min] = temp;
    }

    return arrays;
  }

}
