import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class CL {
	public static void main(String[] args) {
		try {
			   RestTemplate rclient = new RestTemplate();
			   String url="http://localhost:8080/1SpringRestServer/data1/";
			  HttpHeaders header = new HttpHeaders();
			  header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			  header.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entry = new  HttpEntity<String>("parameters", header);
			ResponseEntity<String> res = rclient.exchange(url, HttpMethod.GET, entry, String.class);
			System.out.println("cl Res --- " +res.getBody());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
