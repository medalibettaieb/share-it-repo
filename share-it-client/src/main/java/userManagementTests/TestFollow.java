package userManagementTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.UserManagementRemote;
import domain.User;

public class TestFollow {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		UserManagementRemote proxy = (UserManagementRemote) context
				.lookup("/share-it/UserManagement!services.interfaces.UserManagementRemote");

		proxy.follow(3, 1);
		proxy.follow(3, 2);
	}
}
