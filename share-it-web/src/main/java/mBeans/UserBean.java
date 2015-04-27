package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	private String name;
	private List<Customer> customers = new ArrayList<>();
	private Boolean visibility = false;

	// methods
	public String doCreateCustomer() {
		userManagementLocal.addUser(customer);
		return "";
	}

	public String doUpdateCustomer() {
		userManagementLocal.updateUser(customer);
		return "";
	}

	public String doDeleteCustomer() {
		userManagementLocal.deleteUser(customer.getId());
		return "";
	}

	public String doFollow() {
		userManagementLocal.follow(customer.getId(), user.getId());
		return "";
	}

	public String doFindUsersByName() {
		setCustomers(userManagementLocal.findCustomersByName(name));
		return "/pages/customer/customersList?faces-redirect=true";
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

	public String doSelectCustomer() {
		visibility = true;
		return "";
	}

	@PostConstruct
	public void doInitListCustomers() {
		customers = userManagementLocal.findAllCustomers();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

}
