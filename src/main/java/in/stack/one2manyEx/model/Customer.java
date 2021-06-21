package in.stack.one2manyEx.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String email;
	private String mobile;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.EAGER)
	private List<Order> oid = new ArrayList<Order>();;

	public Customer() {

	}

	public Customer(String name, String email, String mobile, List<Order> oid) {

		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.oid = oid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Order> getOid() {
		return oid;
	}

	public void setOid(List<Order> oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", oid="
				+ oid.toString() + "]";
	}

}
