/**
 * 
 */
package exercise4;

import java.math.BigDecimal;
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
	final static String HOSTNAME = "localhost"; 
	final static String PORT = "3306"; 
	final static String SID = ""; 
	// Attributes 
	private Connection connect; 
	private Statement statement; 
	private ResultSet resultSet; 
	public void initializeConnection() { 
	    try { 
	      // Register JDBC driver
	      Driver driver = new com.mysql.jdbc.Driver(); 
	      DriverManager.registerDriver(driver);
	      //jdbc:mysql://
	      // jdbc:oracle:thin:@HOSTNAME:PORT:SID
	      
	      // Open a connection
	     // String url = "jdbc:mysql:@" + HOSTNAME + ":" + PORT + ":" + SID; 
	      String url = "jdbc:mysql://localhost:3306/lab7?verifyServerCertificate=false&useSSL=true";
	      connect = DriverManager.getConnection(url, USER, PASSWORD);
	      statement = connect.createStatement();
	      
	      //Run it the first time to create database
	      //int Result=statement.executeUpdate("CREATE DATABASE lab7");
	      
	      // Execute a query to create database
	      String create_table = "CREATE TABLE IF NOT EXISTS clients ("
	      		+ " id NUMERIC(4) PRIMARY KEY,"
	      		+ " firstname VARCHAR(20) NOT NULL,"
		    	+ " lastname VARCHAR(20) NOT NULL,"
		    	+ " address VARCHAR(50) NOT NULL,"
		    	+ " postalCode CHAR(12) NOT NULL,"
		    	+ " phoneNumber CHAR(7) NOT NULL,"
		    	+ " clientType CHAR(1) NOT NULL);";
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
	  public void selectClientByID(BigDecimal id) { 
	    try { 
	      String query = "SELECT * FROM users where id= ?"; 
	      PreparedStatement pStat = connect.prepareStatement(query); 
	      pStat.setString(1, "id"); 
	      pStat.setString(2, "123456"); 
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
			  BigDecimal id, String firstname, 
			  String lastname, String address, String postalCode, 
			  String phoneNumber, String clientType) { 
		  
		  // TODO: Check formatting of arguments
	    try { 
	      String query = 
	    		  "INSERT INTO Clients "
	      		+ "(id, firstname, lastname, address, postalCode, phoneNumber, clientType) "
	      		+ "values (?,?,?,?,?,?,?)"; 
	      PreparedStatement pStat = connect.prepareStatement(query); 
	      pStat.setBigDecimal(1, id);
	      pStat.setString(2, firstname); 
	      pStat.setString(3, lastname);
	      pStat.setString(4, address);
	      pStat.setString(5, postalCode);
	      pStat.setString(6, phoneNumber);
	      pStat.setString(7, clientType);
	      
	      //int rowCount = pStat.executeUpdate(); 
	      //System.out.println("row Count = " + rowCount); 
	      pStat.close();
	    } catch (SQLException e) { 
		      e.printStackTrace(); 
		}
	  }
	  
	  public void deleteUser(BigDecimal id) { 
		    try { 
		      String delete = "DELETE FROM Clients WHERE id = ?";
		      PreparedStatement pStat = connect.prepareStatement(delete); 
		      pStat.setBigDecimal(1, id);
		      int rowCount = pStat.executeUpdate(); 
		      System.out.println("row Count = " + rowCount); 
		    } catch (SQLException e) { 
		      e.printStackTrace(); 
		    } 
		  } 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database database = new Database(); 
	    database.initializeConnection(); 

	}

}
