package designPattern.behavior.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerGroup {

  private ArrayList<Customer> customers = new ArrayList<Customer>();

  public void accept(IVisitor visitor) {
    for (Iterator<Customer> it = customers.iterator(); it.hasNext();) {
      ((Customer) it.next()).accept(visitor);
    }
  }

  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

}