package max.java.pm.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		LoginDAO loginDAO=new LoginDAO();
		 String st = loginDAO.login(email, pass);
		   if(st.equalsIgnoreCase(email))
		   {
			 HttpSession session = request.getSession();
			 session.setAttribute("email", email);
			 request.getRequestDispatcher("wel.jsp").forward(request, response);  
		   }
		   else
		   {
			   out.println("<html><body>");
			   out.println("<table bgcolor='red'>");
			   out.println("<th>"+st);
			   out.println("</th></table></body></html>");
			   request.getRequestDispatcher("login.jsp").include(request, response);  
				   
		   }
		
		
		
		
	}

}
