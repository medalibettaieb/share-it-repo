package services.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Admin;
import domain.Category;
import domain.Customer;

/**
 * Session Bean implementation class Populator
 */
@Singleton
@Startup
public class Populator {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public Populator() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		Customer customer = new Customer("hedi", "hedi", "hedi");
		customer.setBanned(true);
		Customer customer2 = new Customer("iheb", "iheb", "iheb");
		Customer customer3 = new Customer("lamia", "lamia", "lamia");
		Customer customer4 = new Customer("haifa", "haifa", "haifa");
		Customer customer5 = new Customer("iheb", "iheb2", "iheb2");

		Admin admin = new Admin("ali", "ali", "ali");

		Category category = new Category("Sport");
		Category category2 = new Category("Music");

		entityManager.persist(customer);
		entityManager.persist(customer2);
		entityManager.persist(customer3);
		entityManager.persist(customer4);
		entityManager.persist(customer5);
		entityManager.persist(admin);
		entityManager.persist(category);
		entityManager.persist(category2);

	}
}
