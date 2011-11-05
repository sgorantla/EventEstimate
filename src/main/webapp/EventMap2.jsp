<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>VenueSpot: The easiest and most interactive way to locate, book and promote your next business event.</title>
	<link href="css/reset.css" rel="stylesheet" media="all" type="text/css"/>
  <link href="css/common.css" media="all" rel="stylesheet" type="text/css"/>
  <link href="css/master.css" media="all" rel="stylesheet" type="text/css"/>
  <link href='http://fonts.googleapis.com/css?family=Droid+Sans:700' rel='stylesheet' type='text/css'>
  <script type="text/javascript"
    src="http://maps.googleapis.com/maps/api/js?sensor=false">
</script>
  <script type="text/javascript">
  function initialize() {
    var latlng = new google.maps.LatLng(40.716668, -74);
    var myOptions = {
      zoom: 13,
      center: latlng,
      mapTypeControl: false,
      mapTypeControlOptions: {
        style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
      },
    zoomControl: true,
    zoomControlOptions: {
        style: google.maps.ZoomControlStyle.SMALL
      },
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

    setVenueLocationMarker(map, venueLocations);
    setContactMarkers(map, contactLocations);
  }

  var contactLocations = [
	               ['test', 40.766345, -74, 5],
	               ['test1', 40.715345, -73.98504349853510, 4],
	               ['test2', 40.734345, -73.98502349853510, 3],
	               ['test3', 40.724345, -72.98502349853716, 2],
	               ['test4', 40.722345, -74, 1]
	             ];

  var venueLocations = [
	     	               ['Venue Name', 40.724345, -73.98502349853516, 5]
	     	             ];

function setContactMarkers(map, locations) {
	  var image = new google.maps.MarkerImage('images/spot_contact.png');
	  for (var i = 0; i < locations.length; i++) {
	    var contactpoint = locations[i];
	    var myLatLng = new google.maps.LatLng(contactpoint[1], contactpoint[2]);
	    var marker = new google.maps.Marker({
	        position: myLatLng,
	        map: map,
	        icon: image,
	        title: contactpoint[0],
	        zIndex: contactpoint[3]
	    });
	  }
	  }
	  
function setVenueLocationMarker(map, venueLocation) {
	  var imageVenue = new google.maps.MarkerImage('images/spot_venue.png');
	  for (var i = 0; i < venueLocation.length; i++) {
	    var venuePoint = venueLocation[i];
	    var myLatLng = new google.maps.LatLng(venuePoint[1], venuePoint[2]);
	    var marker = new google.maps.Marker({
	        position: myLatLng,
	        map: map,
	        icon: imageVenue,
	        title: venuePoint[0],
	        zIndex: venuePoint[3]
	    });
	  }
	  }

</script>
</head>
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
</style>
<body onload="initialize()">
      <div id="map_canvas" style="z-index:0; height:100%"></div>
    <div class="head" style="position:absolute;z-index:1;top:0;">
      <div class="head-inner" style="width:1600px;">
        <h1>VenueSpot: the easiest and most interactive way to locate, book &amp; promote your next business event.</h1>
      </div>
    </div>
   <!-- Slider --> 
    <div class="so-ctr" style="position:absolute;top:60px;">
      <div class="so-inner clearfix">
        <img src="images/venue_placeholder.gif" class="left ptm"/>
      <ul class="venue-feature venue-details">
        <li class="venue-title">Venue Name</li>
        <li class="venue-location bdr-btm">1320 Prospect Street<br />Cambridge, MA 02139</li>
        <li class="venue-price bdr-btm">$299.00</li>
        <li>Restaurant Rating</li> 
      </ul>
      </div>
      
      <!-- Categories -->
      <div class="categories-bg bdr-btm">
        <ul class="venue-details mbm">
          <li class="bdr-btm"><span class="venue-title">Event Category:</span> <span class="txt-small right">Arts & Entertainment</span></li>
          <li class="btm-bdr"><span class="venue-title">Food Type:</span> <span class="txt-small right">Chinese Food</span></li>
        </ul>
        
        <!-- Food Options -->
        <ul class="venue-details spot">
          <li class="">
            <span class="spot-name">Gold Bowl Masters</span>
            <span class="venue-location right">1.2 Miles</span>
          </li>
          <li class="">
            <span class="venue-location">1320 Prospect Street<br />Cambridge, MA 02139</span>
          </li>
        </ul>
        
        <ul class="venue-details spot">
          <li class="">
            <span class="spot-name">Gold Bowl Masters</span>
            <span class="venue-location right">1.2 Miles</span>
          </li>
          <li class="">
            <span class="venue-location">1320 Prospect Street<br />Cambridge, MA 02139</span>
          </li>
        </ul>
        
        <ul class="venue-details spot">
          <li class="">
            <span class="spot-name">Gold Bowl Masters</span>
            <span class="venue-location right">1.2 Miles</span>
          </li>
          <li class="">
            <span class="venue-location">1320 Prospect Street<br />Cambridge, MA 02139</span>
          </li>
        </ul>
        </div>
        <div class="so-inner venue-location">
          <div class="txt-center pbm"><a class="btn-2" href="#">Book Your Venue!</a></div>
          Don't like your spot? <a href="#">Start over</a>
        </div>
    </div>


</body>
</html>
