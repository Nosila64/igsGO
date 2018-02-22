<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>
  </head>
  <body>
    <h3>My Google Maps Demo</h3>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQIRnlcNXqCHQV75eFmPe8Li6U_02u5xw&callback=initialize">
    </script>
    <script>
  var geocoder;
  var map;
  function initialize() {
    geocoder = new google.maps.Geocoder();
    var uluru = {lat: 43.643845, lng: 1.386830};
    var latlng = new google.maps.LatLng(43.643845, 1.386830);
    var mapOptions = {
      zoom: 8,
      center: latlng,
    }
    map = new google.maps.Map(document.getElementById('map'), mapOptions);
    var marker = new google.maps.Marker({
        position: uluru,
        map: map,
        icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
      })
  }

  function codeAddress() {
    var address = document.getElementById('address').value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == 'OK') {
        map.setCenter(results[0].geometry.location);
        var marker1 = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        }); 
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
  }
  </script>
<body onload="initialize()">
 <div id="map" style="width: 320px; height: 480px;"></div>
  <div>
    <input id="address" type="textbox" value="Sydney, NSW">
    <input type="button" value="Encode" onclick="codeAddress()">
  </div>
</body>
  </body>
</html>