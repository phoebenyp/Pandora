(function(A) {
	if (!Array.prototype.forEach)
		A.forEach = A.forEach || function(action, that) {
			for (var i = 0, l = this.length; i < l; i++)
				if (i in this)
					action.call(that, this[i], i, this);
			};

		})(Array.prototype);

		var
		mapObject,
		markers = [],
		markersData = {
			// 'Historic': [
			// {
			// 	name: 'Arc de Triomphe',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Arc de Triomphe',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// },
			// {
			// 	name: 'Pantheon',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Pantheon',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// }
			// ],
			// 'Sightseeing': [
			// {
			// 	name: 'Open Bus',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Open Bus',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// },
			// {
			// 	name: 'Senna River Tour',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Senna River Tour',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// }
			// ],
			// 'Museums': [
			// {
			// 	name: 'Louvre',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Louvre',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// },
			// {
			// 	name: 'Pompidou ',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Pompidou',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// }
			// ],
			// 'Skyline': [
			// {
			// 	name: 'Tour Eiffel',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Tour Eiffel',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// },
			// {
			// 	name: 'Montparnasse',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Montparnasse',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// }
			// ],
			// 'Eat_drink': [
			// {
			// 	name: 'Beaubourg',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Beaubourg',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// },
			// {
			// 	name: 'St. Germain des Prés',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'St. Germain des Prés',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// }
			// ],
			// 'Walking': [
			// {
			// 	name: 'Trocadero',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Trocadero',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// },
			// {
			// 	name: 'Champs-Élysées',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Champs-Élysées',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// }
			// ],
			// 'Churches': [
			// {
			// 	name: 'Notre Dame',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Notre Dame',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// },
			// {
			// 	name: 'Madeleine',
			// 	location_latitude: 25.138881, 
			// 	location_longitude: 121.750891,
			// 	map_image_url: 'img/thumb_map_1.jpg',
			// 	name_point: 'Madeleine',
			// 	description_point: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
			// 	get_directions_start_address: '',
			// 	phone: '+3934245255',
			// 	url_point: 'single_tour.html'
			// }
			// ]

		};

			var mapOptions = {
				zoom: 16,
				center: new google.maps.LatLng(25.129925,121.740365),
				mapTypeId: google.maps.MapTypeId.ROADMAP,

				mapTypeControl: false,
				mapTypeControlOptions: {
					style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
					position: google.maps.ControlPosition.LEFT_CENTER
				},
				panControl: false,
				panControlOptions: {
					position: google.maps.ControlPosition.TOP_RIGHT
				},
				zoomControl: true,
				zoomControlOptions: {
					style: google.maps.ZoomControlStyle.LARGE,
					position: google.maps.ControlPosition.LEFT_CENTER
				},
				 scrollwheel: false,
				scaleControl: false,
				scaleControlOptions: {
					position: google.maps.ControlPosition.LEFT_CENTER
				},
				streetViewControl: true,
				streetViewControlOptions: {
					position: google.maps.ControlPosition.LEFT_CENTER
				},
				styles: [
					{
						"featureType": "administrative.country",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "administrative.province",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "administrative.locality",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "administrative.neighborhood",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "administrative.land_parcel",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "landscape.man_made",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "simplified"
							}
						]
					},
					{
						"featureType": "landscape.natural.landcover",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "landscape.natural.terrain",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "poi.attraction",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "poi.business",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "poi.government",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "poi.medical",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "poi.park",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "poi.park",
						"elementType": "labels",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "poi.place_of_worship",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "poi.school",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "poi.sports_complex",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "road.highway",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "road.highway",
						"elementType": "labels",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "road.highway.controlled_access",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "road.arterial",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "simplified"
							}
						]
					},
					{
						"featureType": "road.local",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "simplified"
							}
						]
					},
					{
						"featureType": "transit.line",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "transit.station.airport",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "transit.station.bus",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "transit.station.rail",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "water",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "on"
							}
						]
					},
					{
						"featureType": "water",
						"elementType": "labels",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					}
				]
			};
			var
			marker;
			mapObject = new google.maps.Map(document.getElementById('map'), mapOptions);
			for (var key in markersData)
				markersData[key].forEach(function (item) {
					marker = new google.maps.Marker({
						position: new google.maps.LatLng(item.location_latitude, item.location_longitude),
						map: mapObject,
						icon: 'img/pins/' + key + '.png',
					});

					if ('undefined' === typeof markers[key])
						markers[key] = [];
					markers[key].push(marker);
					google.maps.event.addListener(marker, 'click', (function () {
      closeInfoBox();
      getInfoBox(item).open(mapObject, this);
      mapObject.setCenter(new google.maps.LatLng(item.location_latitude, item.location_longitude));
     }));

					
				});
	

		// function hideAllMarkers () {
		// 	for (var key in markers)
		// 		markers[key].forEach(function (marker) {
		// 			marker.setMap(null);
		// 		});
		// };
		
		// function toggleMarkers (category) {
		// 	hideAllMarkers();
		// 	closeInfoBox();

		// 	if ('undefined' === typeof markers[category])
		// 		return false;
		// 	markers[category].forEach(function (marker) {
		// 		marker.setMap(mapObject);
		// 		marker.setAnimation(google.maps.Animation.DROP);

		// 	});
		// };

		// function closeInfoBox() {
		// 	$('div.infoBox').remove();
		// };

		// function getInfoBox(item) {
		// 	return new InfoBox({
		// 		content:
		// 		'<div class="marker_info" id="marker_info">' +
		// 		'<img src="' + item.map_image_url + '" alt="Image"/>' +
		// 		'<h3>'+ item.name_point +'</h3>' +
		// 		'<span>'+ item.description_point +'</span>' +
		// 		'<div class="marker_tools">' +
		// 		'<form action="http://maps.google.com/maps" method="get" target="_blank" style="display:inline-block""><input name="saddr" value="'+ item.get_directions_start_address +'" type="hidden"><input type="hidden" name="daddr" value="'+ item.location_latitude +',' +item.location_longitude +'"><button type="submit" value="Get directions" class="btn_infobox_get_directions">Directions</button></form>' +
		// 			'<a href="tel://'+ item.phone +'" class="btn_infobox_phone">'+ item.phone +'</a>' +
		// 			'</div>' +
		// 			'<a href="'+ item.url_point + '" class="btn_infobox">Details</a>' +
		// 		'</div>',
		// 		disableAutoPan: false,
		// 		maxWidth: 0,
		// 		pixelOffset: new google.maps.Size(10, 125),
		// 		closeBoxMargin: '5px -20px 2px 2px',
		// 		closeBoxURL: "img/close_infobox.png",
		// 		isHidden: false,
		// 		alignBottom: true,
		// 		pane: 'floatPane',
		// 		enableEventPropagation: true
		// 	});
		// };