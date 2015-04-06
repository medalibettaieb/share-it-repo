package infoTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.InformationServicesRemote;
import domain.Information;

public class TestPostInfo {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		InformationServicesRemote informationServicesRemote = (InformationServicesRemote) context
				.lookup("/share-it/InformationServices!services.interfaces.InformationServicesRemote");

		Information information = new Information("real madrid 9 granada 1");
		
		Boolean b=informationServicesRemote.postInfo(2, information, 1);
		System.out.println(b);
	}

}
