import java.sql.SQLException;

public class Main {
	public final static String username = "root";
	public final static String password = "Fuckyou1488!";
	public final static String url = "jdbc:mysql://localhost:3306/db1";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
		DatabaseManager dbmanager = new DatabaseManager(username, password, url);
		dbmanager.connectToDb();
	}
		catch(Exception e) {
			System.out.println("Connection interrupted...");
		}
	}
}
