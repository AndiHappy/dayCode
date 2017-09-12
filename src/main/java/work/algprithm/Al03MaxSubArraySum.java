package work.algprithm;

/**
 * 
 */
public class Al03MaxSubArraySum {

  public static void main(String[] args) {
    int[] value = new int[] { -6, 2, 4, -7, 5, 3, 2, -1, 6, -9, 10, -2 };
    int max = getmaxO3(value);
    int max1 = getmaxO2(value);
    int max2 = getmaxO(value);
    System.out.println(max);
    System.out.println(max1);
    System.out.println(max2);
  }

  private static int getmaxO(int[] a) {
    int maxSum = 0, thisSum = 0;
    for (int j = 0; j < a.length; j++) {
      thisSum += a[j];
      if (thisSum > maxSum)
        maxSum = thisSum;
      else if (thisSum < 0)
        thisSum = 0;
    }
    return maxSum;
  }

  private static int getmaxO2(int[] ary) {
    int max = 0;
    for (int i = 0; i < ary.length; i++) {
      int temp = 0;
      for (int j = i; j < ary.length; j++) {
        temp = temp + ary[j];
        if (temp > max) {
          max = temp;
        }
      }
    }

    return max;
  }

  public static int getmaxO3(int[] ary) {
    int max = 0;
    for (int i = 0; i < ary.length; i++) {
      for (int j = i + 1; j < ary.length; j++) {
        int temp = sum(i, j, ary);
        if (temp > max) {
          max = temp;
        }
      }
    }

    return max;
  }

  private static int sum(int i, int j, int[] ary) {

    int sum = 0;
    for (int k = i; k <= j; k++) {
      sum = sum + ary[k];
    }
    return sum;
  }

}
