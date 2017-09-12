package work.algprithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author praveennin
 */
public class SmallFactorials {

  public static void main(String a[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String lines = br.readLine();
    int numberOfLines = Integer.parseInt(lines);

    int testCaseValues[] = new int[numberOfLines];

    for (int i = 0; i < numberOfLines; i++) {

      String input = br.readLine();
      int testCaseValue = Integer.parseInt(input);
      testCaseValues[i] = testCaseValue;
    }

    BigInteger array[] = new BigInteger[numberOfLines];

    for (int i = 0; i < testCaseValues.length; i++) {

      array[i] = BigInteger.ONE;
      for (int j = 1; j <= testCaseValues[i]; j++) {
        BigInteger bi = BigInteger.valueOf(j);
        array[i] = array[i].multiply(bi);
      }
    }

    for (int i = 0; i < array.length; i++) {

      System.out.println(array[i]);
    }
  }
}