package max;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Sessionutility {
	static ThreadLocal<Session> session= new  ThreadLocal<Session>();
	static SessionFactory sf=null;
	static
	{
		try {
			
			Configuration conf= new Configuration();
			conf.configure("/max/hibernate.cfg.xml");
			sf=conf.buildSessionFactory();
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public static Session getsession()
	{
		Session s =session.get();
		if(s==null)
		{
		s=sf.openSession();
		session.set(s);
		}
		return s;
	}
public static void closeSession()
{
	   Session s=session.get();
	   if(s!=null)
	   {
		   session.set(null);
	   }
}
	
}
