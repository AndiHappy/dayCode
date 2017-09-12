package unittest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class JavaTest {

	// HashSet不保证集合的迭代顺序；也许在某些时间迭代的顺序与插入顺序一致，但是不保证该顺序恒久不变。
	private static Set<Integer> mSetInt = new HashSet<Integer>();
	private static Set<String> mSetString = new HashSet<String>();

	// LinkedHashSet按照元素插入的顺序进行迭代，LinkedHashSet不是线程安全的。
	private static Set<Integer> mLinkedSetInt = /*
												 * Collections.synchronizedSet(
												 */new LinkedHashSet<Integer>()/* ) */;
	private static Set<String> mLinkedSetString = /*
													 * Collections.
													 * synchronizedSet(
													 */new LinkedHashSet<String>()/* ) */;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 50; i++) {
			// mSetInt.add(i);
			mSetString.add(String.valueOf(i));
			// mLinkedSetInt.add(i);
			mLinkedSetString.add(String.valueOf(i));
		}

		// Iterator<Integer> setIntIt = mSetInt.iterator();
		// System.out.println("The sequence of HashSet for Integer:");
		// while (setIntIt.hasNext()) {
		// System.out.print(setIntIt.next() + " ");
		// }
		// System.out.println();

		System.out.println("The sequence of HashSet for String:");
		Iterator<String> setStringIt = mSetString.iterator();
		while (setStringIt.hasNext()) {
			System.out.print(setStringIt.next() + " ");
		}
		System.out.println();

		// System.out.println("The sequence of LinkedHashSet for Integer:");
		// Iterator<Integer> linkedSetIntIt = mLinkedSetInt.iterator();
		// while (linkedSetIntIt.hasNext()) {
		// System.out.print(linkedSetIntIt.next() + " ");
		// }
		// System.out.println();

		System.out.println("The sequence of LinkedHashSet for String:");
		Iterator<String> linkedSetStringIt = mLinkedSetString.iterator();
		while (linkedSetStringIt.hasNext()) {
			System.out.print(linkedSetStringIt.next() + " ");
		}
		System.out.println();
	}

}