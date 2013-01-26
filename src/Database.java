import java.sql.*;
import java.util.ArrayList;

/**
 * Handles the communication with the MySQL database
 * 
 */
public class Database {
	private Connection conn;
	private Statement stmt;

	public Database() {
		this.conn = null;
	}

	/**
	 * Database creates a connection to the mysql database with userName and
	 * passWord
	 * 
	 * @param userName
	 * @param passWord
	 * @return true if a connection is established
	 */
	public boolean openConnection(String userName, String passWord,
			String database) {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ database, userName, passWord);
			this.stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void closeConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
		}
		conn = null;
	}

	public boolean isConnected() {
		return conn != null;
	}
	public boolean addWord(String word){
		try {
			 return stmt.executeUpdate("Insert into Sanat VALUES('"+word+"'"+","+"''"+","+"'');")==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
	}
	
	public boolean removeWord(String word) {
		try {
			return stmt.executeUpdate("DELETE FROM Sanat WHERE infinitiv = '"+word+"';")==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	/**
	 * Prints all the words for a specific category, input represents the input
	 * chosen from the drop down list
	 * 
	 * @param input
	 * @return an ArrayList containing Word objects.
	 */
	public ArrayList<Word> printAllWordsFor(int category) {
		String sql = "select * from KategorinSanat,Sanat where id ='"
				+ category + "'" + "and KategorinSanat.sana=Sanat.infinitiv";
		PreparedStatement ps;
		ArrayList<Word> list = new ArrayList<Word>();
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String infinitiv = rs.getString("infinitiv");
				String suomeksi = rs.getString("suomeksi");
				String ruotsiksi = rs.getString("ruotsiksi");
				list.add(new Word(suomeksi, ruotsiksi, infinitiv));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/************************************** DEBUG METHODS *************************************************************/
	public void printAllRowsFrom(String table) {
		String sql = "select * from" + "table";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean addWord(String suomeksi, String ruotsiksi, String infinitiv) {
		return false;
	}

	public boolean editWord() {
		return false;
	}

}