package work.letcode;

import javax.management.DescriptorKey;

/**
 * @author zhailzh
 * 
 * @Date 2015��11��16��������2:17:16 ��Ļ��Ĵ�
 * 
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String value = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
		LongestPalindromicSubstring lo = new LongestPalindromicSubstring();
		System.out.println(lo.longestPalindrome(value));
	}
	
	//��̬�滮��ʲôʱ��ʹ�ö�̬�滮��������Լ�����һ��ä��
	//
	public String longestPalindrome(String s) {
		  int n = s.length();
		  String res = null;

		  boolean[][] dp = new boolean[n][n];

		  for (int i = n - 1; i >= 0; i--) {
		    for (int j = i; j < n; j++) {
		      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

		      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
		        res = s.substring(i, j + 1);
		      }
		    }
		  }

		  return res;
		}

	//�����ƽ�,ֱ�ӵĳ�ʱ
	@Deprecated
	public String longestPalindrome_isWrong(String s) {
		int temp = 0;int tempi = 0; int tempj = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if(isPalind(s,i,j)){
					if(temp < (j-i+1)){
						temp = j-i+1;
						tempi =i;
						tempj =j;
					}
				}
			}
		}
		if(temp != 0){
			return s.substring(tempi, tempj);
		}
		return null;
	}
	
	
	public boolean isPalind(String value,int start ,int end){
	
		if(!value.isEmpty()){
			while(start <= end){
			 if(value.charAt(start) == value.charAt(end)){
				 start++;
				 end--;
			 }else{
				 return false;
			 }	
			}	
		}
		return true;
	}

}
