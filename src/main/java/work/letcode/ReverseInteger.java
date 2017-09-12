package work.letcode;

/**
 * @author zhailzh
 * 
 * @Date 2015��12��2��������4:56:04
 * 
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {

	int reverse(int x) {
        // �ȷ����x����ֵ���ֺͷ��Ų���
        int y = Math.abs(x), z = x == y ? 1 : -1;
        // ��y�������һ��long�У�����������Խ��
        long tmp = 0;
        while (y != 0) {
            tmp = tmp * 10 + y % 10;
            y /= 10;
        }
        // �ж��Ƿ�Խ��
        if (z*tmp > Integer.MAX_VALUE || z*tmp < Integer.MIN_VALUE) return 0;
        // ���򷵻ط�ת���ֵ
        return (int) (z*tmp);
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
