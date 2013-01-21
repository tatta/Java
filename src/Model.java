/**
 * Model class in the MVC pattern
 * 
 */
public class Model {
	private String[] categories;

	/**
	 * Sets all the available categories
	 * 
	 * @param categories
	 */
	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public String[] getCategories() {
		return categories;
	}

}
