<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Client Flow Example TEST</title>
	<script>		
		var userName = "<%=request.getParameter("userName")%>";


		var path = "http://localhost:9999/ctctOAuth2WebClient/contacts/tab?userName="+userName;

		// this is the code to run once we are redirected
		var accessToken = window.location.hash.substring(1);
		/// grab the "env" cookie and use it in the path ...
		var queryParams = [ accessToken ];
		var query = queryParams.join('&');
		var url = path + "&" + query;

		alert("Oauth login redirection successful ! \n\nRequesting API resource : " + url + "\nusing acess token ...");

		function getList()
		{
			window.opener.location = url;
		}

	</script>
</head>
<body onload="getList()">
</body>
</html>
