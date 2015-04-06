package domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
public class Customer extends User implements Serializable {

	private Float cash = 100F;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}

	public Customer(String name, String login, String password) {
		super();
		this.setName(name);
		this.setLogin(login);
		this.setPassword(password);
	}

	public Float getCash() {
		return this.cash;
	}

	public void setCash(Float cash) {
		this.cash = cash;
	}

}
