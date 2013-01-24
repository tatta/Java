import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 * View creates the GUI for the project
 * 
 */
public class View extends JFrame{
	protected JComboBox<String> categoryDropDownList;
	protected JButton addBtn;
	protected JButton removeBtn;
	protected JButton editBtn;
	protected String[] categories = {""};
	protected JList<String> listOfWords;
	
	public View(){
		final JPanel comboPanel = new JPanel();
		JLabel categoryLabel = new JLabel("Categories:");
		categoryDropDownList = new JComboBox<String>(categories);

		comboPanel.add(categoryLabel);
		comboPanel.add(categoryDropDownList);

		String[] words = { "Suomeksi Ruotsiksi Infinitiv" };

		JPanel listPanel = new JPanel();
		listPanel.setVisible(true);
		listOfWords = new JList<String>(words);
		listPanel.add(listOfWords);
		JPanel buttonPanel = new JPanel();
		addBtn = new JButton("Add word");
		removeBtn = new JButton("Remove word");
		editBtn = new JButton("Edit word");
		
		buttonPanel.add(addBtn);
		buttonPanel.add(removeBtn);
		buttonPanel.add(editBtn);
		
		addWindowListener(new WindowHandler());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);

		add(comboPanel, BorderLayout.NORTH);
		add(listPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setTitle("Suomeksi");
	}

	
	class WindowHandler extends WindowAdapter {
		/**
		 * Called when the user exits the application.
		 */
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

}
