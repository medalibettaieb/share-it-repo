package userManagementTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.UserManagementRemote;
import domain.User;

public class TestFindAllUsers {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		UserManagementRemote proxy = (UserManagementRemote) context
				.lookup("/share-it/UserManagement!services.interfaces.UserManagementRemote");

		List<User> users = proxy.findAllUsers();
		if (users.size() != 0) {
			for (User u : users) {
				System.out.println(u.getName());
			}

		}
	}
}
