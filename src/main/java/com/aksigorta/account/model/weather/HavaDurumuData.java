package com.aksigorta.account.model.weather;

import java.util.List;

public class HavaDurumuData {
	private List<HavaDurumuRequest> request;
	private List<HavaDurumuWeather> weather;
	
	public List<HavaDurumuRequest> getRequest() {
		return request;
	}
	public void setRequest(List<HavaDurumuRequest> request) {
		this.request = request;
	}
	public List<HavaDurumuWeather> getWeather() {
		return weather;
	}
	public void setWeather(List<HavaDurumuWeather> weather) {
		this.weather = weather;
	}
}
