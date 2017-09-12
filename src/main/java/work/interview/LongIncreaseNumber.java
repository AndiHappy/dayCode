package work.interview;

/**
 * @author zhailz
 *
 * 时间：2016年6月29日 ### 下午2:50:49
 */
public class LongIncreaseNumber {

  /**
   * 问题描述：找出一个n个数的序列的最长单调递增子序列： 比如A = {5,6,7,1,2,8} 的LIS是5,6,7,8
   * 分析：首先是分析问题，我们需要找到子问题，如果a1,a2,a3,.....,ai 的LIS为 b1,b2,b3,......,bj 
   * 那么如果 ai = bj 那么b1,b2,b3,......,bj-1 就是：a1,a2,a3,.....,ai-1 的 LIS
   * 如果 ai< bj 那么 b1,b2,b3,......,bj  就是a1,a2,a3,.....,ai 的LIS
   * 
   * 我们设 lis[i] 为数组A的LIS的最大值位置，那么：
   * lis[i] = i 如果i = 1;
   * 
   * lis[i] = i 如果：a[i] > a[lis[i-1]]
   * 
   * lis[i] = V(lis[i-1], ) 如果 a[i] < a[lis[i-1]].  lis[i-1] ,...,i 之间的最长增加序列
   * 
   * 
   * */
  
  
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
