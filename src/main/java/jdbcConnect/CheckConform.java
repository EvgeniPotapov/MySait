package jdbcConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckConform {
	
	public boolean checking (String name) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			
//			e1.printStackTrace();
//		}
		DbConnect DbCon = new DbConnect();
		boolean tr = true;
		String n;
		try{
			
			String inquiry = "SELECT * FROM registration ";
			
			Statement stat = DbCon.getConnect().createStatement();
			
			ResultSet resultSet = stat.executeQuery(inquiry);
			
			while(resultSet.next()) {
				
			n = resultSet.getString("name");
			
			  if(n.equals(name)) {
		        	
					 tr = false;
					 break;
				}
			}
			stat.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
	
		
      return tr;
	}
	
	
}
		
			

