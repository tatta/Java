import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Creates all the objects and opens a connection to the database
 * 
 * @author Siddhartha Pattni
 * 
 */
public class Launcher {
	/**
	 * @param args
	 *            args[0],args[1], args[2] contain the username,password and
	 *            database name. Sent to the Model constructor and used to
	 *            create the database connection
	 * 
	 */
	public static void main(String[] args) {
		Model model = new Model(args);
		View view = new View();
		new Controller(model, view);

//		EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } 
//                catch (ClassNotFoundException ex) {}
//                catch (InstantiationException ex) {}
//                catch (IllegalAccessException ex) {}
//                catch (UnsupportedLookAndFeelException ex) {}
//           }
//		});   
//		
	}
}
