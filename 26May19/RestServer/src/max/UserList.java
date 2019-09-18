package max;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	public boolean checkUserDetail(String userid , String pass)
	{
		List<User> l=new ArrayList<User>();
		User u=new User();
		u.setUserid("abhay");
		u.setPass("abhay11");
		l.add(u);
		
		User u1=new User();
		u1.setUserid("anand");
		u1.setPass("anand11");
		l.add(u1);
		
		for(User p:l)
		{
			if(p.getUserid().equalsIgnoreCase(userid) && (p.getPass().equalsIgnoreCase(pass)))
			{
				return true;
			}
			
		}
		return false;
	}

}
