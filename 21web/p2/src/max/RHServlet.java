package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RHServlet")
public class RHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   PrintWriter out = response.getWriter();
    	   String uidmob = request.getParameter("uidmob");
    	     String[] d = uidmob.split(",");
    	       String uid=d[0];
    	       String mob=d[1];
    	       System.out.println("eservlet "+uid);
    	       ClientServices clientServices=new ClientServices();
    	       String res = clientServices.getServices(uid, mob);
    	       System.out.println("in c "+res);
    	       out.println(res);
    	       
		
	}

}
