import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetRow;

public class JdbcUtil {
  private static String url="jdbc:mysql://localhost:3306/mydb";
  private static String user="root";
  private static String password="";
  private JdbcUtil(){
	  
  }
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
    public static void free(ResultSet rs,Statement st,Connection conn){
    	try {
    	if(rs!=null){
				rs.close();}
    	} catch (SQLException e) {
				e.printStackTrace();
			}finally { 
					try {
						if(st!=null){
						st.close();}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							if(conn!=null){
								conn.close();
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				
			}
    	
    }
    
}
