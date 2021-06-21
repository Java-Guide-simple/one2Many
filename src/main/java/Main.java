import in.stack.one2manyEx.dao.CustomerDAO;
import in.stack.one2manyEx.dao.OrderDAO;
import in.stack.one2manyEx.model.Customer;
import in.stack.one2manyEx.model.Order;

public class Main {

	
	public static void main(String[] args) {
		Customer customer1 = new Customer();
		customer1.setName("Ramesh");
		customer1.setEmail("r@gmail.com");
		customer1.setMobile("678777878");
	
		Order order1= new Order();
		Order order2= new Order();
		
		
		customer1.getOid().add(order1);
		customer1.getOid().add(order2);
		
		order1.setCustomer(customer1);
		order2.setCustomer(customer1);
		
		
		CustomerDAO cDao= new CustomerDAO();
		cDao.saveCustomer(customer1);
		cDao.getCustomerByCustomerId(1);
		
		OrderDAO oDao = new OrderDAO();
		oDao.getCustomerByOrderId(1);
	}
}
