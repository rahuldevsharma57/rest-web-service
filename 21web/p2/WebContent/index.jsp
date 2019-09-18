<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
  function getData()
  {
	 var mob= document.getElementById("mobile").value;
	 var uid= document.getElementById("uid").value;
	    var xmlhttp;
	 if (window.XMLHttpRequest)
	 {
	 // code for IE7+, Firefox, Chrome, Opera, Safari
	      xmlhttp=new XMLHttpRequest();
	 }
	 else
	 {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	 
	 
	 
	 xmlhttp.onreadystatechange=function()
	 {
	 if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
	//document.getElementById("fname").value
	  document.getElementById("otp").value=xmlhttp.responseText;
	       
	}
	  
	 }
	 
	 
	 
	 
	 
 	 
	 
	 
	 

	  xmlhttp.open("GET","RHServlet?uidmob="+uid+","+mob,true);
	      xmlhttp.send();
	 
	 
  }

</script>
</head>
<body>
    <form action="LoginServlet">
    <table border="3" bgcolor="yellow">
    <tr><td>Uid</td><td><input type="text" name="uid" id="uid"></td></tr>
     <tr><td>Pass</td><td><input type="password" name="pass"></td></tr>
      <tr><td>Mobile</td><td><input type="text" name="mobile" id="mobile"  onblur="getData();"></td>
       <td><input type="text" name="otp" id="otp" size="7" ></td></tr>
       <tr><td><input type="submit" value="login"></td>
    </table>   
</form>
</body>
</html>