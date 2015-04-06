package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Information;

@Remote
public interface InformationServicesRemote {
	Boolean postInfo(Integer idOwner, Information information,
			Integer idCategory);

	List<Information> findAllPostsByIdCustomer(Integer idCustomer);

	List<Information> findAllPostsByIdFollowedCustomer(
			Integer idFollowedCustomer, Integer idFollowerCustomer);

	List<Information> findAllFollowedPosts();
}
