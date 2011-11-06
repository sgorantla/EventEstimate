
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>VenueSpot:</title>
	  <script type="text/javascript"
    src="http://maps.googleapis.com/maps/api/js?sensor=false">
</script>
<script>
var geocoder;
var map;
var geoData;

var contactLocations = ["New York, NY", "Queens, NY"];
     	             
function initialize() {
  geocoder = new google.maps.Geocoder();
  var myOptions = {
    zoom: 13,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  }
   map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

  for (var i = 0; i < contactLocations.length; i++) {
	 var address = contactLocations[i];
  	GeoAddress(address);
  }
}
	
function GeoSetAddress(map, address) {
	var geoLocale;
	var image = new google.maps.MarkerImage('images/spot_contact.png');
	geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
          map: map,
          icon: image,
          position: results[0].geometry.location
//	          geoLocale.push(address,"","",);
//	      	  geoData.push(geoLocale);
     	});
    } else {
      alert("Geocode was not successful for the following reason: " + status);
    }
  });
}

	
function codeAddress() {
  var address = document.getElementById("address").value;
  alert(address);
  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
      });
    } else {
      alert("Geocode was not successful for the following reason: " + status);
    }
  });
}
</script>
</head>
<body onload="initialize()">
 <div id="map_canvas" style="width: 320px; height: 480px;"></div>
  <div>
    <input id="address" type="textbox" value="Sydney, NSW">
    <input type="button" value="Encode" onclick="codeAddress()">
  </div>
</body>
</html>