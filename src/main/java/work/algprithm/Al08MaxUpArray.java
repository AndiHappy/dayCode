package work.algprithm;

/**
 * ��һ�����е����ǽ������еĳ��ȣ����õ��Ƕ�̬�滮�ķ��� ˵������ǽ������в�Ҫ������
 */
public class Al08MaxUpArray {

  public static void main(String[] args) {

    int[] array = new int[] { 1, 2, 3, 2, 6, 8, 9, 3, 6 };

    int length = getMaxUpArray(array);
    System.out.println(length);
  }

  private static int getMaxUpArray(int[] A) {
    int len = 1;
    // �������������ı���
    int[] d = new int[A.length];
    // ״̬ת�Ʒ���
    // a(i) = max(1 , a(j)+1) ����i>j,����A[i]> A[j] ��Ҫ������
    // �������״̬ת�ƣ���ô����һ��Ԫ��һ�������ģ���Ȼ��Ҫά��ԭ���ĳ���
    for (int i = 0; i < A.length; i++) {
      d[i] = 1;
      // ��Ҫ������������£���Ҫ���жϵ���������������max(1 , a(j)+1)��A[i]> A[j]
      for (int j = 0; j < i; ++j) {
        // ״̬���̵�ת�Ƶ�ȷ�������������֮��
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
      System.out.println("����Ľ�ֹ����" + i + " ���ǽ������еĳ���Ϊ�� " + d[i]);
    }

    return len;
  }
}
