package userManagementTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.UserManagementRemote;
import domain.User;

public class TestUpdateUser {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		UserManagementRemote proxy = (UserManagementRemote) context
				.lookup("/share-it/UserManagement!services.interfaces.UserManagementRemote");

		User userFounded = proxy.findUserById(1);

		userFounded.setName("new look");

		System.out.println(proxy.updateUser(userFounded));
	}
}
