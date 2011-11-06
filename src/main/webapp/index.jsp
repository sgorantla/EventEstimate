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
  	<script type="text/javascript"src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
  	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
  	<script type="text/javascript" src="/js/mapfunstions.js"></script>
	<style type="text/css">
		a {color:#FFF}
		a.btn-2 {background:#febc00 url(images/btn-bg.gif) repeat-x left top; border:1px solid #252525; color:#613a02; font-size:24px; font-weight:bold; padding:12px 30px; text-decoration:none; text-shadow:0 1px 0 rgba(255,255,255,.6); -webkit-border-radius:5px; -moz-border-radius:5px; border-radius:5px; display:block}
		.so-ctr {position:absolute; right:0; height:100%; min-height:100%; max-height:100%; width:336px;background:#f1bf25; background:#000; background:rgba(0,0,0,.8)}
		.so-inner {padding:25px}
		.venue-feature {width:198px; float:right}
		.venue-details ul { list-style-type:none; margin:0 0 25px 0; padding:0}
		.venue-details li { padding:8px 0; margin:0}
		.venue-title {font-size:16px; color:#FFF}
		.venue-location {font-size:12px; color:#797979}
		.venue-price {color:#fecf00; font-size:20px; font-weight:bold}
		.spot {background:#202020; padding:10px 15px ; margin-bottom:2px}
		.spot-name {font-size:14px; font-weight:bold; color:#fecf00}
		.categories-bg {background:#161616; padding:15px 25px 25px; border-top:1px solid #494948; border-top:1px solid #363636}
		.bdr-btm {border-bottom:1px dotted #3e3e3e}
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
<body onload="EventTemplate.initializeMap()">

   <div id="googleMap" style="z-index:0; height:100%;display:none;"></div>
  <div class="wrap">
	<div id="map_canvas" style="z-index:0; height:100%;"></div>
    <div class="head" style="position:absolute:top:0;">
      <div class="head-inner style="width:600px;">
        <h1>VenueSpot: the easiest and most interactive way to locate, book &amp; promote your next business event.</h1>
      </div>

    </div>
    
    <div class="callout">
      <div class="callout-inner">
        <h2><span>VenueSpot</span> is the easiest and most interactive way to locate, book &amp; promote your next business event.</h2>
        <div class="left">
          <p>VenueSpot will guide you on locating the best venue and local businesses to support your event for you, your customers, and your partners</p>

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
