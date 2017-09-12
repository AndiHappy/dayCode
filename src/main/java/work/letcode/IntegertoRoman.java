package work.letcode;

/**
 * @author zhailzh
 * 
 * @Date 2015��12��16��������9:03:39
 * 
 * ����ת��Ϊ��������
 * 
 * ���������
 * 
 */
public class IntegertoRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String intToRoman(int num) {
		//1000-3000
        String M[] = {"", "M", "MM", "MMM"};
        //100-900
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        //10-90
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        //0-9
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // is so beautiful
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
