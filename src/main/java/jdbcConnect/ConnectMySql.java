package jdbcConnect;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ConnectMySql {
	
	
	public void addUsers (String name, String password, String email , String phone , String gender )  {
		
		DbConnect DbCon = new DbConnect();
		
		 
		try{
			
			String sb = "insert registration (name,password,email,phone,gender) values ( ? , ? , ? ,?, ?)";
			
			PreparedStatement statment = DbCon.getConnect().prepareStatement(sb);
			statment.setString(1, name);
			statment.setString(2, password);
			statment.setString(3, email);
			statment.setString(4, phone);
			statment.setString(5, gender);
			
			
			statment.executeUpdate();
			DbCon.connect.close();
		
		}catch(SQLException e){
			System.out.print("Error 2");
			e.printStackTrace();
		}
		
		

	}

}
