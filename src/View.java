import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * View creates the GUI for the project
 * 
 */
public class View extends JFrame {
	private Database db;

	public View(final Database db, String[] categories) {
		this.db = db;
		final JPanel comboPanel = new JPanel();
		JLabel categoryLabel = new JLabel("Categories:");
		JComboBox dropList = new JComboBox(categories);

		comboPanel.add(categoryLabel);
		comboPanel.add(dropList);

		String[] words = { "Suomeksi Ruotsiksi Infinitiv" };

		JPanel listPanel = new JPanel();
		listPanel.setSize(300, 300);
		listPanel.setVisible(true);
		final JList list = new JList(words);
		listPanel.add(list);
		JPanel buttonPanel = new JPanel();
		JButton addBtn = new JButton("Add word");
		JButton removeBtn = new JButton("Remove word");
		JButton editBtn = new JButton("Edit word");
		buttonPanel.add(addBtn);
		buttonPanel.add(removeBtn);
		buttonPanel.add(editBtn);
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
			}
		});
		removeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
			}
		});
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
			}
		});
		dropList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				int index = comboBox.getSelectedIndex();
				list.setModel(new DefaultComboBoxModel(db
						.printAllCategoryWords(index + 1).toArray()));

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);

		add(comboPanel, BorderLayout.NORTH);
		add(listPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setVisible(true);
		setTitle("Suomeksi");
	}

}
