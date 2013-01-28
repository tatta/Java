import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
		//view.editBtn.addActionListener(this);
		view.addWindowListener(new WindowHandler());
		view.categoryDropDownList.addActionListener(this);
		model.addObserver(this);
		model.connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame frame = new Frame();
		if (e.getSource() == view.addBtn){
			System.out.println("Pressed add");
	        String word =  JOptionPane.showInputDialog(frame 
	                ,"Enter word" ,"Add word"
	                ,JOptionPane.QUESTION_MESSAGE);
	        model.addWord(word);
		}
	
		else if (e.getSource() == view.removeBtn){
			// \s - Matches any white-space character
			String word =  JOptionPane.showInputDialog(frame 
	                ,"Enter word" ,"Remove word"
	                ,JOptionPane.QUESTION_MESSAGE);
			model.removeWord(word);
			System.out.println("Pressed remove");
			
		
		}	
//		else if (e.getSource() == view.editBtn){
//			System.out.println("Pressed edit");
//		}
		else {
			JComboBox comboBox = (JComboBox) e.getSource();
			int category = comboBox.getSelectedIndex();
			view.wordList.setModel(new DefaultComboBoxModel(model
					.getWordsFrom(category+1).toArray()));
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		view.categoryDropDownList.setModel(new DefaultComboBoxModel(
				(Object[]) arg));
		view.setVisible(true);

	}

	class WindowHandler extends WindowAdapter {
		/**
		 * Called when the user exits the application.
		 */
		public void windowClosing(WindowEvent e) {
			model.closeConnection();
			System.exit(0);
		}
	}
}
