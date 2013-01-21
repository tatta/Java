import java.sql.*;
import java.util.ArrayList;

/**
 * Handles the communication with the mysql database
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
	public boolean openConnection(String userName, String passWord, String database) {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+database , userName, passWord);
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

	public String[] getCategories() {
		String sql = "select * from Kategoriat";
		PreparedStatement ps;
		int index = 0;
		String[] kategories = new String[5];
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String kategori = rs.getString("nimi");
				kategories[index++] = kategori;
			}
			return kategories;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Prints all the words for a specific category, input represents the input
	 * chosen from the drop down list
	 * 
	 * @param input
	 * @return an ArrayList containing Word objects.
	 */
	public ArrayList<Word> printAllCategoryWords(int input) {
		String sql = "select * from KategorinSanat,Sanat where id ='" + input
				+ "'" + "" + "and KategorinSanat.sana=Sanat.infinitiv";
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
	public boolean addWord(String suomeksi, String ruotsiksi, String infinitiv){
		return false;
	}
	public boolean removeWord(String word){
		return false;
		
	}
	public boolean editWord(){
		return false;
	}
	/************************************** DEBUG METHODS *************************************************************/
	public void printAllRowsFromSanat() {
		String sql = "select * from Sanat";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String infinitiv = rs.getString("infinitiv");
				String suomeksi = rs.getString("suomeksi");
				String ruotsiksi = rs.getString("ruotsiksi");
				System.out.println(infinitiv + " \t\t " + suomeksi + "\t "
						+ ruotsiksi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}