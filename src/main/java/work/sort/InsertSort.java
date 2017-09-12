package work.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 特点：stable sort、In-place sort
 * 最优复杂度：当输入数组就是排好序的时候，复杂度为O(n)，而快速排序在这种情况下会产生O(n^2)的复杂度。
 * 最差复杂度：当输入数组为倒序时，复杂度为O(n^2) 插入排序比较适合用于“少量元素的数组”。
 * 
 * 其实插入排序的复杂度和逆序对的个数一样，当数组倒序时，逆序对的个数为n(n-1)/2，因此插入排序复杂度为O(n^2)。
 */
public class InsertSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 8 };
//    arrays = insertSort(arrays);
    System.out.println(Arrays.toString(arrays));

    Object[] obs = new Object[]{"3","1","4","5","7","8","0","9"};
    insertSort(obs);
    System.out.println(Arrays.toString(obs));
  }
  
  /**
   * 插入排除在其他方面的应用
   * */
  public static Object[] insertSort(Object[] obs){
	  return insertSortFE(obs,0,obs.length -1);
  }
  

  private static Object[] insertSortFE(Object[] obs, int start, int end) {
	  for (int i = start +1; i <= end; i++) {
		Object temp = obs[i];
		int k = i-1;
		for (; k >= 0; k--) {
			if(compare(obs[k],temp) >= 0){
				break;
			}else{
				obs[k+1] = obs[k];
			}
		}
		
		obs[k+1] = temp;
	  }
	  return obs;
}

private static int compare(Object fir, Object sed) {
	@SuppressWarnings("unchecked")
	Comparable<Object> firs = (Comparable<Object>) fir;
	return firs.compareTo(sed);
}

public static int[] insertSort(int[] arrays) {

    for (int i = 1; i < arrays.length; i++) {
      int temp = arrays[i];
      int j = i - 1;
      for (; j >= 0 && arrays[j] > temp; j--) {
        arrays[j + 1] = arrays[j];
      }
      arrays[j + 1] = temp;
    }

    return arrays;
  }

}

/**
 * 问：快速排序（不使用随机化）是否一定比插入排序快？
 * 
 * 答：不一定，当输入数组已经排好序时，插入排序需要O(n)时间，而快速排序需要O(n^2)时间。
 * 
 * 
 * 
 */
