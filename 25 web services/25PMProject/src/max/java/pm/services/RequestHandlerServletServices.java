package max.java.pm.services;

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




@WebServlet("/RequestHandlerServletServices")
public class RequestHandlerServletServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mob = request.getParameter("mob");
		  PrintWriter out = response.getWriter();
		 try {
			Client client = Client.create();
WebResource wr = client.resource("http://localhost:8080/25RestServer/ses/rhr/otp");
ClientResponse cres = wr.accept("application/text").post(ClientResponse.class,mob); 
   String res = cres.getEntity(String.class);
   System.out.println("otp "+res);
   out.println(res); 
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}

}
