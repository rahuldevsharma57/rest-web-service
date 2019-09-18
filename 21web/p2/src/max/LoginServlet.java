package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass");
		String mobile = request.getParameter("mobile");
		String otp = request.getParameter("otp");
		JSONObject jb = new JSONObject();
		jb.put("uid", uid);
		jb.put("pass", pass);
		jb.put("mobile", mobile);
		jb.put("otp", otp);
		String uDetail = jb.toString();
		ClientServices clientServices=new ClientServices();
		String rs = clientServices.getServices(uDetail);
		 if(rs.equals(uid))
		 {
			 request.getSession().setAttribute("uid", uid);
request.getRequestDispatcher("w.jsp").forward(request, response);

		 }
		 else if(rs.equalsIgnoreCase("wrongotp"))
		 {    out.println("<a href=reotp>Reotp</a>");
			 request.getRequestDispatcher("index.jsp").include(request, response);
 
		 }
		 else if(rs.equals("User AllReady Login"))
		 {
			 out.println("User AllReady Login");
			 request.getRequestDispatcher("index.jsp").include(request, response);
			  
		 }
		 else
		 {
			 
		 }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
