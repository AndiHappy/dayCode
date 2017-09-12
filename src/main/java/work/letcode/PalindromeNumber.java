package work.letcode;

/**
 * @author zhailzh
 * 
 * @Date 2015��12��3��������7:19:03
 * 
 * �������֣������ö���Ŀռ�
 */
public class PalindromeNumber {

	public static void main(String[] args) {
			System.out.println(isPalindromeNumber(121));

	}

	
	public static boolean isPalindromeNumber(int num){
		int sum = num;
		int temp = 0;
		while(sum != 0){
			temp = temp*10 + sum %10;
			sum = sum /10;
		}
		return temp == num;
	}
	
}
