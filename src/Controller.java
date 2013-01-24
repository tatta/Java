import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Controller class in the MVC pattern
 * Acts as an observer to the Model class.
 * 
 */
public class Controller implements ActionListener, Observer {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		view.addBtn.addActionListener(this);
		view.removeBtn.addActionListener(this);
		view.editBtn.addActionListener(this);
		view.categoryDropDownList.addActionListener(this);
		model.addObserver(this);
		model.connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.addBtn)
			System.out.println("Pressed add");
		else if (e.getSource() == view.removeBtn)
			System.out.println("Pressed remove");
		else if (e.getSource() == view.editBtn)
			System.out.println("Pressed edit");
		else {
			JComboBox comboBox = (JComboBox) e.getSource();
			int category = comboBox.getSelectedIndex();
			view.listOfWords.setModel(new DefaultComboBoxModel(model
					.getWordsFrom(category).toArray()));
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		view.categoryDropDownList.setModel(new DefaultComboBoxModel(
				(Object[]) arg));
		view.setVisible(true);

	}
}
