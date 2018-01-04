package work.algprithm;

/**
 * Implement an algorithm to determine if a string has all unique characters
 * What if you can not use additional data structures?
 */
public class Al07StringContainDoubleAlapt {

  private int countbits = Long.SIZE;

  private long flag = 1 << (countbits - 2);

  public boolean isUnique(String value) {

    if (value.length() > 26) {
      return false;
    }

    for (int i = 0; i < value.length(); i++) {
      int letter = value.charAt(i);
      long temp = flag & (1 << (letter - 'a'));
      if (temp == 0) {
        flag = flag | (1 << (letter - 'a'));
      } else {
        return false;
      }
    }

    return true;

  }

  public static void main(String[] args) {
    Al07StringContainDoubleAlapt yyy = new Al07StringContainDoubleAlapt();
    yyy.isUnique("dddadvsav");
  }
}
