package com.aksigorta.account.web;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.aksigorta.account.model.weather.HavaDurumu;
import com.aksigorta.account.model.weather.view.Part1;
import com.aksigorta.account.webservis.JSONParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@SessionAttributes("user")
public class WeatherContoller {


	private Logger log = LoggerFactory.getLogger(WeatherContoller.class);
	private String Celcius;
	private String ikiNoktaUstUste;



	@RequestMapping(value = "/getCityTemp", method = RequestMethod.GET)
	public String goToService(@RequestParam Map<String, String> params, Model model) {
		String sehir = params.get("sehir");
		LocalDate dateOfToday = LocalDate.now();
		LocalDate dateOfPastTenDay = LocalDate.now().minusDays(10);
		String weatherUrl = "http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=07476bbf29ea42bcbfc104920172511&" +
	    "q=" + sehir +
		"&format=json&" +
	    "date="+ dateOfPastTenDay +
		"&enddate=" + dateOfToday +
		"&tp=tp=24&lang=lang=tr";
		try {
			
			String json = JSONParser.getJSONFromUrl(weatherUrl);
			Gson gson = new GsonBuilder().create();
			HavaDurumu havaDurumu = gson.fromJson(json, HavaDurumu.class);
			System.out.println("Link : " + weatherUrl);
			model.addAttribute("part1", createLastYearWeatherArray10(havaDurumu));
			model.addAttribute("Celcius", Celcius);
			model.addAttribute("ikiNoktaUstUste",ikiNoktaUstUste);
			
		
		} catch (Exception e) {
			log.error("Rest Error", e);
		}

		return "welcome";
	}
	

	public List<Part1> createLastYearWeatherArray10(HavaDurumu havaDurumu) throws IOException 
	{
	
	        
		List<Part1> part1List = new ArrayList<Part1>();
		for (int i = 0; i < 11; i++) 
		{
			Part1 part1 = new Part1();
			part1.setTempMax(havaDurumu.getData().getWeather().get(i).getMaxtempC());
			part1.setDate(havaDurumu.getData().getWeather().get(i).getDate());
			part1List.add(part1);
		
			System.out.println(part1.getTempMax());
		}
		Celcius = " Celcius";
		ikiNoktaUstUste = " : ";
		
		return part1List;
	}

}

