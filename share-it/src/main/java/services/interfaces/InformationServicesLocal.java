package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Information;

@Local
public interface InformationServicesLocal {
	Boolean postInfo(Integer idOwner, Information information,
			Integer idCategory);

	List<Information> findAllPostsByIdCustomer(Integer idCustomer);

	List<Information> findAllPostsByIdFollowedCustomer(
			Integer idFollowedCustomer, Integer idFollowerCustomer);

	List<Information> findAllFollowedPosts();
}
