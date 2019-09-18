package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

////http://localhost:8080/RestServer/services/rh/addition?n1=var&n2=var

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 PrintWriter out = response.getWriter();
    	String userid = request.getParameter("userid");
    String pass = request.getParameter("pass");
    	 try {
    		 
			   Client client = Client.create();
  String url="http://localhost:8080/RestServer/services/rh/addition?userid="+userid+"&pass="+pass+"";		   
WebResource wr = client.resource(url);
   ClientResponse cr = wr.accept("application/text").post(ClientResponse.class);
    		String rslt = cr.getEntity(String.class);
    		System.out.println("rslt in "+rslt);
    		out.println("RSLT "+rslt);
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    
    	
    	
	}

}
