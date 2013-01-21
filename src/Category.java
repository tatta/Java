/**
 * Category represents the available categories
 * 
 */
public class Category {
	private String[] kategorier;

	public Category(String[] kategorier) {
		this.kategorier = new String[5];
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < kategorier.length; i++) {
			output += kategorier[i];
		}
		return output;
	}
}
