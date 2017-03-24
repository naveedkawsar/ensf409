/**
 * 
 */
package exercise4;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author  Naveed Kawsar
 * 			Karan Sunil Bengali
 *
 */
class Database {
	final static String USER = "root"; 
	final static String PASSWORD = "root"; 
	
	final String postalCodeRegex = "^[A-Z][0-9][A-Z] ?[0-9][A-Z][0-9]$";
	//final String phoneRegex = "^\d{3}-\d{3}-\d{4}$";
	final String phoneNumberRegex = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$";

	// Attributes 
	private Connection connect; 
	private Statement statement; 
	private ResultSet resultSet;

	public void initializeConnection() { 
	    try { 
	      // Register JDBC driver
	      Driver driver = new com.mysql.jdbc.Driver(); 
	      DriverManager.registerDriver(driver);
	      
	      // Open a connection
	     // String url = "jdbc:mysql:@" + HOSTNAME + ":" + PORT + ":" + SID; 
	      String url = "jdbc:mysql://localhost:3306/lab7?verifyServerCertificate=false&useSSL=true";
	      connect = DriverManager.getConnection(url, USER, PASSWORD);
	      statement = connect.createStatement();
	      
	      //Run it the first time to create database
	      //int Result=statement.executeUpdate("CREATE DATABASE lab7");
	      
	      // Execute a query to create database
	      String create_table = "CREATE TABLE IF NOT EXISTS clients ("
	      		+ " id int(4) AUTO_INCREMENT,"
	      		+ " firstname varchar(20) NOT NULL,"
		    	+ " lastname varchar(20) NOT NULL,"
		    	+ " address varchar(50) NOT NULL,"
		    	+ " postalCode char(12) NOT NULL,"
		    	+ " phoneNumber char(7) NOT NULL,"
		    	+ " clientType char(1) NOT NULL,"
		    	+ " PRIMARY KEY(id));";
	      statement.execute(create_table);
	      
	    } catch (SQLException e) { 
	      e.printStackTrace(); 
	    } 
	  } 
	   
	  public void close() { 
		  try {
		      if (resultSet != null) {
		        resultSet.close();
		      }
		      if (statement != null) {
		        statement.close();
		      }
		      if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
	  }
	  
	//---------------------------------------------------------- 
	//---------------PREPARED STATEMENT--------------------- 
	//---------------------------------------------------------- 
	public void selectClientByID(int id) { 
	    try { 
	      String query = "SELECT * FROM users where id= ?"; 
	      PreparedStatement pStat = connect.prepareStatement(query); 
	      pStat.setInt(1, id); 
	      resultSet = pStat.executeQuery(); 
	      while (resultSet.next()) { 
	        System.out.println(resultSet.getString("firstname") + " " +  
	                                        resultSet.getString("lastname") + " " + 
	                                        resultSet.getString("clientType")); 
	      } 
	      pStat.close(); 
	    } catch (SQLException e) { 
	      e.printStackTrace(); 
	    } 
	}
	  
	public void selectClientByName(String lastname) { 
		    try { 
		      String query = "SELECT * FROM users where lastname= ?"; 
		      PreparedStatement pStat = connect.prepareStatement(query); 
		      pStat.setString(1, lastname); 
		      resultSet = pStat.executeQuery(); 
		      while (resultSet.next()) { 
		        System.out.println(resultSet.getString("firstname") + " " +  
		                                        resultSet.getString("lastname") + " " + 
		                                        resultSet.getString("clientType")); 
		      } 
		      pStat.close(); 
		    } catch (SQLException e) { 
		      e.printStackTrace(); 
		    } 
	}
	  
	public void selectClientByType(String clientType) { 
		  try { 
			String query = "SELECT * FROM users where clientType= ?"; 
			PreparedStatement pStat = connect.prepareStatement(query); 
			pStat.setString(1, clientType); 
			resultSet = pStat.executeQuery(); 
			while (resultSet.next()) { 
		        System.out.println(resultSet.getString("firstname") + " " +  
		                                        resultSet.getString("lastname") + " " + 
		                                        resultSet.getString("clientType")); 
			} 
			pStat.close(); 
		    } catch (SQLException e) { 
		      e.printStackTrace(); 
		    } 
	}
	  
	public void insertClient(
			  int id, String firstname, 
			  String lastname, String address, String postalCode, 
			  String phoneNumber, String clientType) { 
		  if ( !(phoneNumber.matches(phoneNumberRegex)) ) {
			  System.err.print("Invalid phone number or phone number format\n");
		  }
		  if ( !(postalCode.matches(postalCodeRegex)) ) {
			  System.err.print("Invalid postal code or postal code format\n");
		  }
		  if ( clientType != "C"  || clientType != "R" ) {
			  System.err.print("Invalid client type\n");
		  }
	    try { 
	      String query = 
	    		  "INSERT INTO Clients "
	      		+ "(id, firstname, lastname, address, postalCode, phoneNumber, clientType) "
	      		+ "values (?,?,?,?,?,?,?)"; 
	      PreparedStatement pStat = connect.prepareStatement(query); 
	      pStat.setInt(1, id);
	      pStat.setString(2, firstname); 
	      pStat.setString(3, lastname);
	      pStat.setString(4, address);
	      pStat.setString(5, postalCode);
	      pStat.setString(6, phoneNumber);
	      pStat.setString(7, clientType);
	      
	      int rowCount = pStat.executeUpdate(); 
	      System.out.println("row Count = " + rowCount); 
	      pStat.close();
	    } catch (SQLException e) { 
		      e.printStackTrace(); 
		}
	  }
	  
	public void updateClient(
			  int id, String firstname, 
			  String lastname, String address, String postalCode, 
			  String phoneNumber, String clientType) { 
		  if ( !(phoneNumber.matches(phoneNumberRegex)) ) {
			  System.err.print("Invalid phone number or phone number format\n");
		  }
		  if ( !(postalCode.matches(postalCodeRegex)) ) {
			  System.err.print("Invalid postal code or postal code format\n");
		  }
		  if ( clientType != "C"  || clientType != "R" ) {
			  System.err.print("Invalid client type\n");
		  }
	    try { 
	      String query = 
	    		  "UPDATE Clients"
	    		+ "SET firstname = ?, lastname = ?, address = ?, "
	    				  + "postalCode = ?, phoneNumber = ?, clientType = ? "
	    		+ "where id = ?"; 
	      PreparedStatement pStat = connect.prepareStatement(query); 
	      pStat.setString(1, firstname); 
	      pStat.setString(2, lastname);
	      pStat.setString(3, address);
	      pStat.setString(4, postalCode);
	      pStat.setString(5, phoneNumber);
	      pStat.setString(6, clientType);
	      pStat.setInt(7, id);
	      
	      int rowCount = pStat.executeUpdate(); 
	      System.out.println("row Count = " + rowCount); 
	      pStat.close();
	    } catch (SQLException e) { 
		      e.printStackTrace(); 
		}
	  }
	
	public void deleteClient(int id) { 
		  try { 
		      String delete = "DELETE FROM Clients WHERE id = ?";
		      PreparedStatement pStat = connect.prepareStatement(delete); 
		      pStat.setInt(1, id);
		      int rowCount = pStat.executeUpdate(); 
		      System.out.println("row Count = " + rowCount); 
		  } catch (SQLException e) { 
		      e.printStackTrace(); 
		  } 
	} 

	public static void main(String[] args) {
		Database database = new Database(); 
	    database.initializeConnection();
	}
}
