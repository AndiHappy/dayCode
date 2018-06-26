package spi;

import java.util.Arrays;
import java.util.List;

public class SearchImplA implements Search {

	@Override
	public List<?> serch(String keyword) {
		
		return Arrays.asList("A: "+ keyword);
	}

}
