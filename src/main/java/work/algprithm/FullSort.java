package work.algprithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullSort {  
    //将NUM设置为待排列数组的长度即实现全排列  
    private static int NUM = 2;  
  
    /** 
     * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现全排列 
     * 
     * @param datas 
     * @param target 
     */  
    private static void sort(List<String> datas, List<String> target) {  
        if (target.size() == NUM) {  
            for (Object obj : target)  
                System.out.print(obj);  
            System.out.println();  
            return;  
        }  
        for (int i = 0; i < datas.size(); i++) {  
            List<String> newDatas = new ArrayList<String>(datas);  
            List<String> newTarget = new ArrayList<String>(target);  
            newTarget.add(newDatas.get(i));  
            newDatas.remove(i);  
            sort(newDatas, newTarget);  
        }  
    }  
  
    public static void main(String[] args) {  
//        String[] datas = new String[] { "a", "b"/*, "c", "d" */};  
//        sort(Arrays.asList(datas), new ArrayList<String>()); 
        
        
    	FullSort p = new FullSort();  
        StringBuffer buffer = new StringBuffer();  
        String input = "ABCD";  
        for (int i = 0; i < input.length(); i++) {  
            p.permutation(input, i, buffer);  
        }  
    }  
    
    
    
    /** 
     * recursive method, used for the tree traversal. 
     *  
     * @param inStr 
     *            the elements need to be choose 
     * @param pos 
     *            the position of the elements we choose 
     * @param parentData 
     *            the elements have been chosen 
     */  
    public void permutation(String inStr, int pos, StringBuffer parentData) {  
        if (inStr.length() == 0) {  
            return;  
        }  
        if (inStr.length() == 1) {  
            System.out.println("{" + inStr + "}");  
            return;  
        }  
        // here we need a new buffer to avoid to pollute the other nodes.  
        StringBuffer buffer = new StringBuffer();  
        // copy from the parent node  
        buffer.append(parentData.toString());  
  
        // choose the element  
        buffer.append(inStr.charAt(pos));  
  
        // get the remnant elements.  
        String subStr = kickChar(inStr, pos);  
  
        // got one of the result  
        if (subStr.length() == 1) {  
            buffer.append(subStr);  
            System.out.println(buffer.toString());  
            return;  
        }  
  
        // here we use loop to choose other children.  
        for (int i = 0; i < subStr.length(); i++) {  
            permutation(subStr, i, buffer);  
        }  
  
    }  
  
    // a simple method to delete the element we choose  
    private String kickChar(String src, int pos) {  
        StringBuffer srcBuf = new StringBuffer();  
        srcBuf.append(src);  
        srcBuf.deleteCharAt(pos);  
        return srcBuf.toString();  
    }  
  
}  