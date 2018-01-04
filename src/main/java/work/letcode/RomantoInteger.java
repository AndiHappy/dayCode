package work.letcode;

import java.util.HashMap;

/**
 * @author zhailzh
 * 
 * @Date 201512189:20:53
 * 
 */
public class RomantoInteger {

	public static void main(String[] args) {
		RomantoInteger ri = new RomantoInteger();
		int value = ri.romanToInt("DXCXI");
		System.out.println(value);

	}

	 public int romanToInt(String s) {
	        //1510L50C100D500M1000 
	        // rules:λڴĺʱΪλڴǰΪ
	        //eg=3,=4,=6,=19,=20,L=45,MCMC=1980
	        //"DXCXI"
	        if(s == null || s.length() == 0) return 0;
	        int len = s.length();
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	        map.put('C',100);
	        map.put('D',500);
	        map.put('M',1000);
	        int result = map.get(s.charAt(len -1));
	        int pivot = result;
	        for(int i = len -2; i>= 0;i--){
	            int curr = map.get(s.charAt(i));
	            if(curr >=  pivot){
	                result += curr;
	            }else{
	                result -= curr;
	            }
	            pivot = curr;
	        }
	        return result;
	    }
}
