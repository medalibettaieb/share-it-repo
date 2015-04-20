package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.InformationServicesLocal;
import domain.Category;

@ManagedBean
@SessionScoped
public class CategoryBean {
	private List<Category> categories = new ArrayList<>();
	private Category selectedCategory;
	@EJB
	private InformationServicesLocal informationServicesLocal;

	public Category doFindCategoryByName(String name) {
		return informationServicesLocal.findCategoryByName(name);
	}

	public void dodisplay() {
		System.out.println(selectedCategory.getName());
	}

	public List<Category> getCategories() {
		categories = informationServicesLocal.findAllCategories();
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

}
