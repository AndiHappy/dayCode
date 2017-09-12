package work.algprithm;

/**
 * @author zhailzh
 * 
 * @Date 2016��2��25��������2:57:05
 * 
 */
public class Longest_common_substring {
	// 719183608707
	// Create a table to store lengths of longest common suffixes of
	// substrings. Notethat LCSuff[i][j] contains length of longest
	// common suffix of X[0..i-1] and Y[0..j-1]. The first row and
	// first column entries have no logical meaning, they are used only
	// for simplicity of program
	public static String longest_common_substring(String s1, String s2) {
		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = s1.length();
		int n = s2.length();
		int[][] LCSuff = new int[m + 1][n + 1];
		int result = 0; // To store length of the longest common substring
		int to = 0;
		/* Following steps build LCSuff[m+1][n+1] in bottom up fashion. */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					LCSuff[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1]) {
					LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
					if (LCSuff[i][j] > result) {
						to = j;
					}
					result = Math.max(result, LCSuff[i][j]);

				} else
					LCSuff[i][j] = 0;
			}
		}

		return s2.substring(to - result, to);
	}

	public static void main(String[] args) {
		String value = longest_common_substring("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com");
		System.out.println(value);
	}

}
