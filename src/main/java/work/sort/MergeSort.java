package work.sort;

import java.util.Arrays;

/**
 * 特点：stable sort、Out-place sort 思想：运用分治法思想解决排序问题。 最坏情况运行时间：O(nlgn)
 * 最佳运行时间：O(nlgn)
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, Integer.MAX_VALUE, 7, 0, Integer.MAX_VALUE, 2, 3,
        5, 7, 0, 1, 2, 3, 8 };
    System.out.println(Arrays.toString(arrays));
    System.out.println(arrays.length);

    arrays = mergeSort(arrays);
    System.out.println(Arrays.toString(arrays));
    System.out.println(arrays.length);

  }

  public static int[] mergeSort(int[] arrays) {
    return arrayMergeSort(arrays, 0, arrays.length - 1);
  }

  private static int[] arrayMergeSort(int[] arrays, int i, int j) {
    if (i < 0 || j > arrays.length - 1) {
      throw new IllegalArgumentException("传入的参数，超出了数组的范围");
    }
    if (i < j) {

      int m = (i + j) / 2;

      arrayMergeSort(arrays, i, m);

      arrayMergeSort(arrays, m + 1, j);

      arrayMergeSortContentNoFlag(arrays, i, m, j);
    }
    return arrays;
  }

  /**
   * i 开始 j 结束 m 中间 使用标志位的算法
   */
  public static void arrayMergeSortContent(int[] arrays, int i, int m, int j) {
    int first = m - i + 1;
    int second = j - m;

    int[] firsta = new int[first + 1];
    int[] seconda = new int[second + 1];

    // 初始化
    for (int k = i; k <= m; k++) {
      firsta[k - i] = arrays[k];
    }
    for (int k = m + 1; k <= j; k++) {
      seconda[k - m - 1] = arrays[k];
    }
    // 标志位
    firsta[first] = Integer.MAX_VALUE;
    seconda[second] = Integer.MAX_VALUE;

    int ff = 0;
    int ss = 0;
    for (int k = i; k <= j; k++) {
      if (firsta[ff] < seconda[ss]) {
        arrays[k] = firsta[ff];
        ff++;
      } else {
        arrays[k] = seconda[ss];
        ss++;
      }
    }
  }

  /**
   * i 开始 j 结束 m 中间 不适用使用标志位的算法
   */
  public static void arrayMergeSortContentNoFlag(int[] arrays, int i, int m, int j) {
    int first = m - i + 1;
    int second = j - m;

    int[] firsta = new int[first];
    int[] seconda = new int[second];

    // 初始化
    for (int k = i; k <= m; k++) {
      firsta[k - i] = arrays[k];
    }
    for (int k = m + 1; k <= j; k++) {
      seconda[k - m - 1] = arrays[k];
    }

    int ff = 0;
    int ss = 0;
    int k = i;
    for (; k <= j && ff < firsta.length && ss < seconda.length; k++) {
      if (firsta[ff] < seconda[ss]) {
        arrays[k] = firsta[ff];
        ff++;
      } else {
        arrays[k] = seconda[ss];
        ss++;
      }
    }

    if (ff <= firsta.length - 1) {
      for (; ff < firsta.length; k++, ff++) {
        arrays[k] = firsta[ff];
      }
    }

    if (ss <= seconda.length - 1) {
      for (; ff < seconda.length; k++, ss++) {
        arrays[k] = seconda[ss];
      }
    }
  }
}
