package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public List<Information> findAllPostsByIdCustomer(Integer idCustomer) {
		String jpql = "select i from Information i where i.user.id = :param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", idCustomer);
		return query.getResultList();
	}

	@Override
	public List<Information> findAllPostsByIdFollowedCustomer(
			Integer idFollowedCustomer, Integer idFollowerCustomer) {
		List<Information> informations = new ArrayList<Information>();
		Customer followed = entityManager.find(Customer.class,
				idFollowedCustomer);
		Customer follower = entityManager.find(Customer.class,
				idFollowerCustomer);
		if (followed.getFollowers().contains(follower)) {
			informations = findAllPostsByIdCustomer(idFollowedCustomer);
		} else {
			System.err.println("emmm haw fibali ...");
		}

		return informations;
	}

	@Override
	public List<Information> findAllFollowedPosts() {

		return null;
	}

	@Override
	public List<Category> findAllCategories() {
		return entityManager.createQuery("select c from Category c",
				Category.class).getResultList();
	}

	@Override
	public Category findCategoryByName(String name) {
		return entityManager
				.createQuery("select c from Category c where c.name=:param1",
						Category.class).setParameter("param1", name)
				.getSingleResult();
	}

}
