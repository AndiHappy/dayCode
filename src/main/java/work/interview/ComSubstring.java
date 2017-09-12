package work.interview;

public class ComSubstring {

  //  最长公共子序列（动态规划），
  //  最长公共子串（动态规划），
  //  最长回文子串（动态规划，后缀数组），
  //  最长重复子串（后缀数组），
  //  最长不重复子串（hash,动态规划，hash+动态规划）

  public static void main(String[] arg) {
    String a = "blog.csdn.net";
    String b = "csdn.blogt";
    comSubstring(a, b);
  }

  private static void comSubstring(String str1, String str2) {
    char[] a = str1.toCharArray();
    char[] b = str2.toCharArray();
    int a_length = a.length;
    int b_length = b.length;
    int[][] lcs = new int[a_length + 1][b_length + 1];
    // 初始化数组  
    for (int i = 0; i <= b_length; i++) {
      for (int j = 0; j <= a_length; j++) {
        lcs[j][i] = 0;
      }
    }
    //记录的是两个序列，最长匹配的最长序列的长度
    for (int i = 1; i <= a_length; i++) {
      for (int j = 1; j <= b_length; j++) {
        if (a[i - 1] == b[j - 1]) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        }
        if (a[i - 1] != b[j - 1]) {
          lcs[i][j] = lcs[i][j - 1] > lcs[i - 1][j] ? lcs[i][j - 1] : lcs[i - 1][j];
        }
      }
    }
    // 输出数组结果进行观察  
    for (int i = 0; i <= a_length; i++) {
      for (int j = 0; j <= b_length; j++) {
        System.out.print(lcs[i][j] + ",");
      }
      System.out.println("");
    }
    //有了最长的值，怎么构造出最小公共字符串  
    int max_length = lcs[a_length][b_length];
    char[] comStr = new char[max_length];
    int i = a_length, j = b_length;
    while (max_length > 0) {
      if (lcs[i][j] != lcs[i - 1][j - 1]) {
        if (lcs[i - 1][j] == lcs[i][j - 1]) {//两字符相等，为公共字符  
          comStr[max_length - 1] = a[i - 1];
          max_length--;
          i--;
          j--;
        } else {//取两者中较长者作为A和B的最长公共子序列  
          if (lcs[i - 1][j] > lcs[i][j - 1]) {
            i--;
          } else {
            j--;
          }
        }
      } else {
        i--;
        j--;
      }
    }
    System.out.print("最长公共字符串是：");
    System.out.print(comStr);
  }
  
  

}

