
/**
 * Map functions for loading contacts and getting geoCoordinates.  
 */


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
