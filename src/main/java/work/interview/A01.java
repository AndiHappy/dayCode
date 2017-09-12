package work.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class A01 {

  //  1~n所有不能被素数相加得到的偶数。

  public static void main(String[] args) {
    A01 a01 = new A01();
    a01.isprimer();
    Set<Integer> numbers = a01.value.keySet();
    Integer[] nums = (Integer[]) numbers.toArray();
    Arrays.sort(nums);
    System.out.println(nums);
  }

  private int maxValue = 0;

  private HashMap<Integer, Boolean> value = new HashMap<Integer, Boolean>();

  public void isprimer() {
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      if (i % 2 != 0 && is_primer2(i)) {
        set(i);
      }
    }
  }

  private void set(int i) {
    value.put(i, true);
  }

  private boolean is_primer2(int a) {
    if (a % 2 != 0) {
      for (int i = 2; i <= Math.sqrt(a); i++) {
        if (a % i == 0) {// 若能被整除，则说明不是素数，返回false  
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
