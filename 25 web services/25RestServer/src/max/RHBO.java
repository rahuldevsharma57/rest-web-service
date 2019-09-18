package max;

import java.util.Date;
import java.util.Random;

public class RHBO {
	
	public String getOTPDetails(String mobile)
	{
		if(mobile.length()==10)
		{
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<=9;i++)
			{
				sb.append(new Random().nextInt(10));
				
			}
			
			String otp = sb.toString().substring(5);
			OTPBean otpbean=new OTPBean();
			otpbean.setMobile(mobile);
			otpbean.setOtp(otp);
			otpbean.setMint(new Date().getMinutes());
			return RHDAO.insertOTP(otpbean);
			
		}
		return null;
		
	}
}
