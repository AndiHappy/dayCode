package work.sort;

import java.util.Arrays;

/**
 * 特点：stable sort、In-place sort 思想：通过两两交换，像水中的泡泡一样，小的先冒出来，大的后冒出来。 最坏运行时间：O(n^2)
 * 最佳运行时间：O(n^2)（当然，也可以进行改进使得最佳运行时间为O(n)
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 0, 1, 2, 3, 8 };
    arrays = bubbleSort(arrays);
    System.out.println(Arrays.toString(arrays));
  }

  public static int[] bubbleSort(int[] arrays) {

    for (int j = 0; j < arrays.length; j++) {
      // 如果从arrays.lenth -1 到 j+1 不在起泡，说明顺序已经排好了，就没有必要再次的循环了
      for (int i = arrays.length - 1; i > j; i--) {
        if (arrays[i] < arrays[i - 1]) {
          int temp = arrays[i - 1];
          arrays[i - 1] = arrays[i];
          arrays[i] = temp;
        }
      }
    }
    return arrays;
  }

  public static int[] bubbleSortImpove(int[] arrays) {

    boolean flag = false;
    for (int j = 0; j < arrays.length; j++) {
      if (flag)
        return arrays;
      flag = true;
      // 如果从arrays.lenth -1 到 j+1 不在起泡，说明顺序已经排好了，就没有必要再次的循环了
      for (int i = arrays.length - 1; i > j; i--) {
        if (arrays[i] < arrays[i - 1]) {
          int temp = arrays[i - 1];
          arrays[i - 1] = arrays[i];
          arrays[i] = temp;
          flag = false;
        }
      }
    }

    return arrays;
  }
}
