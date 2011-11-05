<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
  html { height: 100% }
  body { height: 100%; margin: 0; padding: 0 }
  #map_canvas { height: 100% }
</style>
<script type="text/javascript"
    src="http://maps.googleapis.com/maps/api/js?sensor=false">
</script>
<script type="text/javascript">
  function initialize() {
    var latlng = new google.maps.LatLng(40.716668, -74);
    var myOptions = {
      zoom: 13,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);
     
	  var marker = new google.maps.Marker({
	      position: latlng, 
	      map: map, 
	      title:"Hello World!"
		  });

	  var image = 'images/android.png';
		var latlnggg = new google.maps.LatLng(40.726345, -74);
		var beachMarker = new google.maps.Marker({
	      position: latlnggg,
	      map: map,
	      icon: image
	  });
  }

</script>
</head>
<body onload="initialize()">
  <div id="map_canvas" style="width:70%; height:100%"></div>
</body>
</html>