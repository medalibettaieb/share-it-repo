package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.UserManagementLocal;
import services.interfaces.UserManagementRemote;
import domain.Customer;
import domain.User;

/**
 * Session Bean implementation class UserManagement
 */
@Stateless
public class UserManagement implements UserManagementRemote,
		UserManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addUser(User user) {
		Boolean b = false;
		try {
			entityManager.persist(user);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteUser(Integer idUser) {
		Boolean b = false;
		try {
			entityManager.remove(findUserById(idUser));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateUser(User user) {
		Boolean b = false;
		try {
			entityManager.merge(user);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public User findUserById(Integer idUser) {
		User userFounded = null;
		try {
			userFounded = entityManager.find(User.class, idUser);
			System.out.println("user founded ...");
		} catch (Exception e) {
			System.out.println("user not found ...");
		}

		return userFounded;
	}

	@Override
	public Boolean deleteDetachedUser(User userDetached) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(userDetached));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		List<User> allUsers = new ArrayList<>();
		String jpql = "select u from User u";
		Query query = entityManager.createQuery(jpql);
		try {
			allUsers = query.getResultList();
		} catch (Exception e) {
			System.err.println("set empty ...");
		}
		return allUsers;

	}

	@Override
	public Boolean follow(Integer idFollowed, Integer idFollower) {
		Boolean b = false;
		try {
			Customer followed = (Customer) findUserById(idFollowed);
			Customer follower = (Customer) findUserById(idFollower);

			followed.getFollowers().add(follower);
			entityManager.merge(followed);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
