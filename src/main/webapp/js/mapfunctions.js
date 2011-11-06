
/**
 * Map functions for loading contacts and getting geoCoordinates.  
 */


function GeoAddress(address) {
		var geoLocale;
	  	geocoder.geocode( { 'address': address}, function(results, status) {
	    if (status == google.maps.GeocoderStatus.OK) {
	      map.setCenter(results[0].geometry.location);
	      var marker = new google.maps.Marker({
	          map: map,
	          position: results[0].geometry.location
// 	          geoLocale.push(address,"","",);
// 	      	  geoData.push(geoLocale);
	     	});
	    } else {
	      alert("Geocode was not successful for the following reason: " + status);
	    }
	  });
}


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
