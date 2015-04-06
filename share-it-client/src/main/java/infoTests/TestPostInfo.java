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
		Information information2 = new Information(
				"fadhl chaker rja3 el 3a9lou");
		Information information3 = new Information("emino 5raj men 3a9lou");
		Information information4 = new Information("psg 3 marseille 2");

		informationServicesRemote.postInfo(1, information, 1);
		informationServicesRemote.postInfo(1, information4, 1);
		informationServicesRemote.postInfo(3, information3, 2);
		informationServicesRemote.postInfo(3, information2, 2);
	}

}
