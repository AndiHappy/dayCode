package work.algprithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 用1、2、2、3、4、5这六个数字，用java写一个main函数，打印出所有不同的排列，如：512234、412345等，
 * 要求："4"不能在第三位，"3"与"5"不能相连
 * 
 */
public class Quanpailie {
	public static int total = 0;

	public static void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	public static void arrange(char[] str, int st, int len) {
		if (st == len - 1) {
			System.out.println(new String(str));
			total++;
		} else {
			for (int i = st; i < len; i++) {
				swap(str, st, i);
				arrange(str, st + 1, len);
				swap(str, st, i);
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char str[] = { 'a', 'b', 'c', 'd', 'e' };
		arrange(str, 0, str.length);
		System.out.println(total);
	}
}
