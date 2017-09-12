package designPattern.behavior.visitor;
public class GeneralReport implements IVisitor{

	private int customersNo;
	private int ordersNo;
	private int itemsNo;

	public void visit(Customer customer)
	{
		System.out.println(customer.getName());
		customersNo ++;
	}
	public void visit(Order order)
	{
		System.out.println(order.getName());
		ordersNo++;
	}
	public void visit(Item item)
	{
		System.out.println(item.getName());
		itemsNo++;
	}

	public void displayResults()
	{
		System.out.println("Nr of customers:" + customersNo);
		System.out.println("Nr of orders:   " + ordersNo);
		System.out.println("Nr of itemss:   " + itemsNo);
	}
	@Override
	public void visit(IVisitable item) {
		if(item instanceof Item){
			System.out.println(((Item)item).getName());
			itemsNo++;
		}
		
		if(item instanceof Order){
			System.out.println(((Order) item).getName());
			ordersNo++;
		}
		
		if(item instanceof Customer){
			System.out.println(((Customer) item).getName());
			customersNo ++;
		}
	}
}