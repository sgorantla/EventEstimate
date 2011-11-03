<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Client Flow Example TEST</title>
	<script>		
		var env = "<%=request.getParameter("env")%>";
		if (env == "prod")
			env = '.';
		else
			env = "." + env + ".";
		
		var path = "https://api" + env + "constantcontact.com/ws/customers/geeksquad/lists?";

		// this is the code to run once we are redirected 
		var accessToken = window.location.hash.substring(1);
		/// grab the "env" cookie and use it in the path ...		
		var queryParams = [ accessToken ];
		var query = queryParams.join('&');
		var url = path + query;
		
		alert("Oauth login redirection successful ! \n\nRequesting API resource : " + url + "\nusing acess token ...");
		
		function getList()
		{
			window.location = url;
		}

	</script>
</head>
<body onload="getList()">
</body>
</html>
