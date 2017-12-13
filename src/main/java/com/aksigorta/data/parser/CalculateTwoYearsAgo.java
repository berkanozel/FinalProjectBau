//package com.aksigorta.data.parser;
//
//import java.time.LocalDate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import com.aksigorta.account.model.weather.HavaDurumu;
//import com.aksigorta.account.web.WeatherContoller;
//import com.aksigorta.account.webservis.JSONParser;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//public class CalculateTwoYearsAgo {
//	private Logger log = LoggerFactory.getLogger(CalculateTwoYearsAgo.class);
//	public void createTwoYearsAgoJsonFormat()
//	{
//	WeatherContoller sehirObject = new WeatherContoller();
//
//	
//	LocalDate dateOfTomorrow = LocalDate.now().plusDays(1);
//	LocalDate dateOfLastYear = dateOfTomorrow.minusYears(1);
//	LocalDate dateOfTwoYearsAgo = dateOfTomorrow.minusYears(2);
//	String twoYearsAgoWeatherUrl = "http://api.worldweatheronline.com/premium/v1/past-weather.ashx?"
//			+ "key=bd2f59c330dc428aa8e105510170610&"
//			+ "q=" + sehir + "&"
//			+ "format=json&"
//			+ "date=" + dateOfTwoYearsAgo
//			+ "enddate=" + dateOfLastYear
//			+ "&tp=tp=24&lang=lang=tr";
//	try 
//	{
//		String json = JSONParser.getJSONFromUrl(twoYearsAgoWeatherUrl);
//
//		Gson gson = new GsonBuilder().create();
//		HavaDurumu havaDurumu = gson.fromJson(json, HavaDurumu.class);
//		System.out.println("Hello From Two Years Ago");
//	} 
//	catch (Exception e) 
//	{
//		log.error("Rest Error", e);
//	}
//	}
//	
//}
