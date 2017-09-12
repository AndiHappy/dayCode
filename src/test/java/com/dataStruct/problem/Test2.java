package com.dataStruct.problem;

import java.util.TreeMap;

public class Test2 {
	public void add(Byte b) {
		b = b++;
	}

	public void test() {
		while (true) {
			System.out.println("teemp");
		}
	}

	// public static void main(String[] args) {
	// Test2 dd = new Test2();
	// dd.test();
	// }

	public static void main(String[] args) {
		TreeMap<Integer, String> value = new TreeMap<Integer, String>();
		value.put(1, "aaa");
		value.put(2, "bbb");
		value.put(3, "aaa");
		value.put(10, "aaa");
		value.put(13, "aaa");
		value.put(1000, "aaa");
		value.put(145, "aaa");
		value.put(13, "aaa");
		value.put(12, "aaa");
		value.put(189, "aaa");
		System.out.println(value.toString());

	}
}
