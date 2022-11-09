package postgre_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn_Main {

	private final String url = "jdbc:postgresql://localhost:5432/postgres";
	private final String user = "postgres";
	private final String password = "demo";
	private Connection conn = null ;
	private Statement stmt = null ;
	
	 public Connection connect() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
	
	 
	 public void getCustomerList()  {

	      try {
	         
	         stmt = conn.createStatement();
	         ResultSet resultSet = stmt.executeQuery( "SELECT * FROM public.customer_bloodtype ;" );
	         
	         while (resultSet.next()) {
	              System.out.printf("%s  %s%n", resultSet.getString("ID"), resultSet.getString("TypeName"));
	          }
	         
	         resultSet.close();
	         stmt.close();
	         conn.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Listing done successfully");
	      System.out.println();
	    }
	
	 public static void main(String[] args) throws SQLException {		 
		 
		 	Conn_Main app = new Conn_Main();
	        app.connect();
	        app.getCustomerList();
	        
		    
	        
	        
	    }
	
	
}
