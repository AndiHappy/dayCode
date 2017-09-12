package work.interview;

import java.io.File;

/**
 * @author zhailz
 *
 * 时间：2016年7月6日 ### 下午4:36:43
 */
public class PrintTreeView {

  public static void main(String[] args){
    File file = new File("");
    System.out.println(file.getAbsolutePath());
    File parent = new File(file.getAbsolutePath());
    if(parent.isDirectory()){
      File[] value = parent.listFiles();
      for (File file2 : value) {
        System.out.println(file2.getAbsolutePath());
      }
    }
  }
}
