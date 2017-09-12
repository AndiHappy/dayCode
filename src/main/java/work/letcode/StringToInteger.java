package work.letcode;

/**
 * @author zhailzh
 * 
 * @Date 2015��12��3��������10:15:21
 * 
 */
public class StringToInteger {

	public static void main(String[] args) {
		StringToInteger inoc = new StringToInteger();
		System.out.println(inoc.myAtoi("-2147483648"));
		System.out.println(Integer.parseInt("234234325325325235252"));

	}

	public int myAtoi(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		str = str.trim();
		char fhao = str.charAt(0);
		int fh = fhao == '-' ? -1 : 1;
		long value = 0;
		int i = (fhao == '-' | fhao == '+') ? 1 : 0;
		while (i < str.length()) {
			char temp = str.charAt(i);
			if (temp >= '0' && temp <= '9') {
				value = Character.digit(str.charAt(i), 10) + value * 10;
				if (fh * value > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				if (fh * value < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			} else {
				return (int) (fh * value);
			}
			i++;
		}
		return (int) (fh * value);
	}

}
