import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	static final String DB_URL = "jdbc:mysql://localhost:3306/maveindbms2";
	  static final String USER = "root";
	  static final String PASS = "root";

	public static boolean CreateTableToDB () {
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        Statement stmt = conn.createStatement();
	     ) {      
	         String sql = "CREATE TABLE Root " +
	                  "(id int NOT NULL AUTO_INCREMENT, " +
	                  " name_common  VARCHAR(100) not NULL, " +    
	                  " name_official VARCHAR(100) , " +
	                  " tld VARCHAR(100) , " +
	                  " cca2  VARCHAR(100)  , " +
	                  " ccn3  VARCHAR(100)  , " +
	                  " cca3  VARCHAR(100)  , " +
	                  " PRIMARY KEY ( id ))";
	         String sql1="ALTER TABLE Root AUTO_INCREMENT=1";
	         stmt.executeUpdate(sql);
	         stmt.executeUpdate(sql1);
	       
	      
	       
	        System.out.println(true+"===>Created web Table table in given database...");  
	       
	     } catch (SQLException e) {
	       System.out.println("Table Web Table Already Build");
	       System.out.println("***********************************");
	     }
	return false;
	  }
}
