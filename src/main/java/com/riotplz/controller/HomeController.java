package com.riotplz.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riotplz.DTO.SummonerDTO;
import com.riotplz.service.RiotService;

@RestController
public class HomeController {

	@Autowired
	private RiotService riotService;

	@RequestMapping("/summoner/search")
	public String summonerSearch(@RequestParam String summonerName, Model model) throws JSONException {
		SummonerDTO summonerDTO = riotService.getSummonerByName(summonerName);
		if (summonerDTO == null) {
			return "no summoner found";
		} else {
			model.addAttribute("found", true);
		}
		model.addAttribute("summoner", summonerDTO);
		System.out.println(model);
		return summonerDTO.getProfileIconId();
	}
}
