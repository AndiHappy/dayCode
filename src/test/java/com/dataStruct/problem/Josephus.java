package com.dataStruct.problem;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zha
 * 
 *         约瑟夫环的问题
 */
public class Josephus<T> {
	private Queue<T> queue;

	public Josephus(int length) {
		if (length <= 0)
			throw new IllegalArgumentException("Invalid length!");
		queue = new ArrayDeque<T>(length);
	}

	public void process(int interval) {
		if (interval <= 0)
			throw new IllegalArgumentException("Invalid interval");
		int length = queue.size();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < interval; j++) {
				T t = queue.remove();
				queue.add(t);
				System.out.println(queue.toString());
			}
			T removed = queue.remove();
			System.out.println(removed);
		}
	}

	public void add(T t) {
		queue.add(t);
	}

	public static void main(String[] args) {
		Josephus<Integer> josephus = new Josephus<Integer>(7);
		josephus.add(1);
		josephus.add(2);
		josephus.add(3);
		josephus.add(4);
		josephus.add(5);
		josephus.add(6);
		josephus.add(7);
		josephus.process(3);
	}
}