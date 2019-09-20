package max;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RHDAO {
	
	public static String insertOTP(OTPBean otpbean)
	{
		try {
			Session s = Sessionutility.getsession();
		Transaction tx = s.beginTransaction();
			s.saveOrUpdate(otpbean);
		  tx.commit();
		 return otpbean.getOtp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
