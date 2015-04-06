package domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Information
 *
 */
@Entity

public class Information implements Serializable {

	
	private Integer id;
	private String info;
	private static final long serialVersionUID = 1L;

	public Information() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
   
}
