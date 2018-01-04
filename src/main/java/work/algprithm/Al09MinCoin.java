package work.algprithm;

public class Al09MinCoin {

  // ̬滮 óֵǰǰĽһƳ,һ״̬ǨƵǰ״̬ǰ״̬Ӱ
  // ֧ı ηû״̬Ǩ ηⲻǰӰ
  /*
   * ӲΪʱ d(0)=0 d(1)=d(1-1)+1 d(2)=d(2-1)+1 d(3)=d(3-1)+1
   * 
   * d(3)=d(3-3)+1; d(3)=min{d(3-1)+1,d(3-3)+1};//ȡӲҸСֵ ̬滮
   */
  public static void main(String[] args) {
    int a[] = { 1, 3, 5 };

    // ҪöӲ
    int count = 11;
    NumberOfCoin(a, count);
  }

  private static void NumberOfCoin(int[] a, int count) {
    int Min[] = new int[count + 1];// ӲӲҵСĿ
    Min[0] = 0;//
    int minCoin = 0;//
    for (int i = 1; i < Min.length; i++) {
      minCoin = i;// iǲɱģÿһǺǰһص
      for (int j = 0; j < a.length; j++) {
        if (a[j] <= i && Min[i - a[j]] + 1 < minCoin) {
          minCoin = Min[i - a[j]] + 1;
        }
      }
      System.out.println(minCoin + "   i=" + i);
      Min[i] = minCoin;// ʱ临ӶΪO(n^2)
    }
    System.out.println(Min[11]);
  }

}
