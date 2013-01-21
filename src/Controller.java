/**
 * Controller class in the MVC pattern
 * 
 */
public class Controller {
	private Model model;
	private View view;
	private Database db;

	public Controller(Model model, View view, Database db) {
		this.model = model;
		this.view = view;
		this.db = db;
	}

}
