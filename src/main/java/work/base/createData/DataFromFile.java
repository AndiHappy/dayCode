package work.base.createData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author zhailzh
 *
 */
public class DataFromFile {

  private static int linNumber = 15;

  public static void main(String[] args) {
    // creatIntData(10000, 0, 1000, "intData.txt");
    int[] arr = readIntData(0, 100, new File("intData.txt"));
    System.out.println(Arrays.toString(arr));
  }

  public static File creatIntData(int num, int min, int max, File file) {

    try {
      OutputStream fos = new FileOutputStream(file, true);
      OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
      int value = 1;
      while (value < num) {
        String pro = (int) (Math.random() * (max - min) + min) + "";
        osw.write(pro);
        osw.write(" ");
        System.out.print(" " + pro);
        value++;
        if (value % linNumber == 0) {
          osw.write("\n");
        }
      }
      osw.flush();
      osw.close();
      fos.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return file;
  }

  public static int[] readIntDataByBytes(int begine, int length, File fileName) {
    int[] readData = new int[length];
    try {
      InputStream read = new FileInputStream(fileName);
      InputStreamReader inr = new InputStreamReader(read, "UTF-8");
      BufferedReader br = new BufferedReader(inr);
      String line = null;
      int i = 0;
      while ((line = br.readLine()) != null && i < length) {
        String[] temp = line.split(" ");
        for (int j = 0; j < temp.length && i < length; j++) {
          readData[i] = Integer.parseInt(temp[j]);
          i++;
        }
      }
      br.close();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return readData;
  }
  public static int[] readIntData(int begine, int length, File fileName) {
    int[] readData = new int[length];
    try {
      InputStream read = new FileInputStream(fileName);
      InputStreamReader inr = new InputStreamReader(read, "UTF-8");
      BufferedReader br = new BufferedReader(inr);
      String line = null;
      int i = 0;
      while ((line = br.readLine()) != null && i < length) {
        String[] temp = line.split(" ");
        for (int j = 0; j < temp.length && i < length; j++) {
          readData[i] = Integer.parseInt(temp[j]);
          i++;
        }
      }
      br.close();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return readData;
  }

  public static int[] readIntData(int begine, int length) {

    File file = new File("intData.txt");
    int[] readData = new int[length];
    try {
      if (!file.exists()) {
        file.createNewFile();
        creatIntData(10000, 0, 1000, file);
      }

      InputStream read = new FileInputStream(file);
      InputStreamReader inr = new InputStreamReader(read, "UTF-8");
      BufferedReader br = new BufferedReader(inr);
      String line = null;
      int i = 0;
      while ((line = br.readLine()) != null && i < length) {
        String[] temp = line.split(" ");
        for (int j = 0; j < temp.length && i < length; j++) {
          readData[i] = Integer.parseInt(temp[j]);
          i++;
        }
      }
      br.close();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return readData;
  }

}
