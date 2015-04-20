package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import mBeans.CategoryBean;
import domain.Category;

@FacesConverter("cc")
public class CategoryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null) {
			return null;
		}
		CategoryBean categoryBean = context.getApplication()
				.evaluateExpressionGet(context, "#{categoryBean}",
						CategoryBean.class);
		Category category = categoryBean.doFindCategoryByName(value);

		return category;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		String string = null;
		if (object instanceof Category) {
			string = ((Category) object).getName();
		}
		return string;
	}

}
