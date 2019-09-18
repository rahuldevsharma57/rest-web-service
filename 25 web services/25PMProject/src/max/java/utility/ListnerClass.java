package max.java.utility;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import max.java.pm.login.LoginDAO;

public class ListnerClass implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent sc) {
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sc) {
		
		HttpSession s = sc.getSession();
		String email =(String) s.getAttribute("email");
		LoginDAO loginDAO=new LoginDAO();
		loginDAO.logout(email);
	}

}
