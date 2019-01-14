package matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {
	
//	? 通配符匹配文件名中的 0 个或 1 个字符，
			
//	* 通配符匹配零个或多个字符
			
		
			
	static Pattern p0 = Pattern.compile("a[^\\s]*");
	static Pattern p00 = Pattern.compile("a(\\w)?");
	
	//匹配网址 ^\\s A non-whitespace character 标识的非空的字符串
	static Pattern p01 = Pattern.compile("[a-zA-z]+://[^\\s]*");

	static Pattern p02 = Pattern.compile("https://www.google.com/url{1}+\\?q={1}+[^\\s]*");

	
	static Pattern p1 = Pattern.compile("a*b");
	
	
	static Pattern p2 = Pattern.compile(".*google.*|.*qidian.*");

	static Pattern p3 = Pattern.compile("[^第]");
	
	public static void main(String[]  args){
		 Matcher m0 = p0.matcher("ab");
		 System.out.println( m0.matches());
		 
		 System.out.println( p00.matcher("aaa").matches());
		 
		 System.out.println( p01.matcher("http://www.bai.com").matches());

		 
		 Matcher m1 = p1.matcher("aaaaab");
		 System.out.println( m1.matches());
		 
		 String value = "https://www.google.com/url?q=https%3A%2F%2Ftw.hjwzw.com%2FBook%2FChapter%2F32261&sa=U&ved=0ahUKEwjanrqDwv3cAhUEy7wKHeo6DVMQFgg0MAU&usg=AOvVaw0s5YbaHxM1Tb2nihgRc4Ut";
		 System.out.println( p02.matcher(value).matches());
		 
		 System.out.println( p2.matcher("googledsad ddada dsaqidianddd ddd").matches());

		 System.out.println( p3.matcher("第大大。章。").matches());
		 
		 String content = "第十二章 三生石,有这东西?";
		 Pattern p4 = Pattern.compile("第*");
		System.out.println(p4.matcher(content).matches());

	}

}
