import java.util.ArrayList;
import java.util.Observable;

/**
 * Model class in the MVC pattern notifies the controller when the database
 * connection has been established.
 * 
 */
public class Model extends Observable {
	private String[] args;
	private Database db;

	public enum Category {
		Uutiset, Viihde, Urheilu, Sää, Lifestyle
	}

	public Model(String[] args) {
		this.args = args;
		this.db = new Database();
	}

	public void connect() {
		if (db.openConnection(args[0], args[1], args[2])) {
			System.out.println("Connected to " + args[2]);
			setChanged();
			notifyObservers(Category.values());
		} else {
			System.out.println("Could not connect to " + args[2]);
		}
	}

	public ArrayList<Word> getWordsFrom(int category) {
		return db.printAllWordsFor(category);
	}
}
