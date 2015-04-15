package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserManagementLocal;
import domain.Customer;
import domain.User;

@ManagedBean
@SessionScoped
public class UserBean {
	// injection of the proxies
	@EJB
	private UserManagementLocal userManagementLocal;

	// models
	private Customer customer = new Customer();
	private User user = new User();

	// methods
	public String doCreateCustomer() {
		userManagementLocal.addUser(customer);
		return "";
	}

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userManagementLocal.login(user.getLogin(),
				user.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Customer) {
				user = userLoggedIn;
				navigateTo = "/pages/customer/customerHome?faces-redirect=true";
			} else {
				user = userLoggedIn;
				navigateTo = "/pages/admin/adminHome?faces-redirect=true";
			}
		} else {
			navigateTo = "/error?faces-redirect=true";
		}
		return navigateTo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
