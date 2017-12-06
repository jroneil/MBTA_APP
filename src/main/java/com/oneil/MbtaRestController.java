package com.oneil;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneil.model.Attributes;
import com.oneil.model.Data;
import com.oneil.model.RelationShips;
import com.oneil.model.StopByLocation;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MbtaRestController {

	/**
	 * Sample URL http://localhost:8080/mbta/42.349/-71.082/10
	 * 
	 * @param lon - Longitude
	 * @param lat - Latitude
	 * @param limit - number of stop
	 * @return List<Data> This rest Call returns a list of all the data objects
	 *         that come from the MBTA
	 */
	@RequestMapping(value = "/mbta/{lat}/{lon}/{limit}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Data> showAll(@PathVariable("lon") String lon, @PathVariable("lat") String lat,
			@PathVariable("limit") String limit) {
		return getMBTAData(lon, lat, limit);
	}

	/**
	 * Sample URL:http://localhost:8080/stops/42.349/-71.082/10
	 * 
	 * @param lon - Longitude
	 * @param lat - Latitude
	 * @param limit -  number of stop
	 * @return List<StopByLocation> This return a StopByLocation list which only
	 *         has the properties associated with the stop
	 */
	@RequestMapping(value = "/stops/{lat}/{lon}/{limit}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StopByLocation> showStops(@PathVariable("lon") String lon, @PathVariable("lat") String lat,
			@PathVariable("limit") String limit) {
		List<Data> dataList = getMBTAData(lon, lat, limit);
		List<StopByLocation> stopByLocationList = new ArrayList<StopByLocation>();
		for (int i = 0; i < dataList.size(); i++) {
			StopByLocation stop = new StopByLocation();
			stop.setArrivalTime(dataList.get(i).getAttributes().getArrivalTime());
			stop.setDepartureTime(dataList.get(i).getAttributes().getDepartureTime());
			stop.setRouteId(dataList.get(i).getRelationShips().getRoute().getData().getId());
			stop.setStopId(dataList.get(i).getRelationShips().getStop().getData().getId());
			stopByLocationList.add(stop);
		}
		return stopByLocationList;
	}

	/**
	 * 
	 * @param lon -  Longitude
	 * @param lat -  Latitude
	 * @param limit - number of stop
	 * @return List<Data> This method preforms the rest call against MBTA's Rest
	 *         API
	 */
	private List<Data> getMBTAData(String lon, String lat, String limit) {
		List<Data> dataList = new ArrayList<Data>();
		try {
			
			// URL("https://api-v3.mbta.com//predictions?filter[latitude]=42.349&filter[longitude]=-71.082&sort=departure_time&include=stop,prediction,schedule,route,vehicle&page[limit]=10");
			String strURl = "https://api-v3.mbta.com//predictions?filter[latitude]=" + lat + "&filter[longitude]=" + lon
					+ "&sort=departure_time&include=stop,prediction,schedule,route,vehicle&page[limit]=" + limit;
			System.out.println("strURl===" + strURl);
			URL url = new URL(strURl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			JSONParser jsonParser = new JSONParser();
			try {
				JSONObject jsonObject = (JSONObject) jsonParser
						.parse(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				JSONArray msg = (JSONArray) jsonObject.get("data");

				Iterator<JSONObject> iterator = msg.iterator();
				while (iterator.hasNext()) {
					ObjectMapper mapper = new ObjectMapper();

					JSONObject dataJsonObject = (JSONObject) iterator.next();
					Data data = new Data();
					RelationShips relationShips = mapper.readValue(
							((JSONObject) dataJsonObject.get("relationships")).toJSONString(), RelationShips.class);
					data.setRelationShips(relationShips);
					Attributes attributes = mapper.readValue(
							((JSONObject) dataJsonObject.get("attributes")).toJSONString(), Attributes.class);
					data.setAttributes(attributes);
					dataList.add(data);
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return dataList;
	}

}
