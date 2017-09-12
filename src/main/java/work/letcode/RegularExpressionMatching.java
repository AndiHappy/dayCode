package work.letcode;

/**
 * @author zhailzh
 * 
 * @Date 2015��12��8��������4:11:06
 * 
 */
public class RegularExpressionMatching {

	// Implement regular expression matching with support for '.' and '*'.
	//
	// '.' Matches any single character.
	// '*' Matches zero or more of the preceding element.
	//
	// The matching should cover the entire input string (not partial).
	//
	// The function prototype should be:
	// bool isMatch(const char *s, const char *p)
	//
	// Some examples:
	// isMatch("aa","a") �� false
	// isMatch("aa","aa") �� true
	// isMatch("aaa","aa") �� false
	// isMatch("aa", "a*") �� true
	// isMatch("aa", ".*") �� true
	// isMatch("ab", ".*") �� true
	// isMatch("aab", "c*a*b") �� true

	public static boolean isMatch(String s, String p) {
		if (s == null && p == null)
			return true;
		if (s == null || p == null)
			return false;
		return isMatch(s, 0, p, 0);
	}

	
	
	
	

	public static boolean isMatch(String s, int sstart, String p, int pstart) {
		//�ϸ��λ�ñȶ�
		if (s.length() == sstart && p.length() == pstart)
			return true;
		//pstart��λ���������p.length() -1 ��ֱ�ӵı�������
		if (p.length() == pstart)
			return false;
		if (s.length() == sstart) {
			
			if (pstart + 1 >= p.length() || p.charAt(pstart + 1) != '*') {
				return false;
			}
			//���������* ����Ҫ�ѱȶԵ�λ��Ǩ��2
			return isMatch(s, sstart, p, pstart + 2);
		}
		
		//*ƥ�����ǰ׺
		if (pstart + 1 <= p.length() - 1 && p.charAt(pstart + 1) == '*') {
			//����.* ���������Ҫ�ȶԵ������ֵ����
			if (s.charAt(sstart) == p.charAt(pstart) || p.charAt(pstart) == '.') {
				return isMatch(s, sstart + 1, p, pstart) || isMatch(s, sstart, p, pstart + 2);
			}
			return isMatch(s, sstart, p, pstart + 2);
		} else if (p.charAt(pstart) == '.') {
			return isMatch(s, sstart + 1, p, pstart + 1);
		} else {
			return p.charAt(pstart) == s.charAt(sstart) && isMatch(s, sstart + 1, p, pstart + 1);
		}
	}

	public static void main(String[] args) {
		RegularExpressionMatching na = new RegularExpressionMatching();
		boolean result = na.isMatch("asdaab", "c*a*b") == na.isMatch("asdaab",0, "c*a*b",0);
		System.out.println(result);
		
		boolean result2 = na.isMatch("a", "c") == na.isMatch("a",0, "c",0);
		System.out.println(result2);

		boolean result1 = na.isMatch("a", "a*") ;
		na.isMatch("aaa",0, "aaa*",0);
		System.out.println(result1);
		
		isMatch("aa","a") ;
		 isMatch("aa","aa");
		 isMatch("aaa","aa") ;
		 isMatch("aa", "a*");
		 isMatch("aa", ".*");
		 isMatch("ab", ".*");
		 isMatch("aab", "c*a*b") ;
	}

}
