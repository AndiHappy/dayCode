package work.algprithm;

import java.util.ArrayList;
import java.util.List;

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
