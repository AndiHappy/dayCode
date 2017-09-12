package work.interview;

public class LongestComSubstring {
	/***
	 * 分析原理
	 * 
	 * c1,c2,c3,......,ck 为A序列 a1,a2,a3,......,ai 和 b1,b2,b3,......,bj 的最长的公共的子串
	 * 分析递推的规律： 
	 * 如果ai = bj 那么 ck = ai 并且 c1,c2,c3,......,ck-1 为 a1,a2,a3,......,ai-1 和 b1,b2,b3,......,bj-1 的最长的公共的子串 
	 * 
	 * 如果ai != bj 并且 ck !=ai 并且 c1,c2,c3,......,ck 为 a1,a2,a3,......,ai-1 和 b1,b2,b3,......,bj 的最长的公共的子串 
	 * 
	 * 如果ai != bj 并且 ck != bj 并且 c1,c2,c3,......,ck 为a1,a2,a3,......,ai 和 b1,b2,b3,......,bj-1 的最长的公共的子串
	 * 
	 * 分析到这个地方，感觉和最长的子序列没有什么区别，接着来，那么我们定义一个数组定义子问题：LS[i][j] 最长子串的长度
	 * 
	 * ls[i][j] = 0 如果i = 0 或者 j=0 
	 * 
	 * ls[i][j] = ls[i-1][j-1] +1 如果a[i] = b[j]
	 * 
	 * ls[i][j] = max{ls[i][j-1],ls[i-1][j]} 如果a[i] != b[j]
	 * 上面的这个递推的条件不一样，不然就是公共子序列了，子串的递推是不一样的，如果是一样的话，那么代码就是一样的，求出来
	 * 的值就是公共的子序列，而不是子串
	 * 
	 * 由此我们可以推断出来，我们定义的子问题有错误吗？还是我们的而递归的定义的有问题？仔细的分析：
	 * 
	 *  ls[i][j] = max{ls[i][j-1],ls[i-1][j]} 如果a[i] != b[j]
	 * 我们并没有要求连续相等的要求，因为公共子串是要求连续相等的，连续相等在数组中的定义就是要求：ls[i-1][j-1]必须是1，那么我们
	 * 的子问题就是ls[i][j] 最长公共子串的长度,我们的
	 * ls[i][j] = 0 如果i = 0 或者 j=0 
	 * ls[i][j] = ls[i-1][j-1] +1 如果a[i] = b[j]
	
	 * 因为要求子串连续，所以对于 Xi 与 Yj 来讲，它们要么与之前的公共子串构成新的公共子串；要么就是不构成公共子串。故状态转移方程
	 * 
	 * ls[i][j] = 0 如果i = 0 或者 j=0 或者 a[i] != b[j]
	 * ls[i][j] = ls[i-1][j-1] +1 如果a[i] = b[j]
	 */

	public static String longestComSubstring(String A, String B) {
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] ls = new int[A.length()+1][B.length()+1];
		int max  = 0;int ii = 0;int jj =0;
		for (int j = 1; j <= B.length(); j++) {
			for (int i = 1; i <= A.length(); i++) {
				if (a[i-1] == b[j-1]) {
					ls[i][j] = ls[i - 1][j - 1] + 1;
					if(ls[i][j] > max){
						max = ls[i][j];
						ii = i;jj=j;
					}
				} 
			}
		}

		for (int j = 0; j <= B.length(); j++) {
			for (int i = 0; i <= A.length(); i++) {
				System.out.print(ls[i][j]);
			}
			System.out.println();
		}
		
		StringBuffer builder = new StringBuffer();
		for (;  ii > 0 && jj> 0; ii--,jj--) {
			if(ls[ii][jj] > 0){
				builder.append(a[ii]);
			}
		}
		
		
		return builder.toString();
	}

	public static void main(String[] args) {
		String value = longestComSubstring("12544567890123", "35456780");
		System.out.println(value);
	}
}
