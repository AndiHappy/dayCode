package work.algprithm;

/**
 * һеǽеĳȣõǶ̬滮ķ ˵ǽвҪ
 */
public class Al08MaxUpArray {

  public static void main(String[] args) {

    int[] array = new int[] { 1, 2, 3, 2, 6, 8, 9, 3, 6 };

    int length = getMaxUpArray(array);
    System.out.println(length);
  }

  private static int getMaxUpArray(int[] A) {
    int len = 1;
    // ı
    int[] d = new int[A.length];
    // ״̬תƷ
    // a(i) = max(1 , a(j)+1) i>j,A[i]> A[j] Ҫ
    // ״̬תƣôһԪһģȻҪάԭĳ
    for (int i = 0; i < A.length; i++) {
      d[i] = 1;
      // Ҫ£Ҫжϵmax(1 , a(j)+1)A[i]> A[j]
      for (int j = 0; j < i; ++j) {
        // ״̵̬תƵȷ֮
        boolean ji = A[j] <= A[i];
        boolean dji = d[j] + 1 > d[i];
        if (ji && dji) {
          d[i] = d[j] + 1;
        }
      }
      if (d[i] > len)
        len = d[i];
    }

    for (int i = 0; i < d.length; i++) {
      System.out.println("Ľֹ" + i + " ǽеĳΪ " + d[i]);
    }

    return len;
  }
}
