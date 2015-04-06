package domain;

import domain.User;
import java.io.Serializable;
import java.lang.Float;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer extends User implements Serializable {

	
	private Float cash;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}   
	public Float getCash() {
		return this.cash;
	}

	public void setCash(Float cash) {
		this.cash = cash;
	}
   
}
