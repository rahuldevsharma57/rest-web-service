package max.java.pm.login;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import max.java.utility.EncryptionPasswordANDVerification;
import max.java.utility.Sessionutility;

public class LoginDAO {
	public String login(String email,String pass)
	{   Session s;
	Transaction tx;
		try {
			s = Sessionutility.getsession();
			tx = s.beginTransaction();
			Criteria cr = s.createCriteria(LoginBean.class);
			cr.add(Restrictions.eq("email", email));
			//cr.add(Restrictions.eq("pass", EncryptionPasswordANDVerification.encryptionPassword(pass)));
			List<LoginBean> list = cr.list();
			System.out.println("list size "+list.size());
			if(list.size()>0)
			{
				for(LoginBean p:list)
				{
					if(p.getPass().equals(EncryptionPasswordANDVerification.encryptionPassword(pass)))
					{
					    
						           if(p.getStatus().equalsIgnoreCase("Y"))
						           {
						        	   p.setStatus("N");
						        	   
						           } 
						           else if(p.getStatus().equalsIgnoreCase("N"))
						           {
						        	   return "User Allready Login "+email;
						           }
						           else
						           {
						        	   return "Locked User Please contact Admin "+email;
						           }
						
						
						
					}
					else
					{
						int ct = p.getCnt();
						  if(ct==0 || ct==1|| ct==2)
						  {
							 p.setCnt(ct+1); 
							 
						  }
						  else
						  {
							  p.setStatus("L");
							  p.setLogintime(new Date().getMinutes());
						  }
						  s.saveOrUpdate(p);
						  tx.commit();
						  s.flush();
						  return "Wrong pass Please contact ";
						
					}
					 
					s.saveOrUpdate(p);
				  tx.commit();
				  s.flush();
				}
			}
			else
			{
				return "invalid Email "+email;
			}
			
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return email;
	}
	
	public void logout(String email)
	{
		try {
			System.out.println("em "+email);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
