<html>
<head>
<title>Client Flow Example 1 Redirect Page</title>
</head>
<body>    
	<script>
		function displayUser(user) {
			var userName = document.getElementById('userName');
			var greetingText = document.createTextNode('Greetings, '
					+ user.name + '.');
			userName.appendChild(greetingText);
		}

		var appID = 136631503101502;
		if (window.location.hash.length == 0) {
		    
			var path = 'https://www.facebook.com/dialog/oauth?';
			var queryParams = [ 'client_id=' + appID,
					'redirect_uri=' + window.location, 'response_type=token' ];
			var query = queryParams.join('&');
			var url = path + query;
			//alert(window.location);
			window.open(url);
		} else { 	
			// this is the code to run once we are redirected 
			var accessToken = window.location.hash.substring(1);
			var path = "https://graph.facebook.com/me?";
			var queryParams = [ accessToken, 'callback=displayUser' ];
			var query = queryParams.join('&');
			var url = path + query;

			// use jsonp to call the graph
			var script = document.createElement('script');
			script.src = url;
			document.body.appendChild(script);
		}
	</script>
	<p id="userName"></p>
</body>
</html>
