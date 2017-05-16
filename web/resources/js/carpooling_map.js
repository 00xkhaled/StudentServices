
var directionDisplay;


  var directionsService = new google.maps.DirectionsService();// Create new map 
  
  
  var map; // Map initalization  
  
  
  $(function(){
	$('#submit').click(function(){
		calcRoute();
	});
   calcRoute();
	initialize();
  }); // Main function that calls everything one you write the from and to fields and 
     //  calculate the route 
  
  
  
  // initialize the Google Map API.
  function initialize() {
    directionsDisplay = new google.maps.DirectionsRenderer();
    var Mumbai = new google.maps.LatLng(19.075984, 72.877656);
    var mapOptions = {
      zoom:15,
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      center: Mumbai
    }
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    directionsDisplay.setMap(map);
  }
  

  //Find the Start and End Destination on Google MapS and calculate the route from and to 
  
  function calcRoute() {
    var start = document.getElementById('start').value;
    var end = document.getElementById('end').value;
    var request = {
        origin:start,
        destination:end,
        travelMode: google.maps.DirectionsTravelMode.DRIVING
    };
    directionsService.route(request, function(response, status) {
      if (status == google.maps.DirectionsStatus.OK) {
        directionsDisplay.setDirections(response);
      }
    });
  }