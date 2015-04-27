package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Customer;
import domain.User;

@Local
public interface UserManagementLocal {
	Boolean addUser(User user);

	Boolean deleteUser(Integer idUser);

	Boolean updateUser(User user);

	User findUserById(Integer idUser);

	Boolean deleteDetachedUser(User userDetached);

	List<User> findAllUsers();

	Boolean follow(Integer idFollowed, Integer idFollower);

	User login(String login, String password);

	List<User> findUsersByName(String name);
	
	List<Customer> findAllCustomers();
	
	List<Customer> findCustomersByName(String name);
	
}
