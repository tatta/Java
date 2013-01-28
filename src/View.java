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
	//protected JButton editBtn;
	protected String[] categories = {""};
	protected JList<String> wordList;
	
	public View(){
		final JPanel comboPanel = new JPanel();
		JLabel categoryLabel = new JLabel("Categories:");
		categoryDropDownList = new JComboBox<String>(categories);

		comboPanel.add(categoryLabel);
		comboPanel.add(categoryDropDownList);

		String[] words = { "Suomeksi Ruotsiksi Infinitiv" };
		setLayout(new BorderLayout());
		
		wordList = new JList<String>(words);
		JPanel buttonPanel = new JPanel();
		addBtn = new JButton("Add word");
		removeBtn = new JButton("Remove word");
		//editBtn = new JButton("Edit word");
		
		buttonPanel.add(addBtn);
		buttonPanel.add(removeBtn);
		//buttonPanel.add(editBtn);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 300);

		add(comboPanel, BorderLayout.NORTH);
		add(new JScrollPane(wordList));
		add(buttonPanel, BorderLayout.SOUTH);
		setResizable(false);
		setTitle("Suomeksi");
	}
}
