package domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
public class Admin extends User implements Serializable {

	private String accessLevel = "firstLevel";
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	public Admin(String name, String login, String password) {
		super();
		this.setName(name);
		this.setLogin(login);
		this.setPassword(password);
	}

	public String getAccessLevel() {
		return this.accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

}