/*最长公共子串问题：一个给定序列的子序列是在该序列中删去若干元素后得到的序列。给定两个序列X和Y，当另一序列Z既是X的子序列又是Y的子序列时，称Z 是序列X和Y的公共子序列。最长公共子串就是求给定两个序列的一个最长公共子序列。例如，X=“COBEBRANT”，Y=“COBAT”是X的一个子序列。

问题分析：

给定两个序列A和B，称序列Z是A和B的公共子序列，是指Z同是A和B的子序列。问题要求已知两序列A和B的最长公共子序列。如采用列举A的所有子序列，并一一检查其是否又是B的子序列，并随时记录所发现的子序列，最终求出最长公共子序列。这种方法因耗时太多而不可取。

考虑最长公共子序列问题如何分解成子问题，设A=“a0，a1，…，am-1”，B=“b0，b1，…，bm-1”，并Z=“z0，z1，…，zk-1” 为它们的最长公共子序列。
不难证明有以下性质：

（1） 如果am-1=bn-1，则zk-1=am-1=bn-1，且“z0，z1，…，zk-2”是“a0，a1，…，am-2”和“b0，b1，…，bn- 2”的一个最长公共子序列；

（2） 如果am-1!=bn-1，则若zk-1!=am-1，蕴涵“z0，z1，…，zk-1”是“a0，a1，…，am-2”和“b0，b1，…，bn-1” 的一个最长公共子序列；

（3） 如果am-1!=bn-1，则若zk-1!=bn-1，蕴涵“z0，z1，…，zk-1”是“a0，a1，…，am-1”和“b0，b1，…，bn-2” 的一个最长公共子序列。

这样，在找A和B的公共子序列时，如有am-1=bn-1，则进一步解决一个子问题，找“a0，a1，…，am-2”和“b0，b1，…，bm-2”的一个最长公共子序列；
如果am-1!=bn-1，则要解决两个子问题，找出“a0，a1，…，am-2”和“b0，b1，…，bn-1”的一个最长公共子序列和
找出“a0，a1，…，am-1”和“b0，b1，…，bn-2”的一个最长公共子序列，再取两者中较长者作为A和B的最长公共子序列。

为了节约重复求相同子问题的时间，引入一个数组，不管它们是否对最终解有用，把所有子问题的解存于该数组中，这就是动态规划法所采用的基本方法，具体说明如下。

定义lcs[i][j]为序列“a0，a1，…，ai-2”和“b0，b1，…，bj-1”的最长公共子序列的长度，计算lcs[i][j]可递归地表述如下：

（1）lcs[i][j] = 0                         如果i=0或j=0；

（2）lcs[i][j] = c[i-1][j-1]+1             如果i,j>0，且a[i-1] = b[j-1]；

（3）lcs[i][j] = max{c[i][j-1], c[i-1][j]} 如果i,j>0，且a[i-1] != b[j-1]。

按此算式可写出计算两个序列的最长公共子序列的长度函数。由于c[i][j]的产生仅依赖于lcs[i-1][j-1]、lcs[i-1][j]和lcs[i][j- 1]，故可以从lcs[m][n]开始，跟踪lcs[i][j]的产生过程，逆向构造出最长公共子序列。细节见程序。

package com.algorithm;  
 
//动态规划实现最小公共字符串问题  
public class ComSubstr {  
 
   public static void main(String[] arg) {  
       String a = "blog.csdn.net";  
       String b = "csdn.blogt";  
       comSubstring(a, b);  
   }  
 
   private static void comSubstring(String str1, String str2) {  
       char[] a = str1.toCharArray();  
       char[] b = str2.toCharArray();  
       int a_length = a.length;  
       int b_length = b.length;  
       int[][] lcs = new int[a_length + 1][b_length + 1];  
       // 初始化数组  
       for (int i = 0; i <= b_length; i++) {  
           for (int j = 0; j <= a_length; j++) {  
               lcs[j][i] = 0;  
           }  
       }  
       for (int i = 1; i <= a_length; i++) {  
           for (int j = 1; j <= b_length; j++) {  
               if (a[i - 1] == b[j - 1]) {  
                   lcs[i][j] = lcs[i - 1][j - 1] + 1;  
               }  
               if (a[i - 1] != b[j - 1]) {  
                   lcs[i][j] = lcs[i][j - 1] > lcs[i - 1][j] ? lcs[i][j - 1]  
                           : lcs[i - 1][j];  
               }  
           }  
       }  
       // 输出数组结果进行观察  
       for (int i = 0; i <= a_length; i++) {  
           for (int j = 0; j <= b_length; j++) {  
               System.out.print(lcs[i][j]+",");  
           }  
           System.out.println("");  
       }  
       // 由数组构造最小公共字符串  
       int max_length = lcs[a_length][b_length];  
       char[] comStr = new char[max_length];  
       int i =a_length, j =b_length;  
       while(max_length>0){  
           if(lcs[i][j]!=lcs[i-1][j-1]){  
               if(lcs[i-1][j]==lcs[i][j-1]){//两字符相等，为公共字符  
                   comStr[max_length-1]=a[i-1];  
                   max_length--;  
                   i--;j--;  
               }else{//取两者中较长者作为A和B的最长公共子序列  
                   if(lcs[i-1][j]>lcs[i][j-1]){  
                       i--;  
                   }else{  
                       j--;  
                   }  
               }  
           }else{  
               i--;j--;  
           }  
       }  
       System.out.print("最长公共字符串是：");  
       System.out.print(comStr);  
   }  
}  


以下是程序输出结果：

0,0,0,0,0,0,1,2,2,2,2,  
0,0,0,0,0,0,1,2,3,3,3,  
0,0,0,0,0,0,1,2,3,4,4,  
0,0,0,0,0,1,1,2,3,4,4,  
0,1,1,1,1,1,1,2,3,4,4,  
0,1,2,2,2,2,2,2,3,4,4,  
0,1,2,3,3,3,3,3,3,4,4,  
0,1,2,3,4,4,4,4,4,4,4,  
0,1,2,3,4,5,5,5,5,5,5,  
0,1,2,3,4,5,5,5,5,5,5,  
0,1,2,3,4,5,5,5,5,5,5,  
0,1,2,3,4,5,5,5,5,5,6,  
最长公共字符串是：csdn.t  */