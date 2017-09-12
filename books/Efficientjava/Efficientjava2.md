#### 1.枚举类型替代int

* An enumerated type is a type whose legal values consist of a fixed set of constants,such as the seasons of the year, the planets in the solar system, or the suits in a deck of playing cards. Before enum types were added to the language, a common pattern for representing enumerated types was to declare a group of named
int constants, one for each member of the type

* The basic idea behind Java’s enum types is simple: they are classes that export one instance for each enumeration constant via a public static final field.

* 总体而言，枚举的比int类型的优势明显，枚举易读，更加的安全，功能比较的强大。许多的枚举不需要显示的构造器或者成员，但是其他枚举则受益于：每一个常量与属性的关联以及 提供行为受这个属性影响的方法。如果多个枚举常量共享相同的行为，则考虑枚举。

#### 2.用实例域代替序数

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
package enumexample;

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
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
