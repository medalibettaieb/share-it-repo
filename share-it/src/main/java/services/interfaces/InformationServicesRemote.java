package services.interfaces;

import javax.ejb.Remote;

import domain.Information;

@Remote
public interface InformationServicesRemote {
	Boolean postInfo(Integer idOwner, Information information,
			Integer idCategory);

}
