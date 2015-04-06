package infoTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.InformationServicesRemote;
import domain.Information;

public class TestFindAllInfoByIdCustomer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		InformationServicesRemote informationServicesRemote = (InformationServicesRemote) context
				.lookup("/share-it/InformationServices!services.interfaces.InformationServicesRemote");

		List<Information> informations = informationServicesRemote
				.findAllPostsByIdCustomer(1);

		System.out.println(informations.get(0));
	}

}
