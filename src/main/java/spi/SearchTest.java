package spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SearchTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Search search = SearchFactory.newSearch();
		search.serch("java spi test");
	}
}