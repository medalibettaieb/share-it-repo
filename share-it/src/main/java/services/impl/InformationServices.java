package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.InformationServicesLocal;
import services.interfaces.InformationServicesRemote;
import domain.Category;
import domain.Customer;
import domain.Information;

/**
 * Session Bean implementation class InformationServices
 */
@Stateless
public class InformationServices implements InformationServicesRemote,
		InformationServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public InformationServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean postInfo(Integer idOwner, Information information,
			Integer idCategory) {
		Boolean b = false;
		try {
			Customer customerFounded = entityManager.find(Customer.class,
					idOwner);
			Category categoryFounded = entityManager.find(Category.class,
					idCategory);
			information.setUser(customerFounded);
			information.setCategory(categoryFounded);
			System.out.println(customerFounded.getName());
			System.out.println(categoryFounded.getName());
			entityManager.merge(information);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
