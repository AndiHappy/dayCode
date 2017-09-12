package enumexample;

import java.util.EnumSet;

public enum Ensemble {
  SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(
      8), NONET(9), DECTET(10), TRIPLE_QUARTET(12);
  private final int numberOfMusicians;

  Ensemble(int size) {
    this.numberOfMusicians = size;
  }

  public int numberOfMusicians() {
    return numberOfMusicians;
  }

  public static void main(String[] args) {
    System.out.println(SOLO.numberOfMusicians());
    System.out.println(SOLO.ordinal());

    // 同事应用两个枚举的形式
    EnumSet<Ensemble> value = EnumSet.of(SOLO, DUET);
    System.out.println(value);
  }
}
