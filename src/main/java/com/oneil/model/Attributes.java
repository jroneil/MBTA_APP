package com.oneil.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes {
private String track;
@JsonProperty("stop_sequence")
private String stopSequence;
private String status;
@JsonProperty("schedule_relationship")
private String scheduleRelationship;
@JsonProperty("direction_id")
private Integer directionId;
@JsonProperty("departure_time")
private String departureTime;
@JsonProperty("arrival_time")
private String arrivalTime;


public String getTrack() {
	return track;
}
public void setTrack(String track) {
	this.track = track;
}
public String getStopSequence() {
	return stopSequence;
}
public void setStopSequence(String stopSequence) {
	this.stopSequence = stopSequence;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getScheduleRelationship() {
	return scheduleRelationship;
}
public void setScheduleRelationship(String scheduleRelationship) {
	this.scheduleRelationship = scheduleRelationship;
}

public String getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(String departureTime) {
	this.departureTime = departureTime;
}
public String getArrivalTime() {
	return arrivalTime;
}
public void setArrivalTime(String arrivalTime) {
	this.arrivalTime = arrivalTime;
}
public Integer getDirectionId() {
	return directionId;
}
public void setDirectionId(Integer directionId) {
	this.directionId = directionId;
}



}
