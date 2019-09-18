package max;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RequestHandlerSpringRest {
	//http://localhost:8080/1SpringRestServer/
	
	@RequestMapping(value="data", method=RequestMethod.GET)
	public @ResponseBody String getData()
	{
		System.out.println("innnn");
		return "Vikram ";
	}
	
	@RequestMapping(value="/data1", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getData1()
	{   
	   List<User> list=	new ArrayList<User>();
	  User u=new User();
	  u.setUid(11);
	  u.setName("raja");
	  u.setAdd("noida");
		list.add(u);
		
		 User u1=new User();
		  u1.setUid(21);
		  u1.setName("baja");
		  u1.setAdd("noida");
			list.add(u1);
		
		return list;
	}
	
	
	

}
