package in.stack.one2manyEx.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.stack.one2manyEx.model.Customer;
import in.stack.one2manyEx.util.HibernateUtil;

public class CustomerDAO {

	public void saveCustomer(Customer customer) {
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.persist(customer);
			session.getTransaction().commit();
			;

		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateCustomer(Customer customer) {
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.update(customer);
			trans.commit();

		} catch (Exception e) {

			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

	}

	public void deleteCustomer(int id) {
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();

			Customer target = session.get(Customer.class, id);
			if (target != null) {
				session.delete(target);

				System.out.println("Customer ID " + id + " deleted Successfully");

			}

			trans.commit();

		} catch (Exception e) {

			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

	}

	public Customer getEmployeeByID(int id) {
		Transaction trans = null;
		Customer target = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();

			target = session.get(Customer.class, id);

		} catch (Exception e) {

			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		return target;
	}

	public  void getCustomerByCustomerId(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Customer customer = session.get(Customer.class, id);
			System.out.println(customer.toString());
			if (customer != null) {
				customer.getOid().forEach(System.out::println);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
