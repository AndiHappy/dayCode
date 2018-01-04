package unittest;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.expression.ParseException;
import org.springframework.mock.env.MockEnvironment;

/**
 * @author zhailzh
 * 
 * @Date 20151279:20:50
 * 
 */
@SuppressWarnings("deprecation")
public class CalculatorTest {

	private final Calculator calculator = new Calculator();

	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}

	/**
	 * Test method for {@link Calculator#add(int)}.
	 */
	@Test
	public final void testAdd() {
		calculator.add(2);
		calculator.add(3);
		assertEquals(5, calculator.getResult());
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 3, 4 });
		System.out.println("add is right");
	}

	/**
	 * Test method for {@link Calculator#substract(int)}.
	 */
	@Test
	public final void testSubstract() {
		calculator.square(4);
		int result = calculator.getResult();
		// жϷķؽ
		assertEquals(16, result);// һֵڶҪֵ֤
	}

	/**
	 * Test method for {@link Calculator#multiply(int)}.
	 */
	@Test
	public final void testMultiply() {
		calculator.multiply(3);
		calculator.multiply(4);
		assertEquals(0, calculator.getResult());
		MockEnvironment mockedList = new MockEnvironment();
		Map<String, Object> map = mockedList.getSystemEnvironment();
		for (String key : map.keySet()) {
			System.out.println(key + "  :  " + map.get(key));
		}
	}

	/**
	 * Test method for {@link Calculator#divide(int)}.
	 */
	@Test
	public final void testDivide() {
		calculator.divide(3);
		calculator.divide(4);
		assertEquals(0, calculator.getResult());
	}

//	@Test(timeout = 2000)
//	public void testTimeout1() throws InterruptedException {
//		Thread.sleep(2000);
//	}
//
//	@Test(timeout = 2000)
//	public void testTimeout() throws InterruptedException {
//		Thread.sleep(4001);
//	}
	
	@Test(expected=RuntimeException.class)
    public void testExceptions() throws InterruptedException {
        throw new RuntimeException();
    }
	
	
    @SuppressWarnings("rawtypes")
	@Parameters
    public static Collection getParamters() {

        String[][] object = {
                { "2011-07-01 00:20:20", "yyyyMMdd", "20110701" },
                { "2011-07-01 00:20:20", "yyyyMMdd", "20110701" },
                { "2011-07-01 00:20:20", "HHʱmmss", "00ʱ2020" } };
        List<String[]> list = Arrays.asList(object);
        return  list;
    }

    @Test
    public void testJunitParameter() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Collection list = this.getParamters();
       assertArrayEquals(list.toArray(),list.toArray());

    }
    
    
   
}