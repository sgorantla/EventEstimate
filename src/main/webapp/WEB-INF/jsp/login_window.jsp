<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>VenueSpot: The easiest and most interactive way to locate, book and promote your next business event.</title>
	<meta name="generator" content="TextMate http://macromates.com/">
	<meta name="author" content="Dumont, Dan">
	<link href="../css/master.css" rel="stylesheet" type="text/css">
  <link href='http://fonts.googleapis.com/css?family=Droid+Sans:700' rel='stylesheet' type='text/css'>

  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
function poptastic() {
    var userName = document.getElementById("userName").value;
    if (!userName) {
        alert("please enter name");
        return false;
    }
	var url = "../clientflow/tab.j?userName="+userName;

	if (window.location.hash.length == 0) {
		window.location.href = url;
	}
}
</script>
  <div class="wrap">

    <div class="head">
      <div class="head-inner" style="width:600px;">
        <h1>Login.</h1>
      </div>
    </div>
      <form class="venue-form">
          <div align="center">
              <label for="userName">Login:</label>
             <input type="text" id="userName" name="userName" maxlength="50"/>
              <div class="venue">
                <input type="button" value="Login" class="find-venue" onclick="poptastic()">
              </div>
          </div>
             </form>


  <div class="footer">
    <div class="footer-inner">
      <p>Copyright © 2009-2011 VenueSpot. All Rights Reserved.</p>
    </div>

  </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js"></script>
<script src="http://malsup.com/jquery/block/jquery.blockUI.js"></script>
<script src="js/index.js"></script>

</body>
</html>
