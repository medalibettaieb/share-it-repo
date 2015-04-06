package infoTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.InformationServicesRemote;
import domain.Information;

public class TestFindAllPostsByIdFollowedCustomer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		InformationServicesRemote informationServicesRemote = (InformationServicesRemote) context
				.lookup("/share-it/InformationServices!services.interfaces.InformationServicesRemote");

		List<Information> informations = informationServicesRemote
				.findAllPostsByIdFollowedCustomer(3, 2);

		for (Information i : informations) {
			System.out.println(i);
		}
	}

}
