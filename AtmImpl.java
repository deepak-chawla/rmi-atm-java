import java.rmi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

class AtmImpl implements AtmInterface{

public static void register()   {
		System.out.println("account number:");
		String user = sc.next();
		System.out.println("password:");
		String password = sc.next();
		try {	
		Connection	con = JdbcUtil.getConnection();
		PreparedStatement pst = con.prepareStatement("insert into login values(?,?,0)");
		pst.setString(1, user);
		pst.setString(2, password);
		int executeUpdate = pst.executeUpdate();
		
			if(executeUpdate!=0){
				System.out.println("registration success");
			
			}
		} catch (Exception e) {
			System.out.println("Registration failed, account already exists");
			
		} 
	}
	
public static String login() throws Exception {
		Connection con = JdbcUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select user from "+table);
		ArrayList<Object> list1 = new ArrayList<>();
		ArrayList<Object> list2 = new ArrayList<>();
		while (rs.next()){
			list1.add(rs.getString("user"));
		}
		rs = st.executeQuery("select password from "+table);
		while (rs.next()){
			list2.add(rs.getString("password"));
		}
		System.out.println("account number:");
		String u = sc.next();
		System.out.println("password:");
		String p = sc.next();
		for (int i = 0; i < list1.size(); i++) {
			if(u.equals(list1.get(i))&&p.equals(list2.get(i))){
				System.out.println("Landed successfully!");	
				return u;
			   }if(i==list1.size()-1){
				   System.out.println("Login failed! Incorrect account or password");
			   }
		}return null;
	}
	
public static double balance(String sql) throws SQLException{
		Connection	con = JdbcUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			System.out.println(rs.getDouble("money"));
			double doub = rs.getDouble("money");
			return doub;
		}
		return -1.00;
	}
	
public static void withdraw(String sql) throws SQLException{
		Connection	con = JdbcUtil.getConnection();
		Statement st = con.createStatement();
		st.executeUpdate(sql);
	
	}
	
public static String deposit( String sql) throws SQLException {
    	Connection	con = JdbcUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if (rs.next()) {
			   String user = rs.getString("user");
			   return user;
		}
		return null;
	}
	
}
