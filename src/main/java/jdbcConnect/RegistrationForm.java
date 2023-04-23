package jdbcConnect;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationForm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
		

		response.setContentType("text/html");	
		
		String name = request.getParameter("firstName");
		String password = request.getParameter("password");
		String passwordTwo = request.getParameter("passwordTwo");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		ConnectMySql connect = new ConnectMySql();
		CheckConform checkConform = new CheckConform();
		
		
			if( !name.isEmpty()) {
				if(checkConform.checking(name)) {
					
					if(password.equals(passwordTwo)) {
						
						connect.addUsers(name,password, email,phone,gender);
						request.getRequestDispatcher("/WEB-INF/greatRegistration.jsp").forward(request, response);	
					}else {
						request.getRequestDispatcher("/WEB-INF/errorPassword.jsp").forward(request, response);	
					}
					
				}else {
					request.getRequestDispatcher("/WEB-INF/repitName.jsp").forward(request, response);
				}
				
			}else {
				request.getRequestDispatcher("/WEB-INF/noName.jsp").forward(request, response);
			}
	}
	
}


