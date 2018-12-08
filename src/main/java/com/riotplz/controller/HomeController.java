package com.riotplz.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riotplz.DTO.SummonerDTO;
import com.riotplz.service.RiotService;

@RestController
public class HomeController {

	@Autowired
	private RiotService riotService;

	// @RequestMapping("/")
	// public String testMethod() {
	// System.out.println("base url is called");
	// return "hello";
	// }

	@RequestMapping("/summoner/search")
	public String summonerSearch(@RequestParam String summonerName) throws JSONException {
		SummonerDTO summonerDTO = riotService.getSummonerByName(summonerName);
		if (summonerDTO == null) {
			return "no summoner found";
		}
		return summonerDTO.getProfileIconId();
	}
}
