<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>VenueSpot: The easiest and most interactive way to locate, book and promote your next business event.</title>
	<meta name="generator" content="TextMate http://macromates.com/">
	<meta name="author" content="Dumont, Dan">
	<link href="css/master.css" rel="stylesheet" type="text/css">
	<link href="css/reset.css" rel="stylesheet" media="all" type="text/css"/>
  	<link href="css/common.css" media="all" rel="stylesheet" type="text/css"/>
  	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:700' rel='stylesheet' type='text/css'>
  	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:700' rel='stylesheet' type='text/css'>
  	<script type="text/javascript"src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
  	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
  	<script type="text/javascript" src="/js/mapfunstions.js"></script>
 <script type="text/javascript">
  function initializemap() {
    var latlng = new google.maps.LatLng(40.716668, -74);
    var myOptions = {
      zoom: 13,
      center: latlng,
      mapTypeControl: false,
      mapTsypeControlOptions: {
        style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
      },
    zoomControl: true,
    zoomControlOptions: {
        style: google.maps.ZoomControlStyle.SMALL
      },
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
//     setVenueLocationMarker(map, venueLocations);
//     setContactMarkers(map, contactLocations);
  }
  </script>
    <style>
        html {
          background: url(/eventEstimator/images/map-bg.jpg) no-repeat center center fixed;
          -webkit-background-size: cover;
          -moz-background-size: cover;
          -o-background-size: cover;
          background-size: cover;
          margin:0; padding:0;
        }

    </style>
</head>
<body onload="initializemap()">

  <div class="wrap">
       <div id="map_canvas" style="z-index:0; height:100%"></div>
    <div class="head">
      <div class="head-inner style="width:600px;">
        <h1>VenueSpot: the easiest and most interactive way to locate, book &amp; promote your next business event.</h1>
      </div>

    </div>
    
    <div class="callout">
      <div class="callout-inner">
        <h2><span>VenueSpot</span> is the easiest and most interactive way to locate, book &amp; promote your next business event.</h2>
        <div class="left">
          <p>VenueSpot will guide you on locating the best venue and local businesses to support your event, for you and your customers and partners</p>

          <ul>
            <li><span class="ic-transport"></span><a href="#">Transportation</a></li>
            <li><span class="ic-analytics"></span><a href="#">Location Analytics</a></li>
            <li><span class="ic-food"></span><a href="#">Custom Food Choice</a></li>
          </ul>
        </div>
        <a id="getStarted" class="get-started" href="#">Let's Get Started!</a>

      </div>
    </div>
    <div class="push"></div> <!-- for sticky footer -->    
  </div>
  
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
