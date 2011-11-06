<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Client Flow Example TEST</title>
	<script>		
		var userName = "<%=request.getParameter("userName")%>";

        var port = window.location.hostname( port.indexOf( ":" ) + 1 );
        var path = 'http://' + window.location.hostname + ':' + port + '/contacts/tab.j?userName='+userName;

//		var path = "http://localhost:9999/eventEstimator/contacts/tab.j?userName="+userName;

		// this is the code to run once we are redirected
		var accessToken = window.location.hash.substring(1);
		/// grab the "env" cookie and use it in the path ...
		var queryParams = [ accessToken ];
		var query = queryParams.join('&');
		var url = path + "&" + query;


//		alert("Oauth login redirection successful ! \n\nRequesting API resource : " + url + "\nusing acess token ...");

		function getList()
		{
            $.ajax({ url: url, cache: false , async:false});
			window.opener.EventTemplate.stepToForm();

            window.close();
		}

	</script>
</head>
<body onload="getList()">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js"></script>
<script src="http://malsup.com/jquery/block/jquery.blockUI.js"></script>

</body>
</html>
