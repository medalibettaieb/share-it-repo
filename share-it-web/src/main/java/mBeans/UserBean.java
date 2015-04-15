package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserManagementLocal;
import domain.Customer;

@ManagedBean
@SessionScoped
public class UserBean {
	// injection of the proxies
	@EJB
	private UserManagementLocal userManagementLocal;

	// models
	private Customer customer = new Customer();

	// methods
	public String doCreateCustomer() {
		userManagementLocal.addUser(customer);
		return "";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
