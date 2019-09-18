<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
  function getServices()
  {
	 var userid= document.getElementById("userid").value;
	 var pass= document.getElementById("pass").value;
	 
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
	alert("hi "+xmlhttp.responseText);
	  document.getElementById("t1").value=xmlhttp.responseText;
	      
	    
	}
	  
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 xmlhttp.open("GET","ClientServlet?userid="+userid+"&pass="+pass,true);
     xmlhttp.send();
	 
	 
	 
	 
	 
	 
  }


</script>



</head>
<body>

<form action="add">
<table border="2" background="yellow">
<tr><td>First No</td><td><input type="text" name="userid" id="userid"></td></tr>
<tr><td>Second No</td><td><input type="text" name="pass" id="pass"></td></tr>
<tr><td><input type="button" value ="Cal"   onclick="getServices();"></td></tr>
<tr><td><input type="text"  id="t1"></td></tr>


</table>

        

</form>

</body>
</html>