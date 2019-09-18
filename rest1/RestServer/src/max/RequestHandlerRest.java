package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/rhr")
public class RequestHandlerRest {
	
	
	@POST
	@Path("/adharRecords")
	public String getadharRecords(String adhar)
	{
		try {
			JSONArray ja=new JSONArray(adhar);
			 for(int i=0; i<ja.length();i++)
			 {
				 JSONObject job = ja.getJSONObject(i);
				String  adhr= job.getString("adhar");
				String  name= job.getString("name");
				String  dob= job.getString("dob");
				System.out.println(adhr+" "+name+"  "+dob);
			 }
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Succcess";
		
	}
	
	
	
	@POST
	@Path("/hello")
	public String getHelllo(String s)
	{
		return "Java "+s.toUpperCase();
	}
	
	//http://localhost:8080/RestServer/services/rhr/hello

	@POST
	@Path("/addition")
public String add(@QueryParam("a") int a,@QueryParam("b") int b)
{  System.out.println("aaaaaaaaaaaaa "+a);
	int c=a+b;
	return "Addition "+c;

	 //{"dob":"11-1-1990","name":"rahul","rollno":"1110"}

}
	@POST
	@Path("/studentRecords")
	public String getStudentRecords(String sdetail)
	{   String jstring=null;
		try {
			JSONObject jb=new JSONObject(sdetail);
			
			String name = jb.getString("name");
			if(name.length()>2)
			{
			String dob = jb.getString("dob");
			String rollno = jb.getString("rollno");
			System.out.println(rollno+ " dob "+dob+ " "+name);
			jb.put("remark", "success");
			jstring=jb.toString();
			
			}
			else
			{
				jb.put("remark", "Name is wrong");
				jstring=jb.toString();
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jstring;
		
		
		
		
	}
	
	
	
	
}