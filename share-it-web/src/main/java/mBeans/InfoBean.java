package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import services.interfaces.InformationServicesLocal;
import domain.Information;

@ManagedBean
@RequestScoped
public class InfoBean {
	private Information information = new Information();
	@EJB
	private InformationServicesLocal informationServicesLocal;
	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;
	@ManagedProperty(value = "#{categoryBean}")
	private CategoryBean categoryBean;

	public String doPostInfo() {
		Integer idOwner = userBean.getUser().getId();
		Integer idCategory = categoryBean.getSelectedCategory().getId();
		informationServicesLocal.postInfo(idOwner, information, idCategory);
		return "";
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public CategoryBean getCategoryBean() {
		return categoryBean;
	}

	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

}
