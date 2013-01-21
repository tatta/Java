/**
 * Creates all the objects and opens a connection to the database
 * 
 * @author Siddhartha Pattni
 * 
 */
public class Launcher {
	/**
	 * @param args
	 *            args[0],args[1], args[2] contain the username,password and database 
	 *            name used to create the
	 *            database connection
	 */
	public static void main(String[] args) {
		Model model = new Model();
		Database db = new Database();
		db.openConnection(args[0], args[1], args[2]);
		model.setCategories(db.getCategories());
		View view = new View(db, model.getCategories());
		new Controller(model, view, db);
	}
}
