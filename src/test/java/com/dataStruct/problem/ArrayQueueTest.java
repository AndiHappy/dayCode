package com.dataStruct.problem;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author zha
 *
 */
public class ArrayQueueTest {
  public static void main(String[] args) {
    ArrayDeque<String> que = new ArrayDeque<String>(10);
    que.add("first");
    que.add("second");
    que.add("third");
    que.add("four");
    que.add("five");
    System.out.println(Arrays.toString(que.toArray()));

  }

}
