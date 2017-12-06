$(document).ready(function() {
	Table = $("#StopsTbl").DataTable({
		data:[],
		"columns" : [

		{
			"title" : "Stops Id",
			"data" : "stopId"
		}, {
			"title" : "Route Id",
			"data" : "routeId"
		}, {
			"title" : "Arrival Time",
			"data" : "arrivalTime"
		}, {
			"title" : "Departure Time",
			"data" : "departureTime"
		} ],
		
	    rowCallback: function (row, data) {},
	    filter: false,
	    info: false,
	    ordering: false,
	    processing: true,
	    retrieve: true   
	});
	$("#search-btn").click(function(event) {
		event.preventDefault();
		var lat = $("#lat").val();
		var lon = $("#lon").val();
		var stop = $("#stop").val();
		var myUrl = "stops/" + lat + "/" + lon + "/" + stop;

		$.ajax({

			url : myUrl,
			type : "GET",
			dataType : "json",
		}).done(function(result) {
			Table.clear().draw();
			Table.rows.add(result).draw();
		}).fail(function(jqXHR, textStatus, errorThrown) {
			// needs to implement if it fails
		});
	});

});