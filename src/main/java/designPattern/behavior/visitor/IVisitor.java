package designPattern.behavior.visitor;
public interface IVisitor {
//	   public void visit(Customer customer);
//	   public void visit(Order order);
	   public void visit(IVisitable item); 
}