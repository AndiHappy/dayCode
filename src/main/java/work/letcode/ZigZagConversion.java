package work.letcode;

import java.util.Arrays;

/**
 * @author zhailzh
 * 
 * @Date 20151212:28:11 ַת
 */
public class ZigZagConversion {

	public static String convert(String s, int numRows) {
	    if(numRows<=1) return s;
	    StringBuilder sb = new StringBuilder();
	    //ѭ
	    int guilushu = 2*(numRows -1);
	    
	    for (int i = 0; i < numRows; i++) {
			//sбе
	    	for (int j = i; j < s.length(); j++) {
	    		if(j%guilushu  == i || j%guilushu == (guilushu - i)){
	    			System.out.print(" "+j);
	    			sb.append(s.charAt(j));
	    		}
			}
	    	System.out.println();
		}
	    return sb.toString();
	}
	
	/**
	 * ͨռлȡٶ
	 * */
	public String convertbyKongJian(String s, int nRows) {
        if(nRows <= 1)
            return s;
        StringBuilder[] list = new StringBuilder[nRows];
        for(int i = 0; i < nRows; i++)
            list[i] = new StringBuilder();
        int row = 0;
        int i = 0;
        boolean down = true;
        while(i < s.length()){
            list[row].append(s.charAt(i));
            if(row == 0){
                down = true;
            }
            if(row == nRows - 1){
                down = false;
            }
            if(down){
                row++;
            }
            else{
                row--;
            }
            i++;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list)
            res.append(sb.toString());
        return res.toString();
    }
	
	

//	P   A   H   N
//	A P L S I I G
//	Y   I   R
	
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));

	}

}
