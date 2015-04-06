package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.User;

@Remote
public interface UserManagementRemote {
	Boolean addUser(User user);

	Boolean deleteUser(Integer idUser);

	Boolean updateUser(User user);

	User findUserById(Integer idUser);

	Boolean deleteDetachedUser(User userDetached);

	List<User> findAllUsers();

	Boolean follow(Integer idFollowed, Integer idFollower);

}
