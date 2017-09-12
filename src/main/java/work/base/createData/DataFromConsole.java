package work.base.createData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author zhailzh 从控制台直接的循环的读入数据
 */
public class DataFromConsole {

  public static String getDataFromConsole() throws IOException {
    BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
    String str = strin.readLine();
    strin.close();
    return str;
  }

  public static String getDataFromScanner() {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    sc.close();
    return line;

  }

  public static void main(String[] args) throws IOException {
    getDataFromConsole();
    System.out.println(getDataFromScanner());
  }

}
