package unittest;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhailzh
 * 
 * @Date 201512711:23:02
 * 
 */
public class EasyMockTest {
	public ShoppingCart cart = null;  
	    public Store storeMock = null;  
	      
	    @Before  
	    public void initialize()  
	    {     
	        cart = new ShoppingCart();  
	        storeMock = EasyMock.createMock(Store.class);  
	        cart.setStore(storeMock);  
	    }  
	      
	      
	    @Test       
	    public void testShoppingCart()  
	    {  
	      
	          
	        EasyMock.expect(storeMock.getPrice("Mead Spiral Bound Notebook, College Rule")).andReturn(5.99);  
	        EasyMock.expect(storeMock.getPrice("Kindle Fire HD 8.9")).andReturn(499.99);  
	          
	            //ʼʹmock  
	        EasyMock.replay(storeMock);  
	                  
	        Item item1 = new Item("Mead Spiral Bound Notebook, College Rule", 3);  
	        Item item2 = new Item("Kindle Fire HD 8.9",1);  
	          
	        cart.addItem(item1);  
	        cart.addItem(item2);  
	          
	        double total = cart.calculateTotal();  
	          
	        System.out.println("Total price of items in shopping cart: $"+total);  
	        assertEquals("Result",505.96, total,0);  
	    }  
	      
	    @After  
	    public void cleanup()   
	    {  
	        cart=null;  
	        storeMock=null;  
	    }  
	      
}

