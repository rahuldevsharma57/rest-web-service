package max.java.rest.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import max.EncryptionPasswordANDVerification;

import org.json.JSONObject;

@Path("/usrLogin")
public class UserLogin {
	@POST
	@Path("/otp")
	// generateotp      date 19/7/2019 by veerpal
	public static String generateOTP(@QueryParam("uid") String uid, @QueryParam("mob") String mob) {
		System.out.println("ser "+uid);
		System.out.println(mob+" mmmmm");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= 10; i++) {
			sb.append(new Random().nextInt(9));
		}

		try {

			Connection con = JDBCConnection.getConnn();
			PreparedStatement ps = con
					.prepareStatement("update login_master1  set mobile = ? ,otp = ? , timeotp = ? where uid = ?");
			ps.setString(1, mob);
			ps.setString(2, sb.toString().substring(5));

			Date d = new Date();
			int mint = d.getMinutes();
			ps.setString(3, "" + mint);
			ps.setString(4, uid);
			int i = ps.executeUpdate();
			if (i > 0) {
				return sb.toString().substring(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@POST
	@Path("/login")
	public String login(String logindetail) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			JSONObject jsondetail=new JSONObject(logindetail);
			String uid=jsondetail.getString("uid");
			String pass=EncryptionPasswordANDVerification.encryptionPassword(jsondetail.getString("pass"));
			String mobile=jsondetail.getString("mobile");
			String otp=jsondetail.getString("otp");
			con = JDBCConnection.getConnn();
			ps = con.prepareStatement("select uid,status,mobile,otp from login_master1 where uid = ? and pass = ?");
			ps.setString(1, uid);
			ps.setString(2, pass);
			
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String st = rs.getString("status");
				
				if (st.equalsIgnoreCase("Y")) {
					      
					String moble = rs.getString("mobile");
					String otpp = rs.getString("otp");
					if(mobile.equals(moble) && otpp.equals(otp) )
					{
						
						ps = con.prepareStatement("update login_master1 set status = ? where uid =? ");
						ps.setString(1, "N");
						ps.setString(2, uid);
						int i = ps.executeUpdate();
						if (i > 0) {
							String ud = rs.getString("uid");
							return ud;
						}
						
						
					}
					else
					{
						return "wrongotp";
					}

				}

				else {
					return "User AllReady Login";
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "wrong";

	}

	{

	}

}
