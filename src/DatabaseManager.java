import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseManager {
	 String username;
	 String password;
	 String url;
	 Scanner in;
	 boolean connected;
	public DatabaseManager(String username,String password,String url) throws SQLException, ClassNotFoundException {
		this.password= password;
		this.url = url;
		this.username = username;
		this.in= new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
			}
	public void connectToDb() throws SQLException{
		try(Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement()){
			connected = true;
			System.out.println("Connection was succesfuled");
			while(connected) {
				System.out.println("Insert console command(execup, execq, exit)");
				switch(in.nextLine().toLowerCase()) {
					case "execup":{
						System.out.println("Insert SQL UPDATE command");
						try{
						statement.executeUpdate(in.nextLine());
						break;
						}
						catch(Exception e){
							System.out.println("Incorrect SQL command");
							break;
						}
					}
					case "execq":{
						System.out.println("Insert SQL command");
						try{
						statement.execute(in.nextLine());
						break;
						}
						catch(Exception e){
							System.out.println("Incorrect SQL command");
							break;
						}
					}
					case "exit":{
						connected = false;
						break;
					}
					case "getdata":{
						try{
						System.out.println("Insert database name");
						String dbname = in.nextLine();
						System.out.println("Insert column number");
						String dbcol = in.nextLine();
						System.out.println("Insert column type");
						String coltype = in.nextLine();
						ResultSet rs = statement.executeQuery("select * from "+ dbname);
							switch(coltype.toLowerCase()) {
								case"string":{
									try {
									while(rs.next()) {
										System.out.println(rs.getString(dbcol));
										System.out.println("_____________________");
										break;
									}
									}
									catch(Exception e) {
										System.out.println("Incorrect data");
										break;
									}
								}
								case"int":{
									try {
									while(rs.next()) {
										System.out.println(rs.getInt(dbcol));
										System.out.println("_____________________");
										break;
									}
									}
									catch(Exception e) {
										System.out.println("Incorrect data");
										break;
									}
								}
								case"bool":{
									try {
									while(rs.next()) {
										System.out.println(rs.getBoolean(dbcol));
										System.out.println("_____________________");
										break;
									}
									}
									catch(Exception e) {
										System.out.println("Incorrect data");
										break;
									}
								}
								default:{
									System.out.println("Incorrect data");
									break;
								}
							}
						
						break;
						}
						catch(Exception e){
							System.out.println("Error on data taking process");
							break;
						}
						
					}
					
					case "default":{
						System.out.println("Incorrect console command");
						break;
					}
				}
	}
		
	}
	}
}

