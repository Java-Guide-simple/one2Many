package in.stack.one2manyEx.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.stack.one2manyEx.model.Order;
import in.stack.one2manyEx.util.HibernateUtil;

public class OrderDAO {

	public void saveOrder(Order or) {
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(or);
			trans.commit();

		} catch (Exception e) {

			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

	}

	public void updateOrder(Order acc) {
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.update(acc);
			trans.commit();

		} catch (Exception e) {

			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

	}
	
	public  void getCustomerByOrderId(int id) {

	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	Order order = session.get(Order.class, id);
	    	System.out.println(order);
	    	if(order != null){
	    		System.out.println(order.getCustomer()); 
	    	}
	    	System.out.println();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
	}
}

	
