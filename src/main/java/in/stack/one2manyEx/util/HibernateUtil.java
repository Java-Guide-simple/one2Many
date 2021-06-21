package in.stack.one2manyEx.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import in.stack.one2manyEx.model.Customer;
import in.stack.one2manyEx.model.Order;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {

		SessionFactory sf = null;
		ServiceRegistry registry = null;

		if (sf == null) {

			try {
				Properties pro = new Properties();
				Configuration cfg = new Configuration();
				pro.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				pro.put(Environment.URL, "jdbc:mysql://localhost:3306/db_Java");
				pro.put(Environment.USER, "root");
				pro.put(Environment.PASS, "test");
				pro.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				pro.put(Environment.SHOW_SQL, "true");
				pro.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				pro.put(Environment.POOL_SIZE, "2");
				pro.put(Environment.HBM2DDL_AUTO, "update");

				cfg.setProperties(pro);

				// Mapping the Entity Classes
				cfg.addAnnotatedClass(Customer.class);
				cfg.addAnnotatedClass(Order.class);

				registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
				System.out.println("Service Rigistry Created!");
				sf = cfg.buildSessionFactory(registry);

			} catch (Exception e) {
				e.printStackTrace();

				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}

		return sf;

	}
}
