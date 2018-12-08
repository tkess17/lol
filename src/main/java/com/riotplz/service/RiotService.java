package com.riotplz.service;

import org.json.JSONException;

import com.riotplz.DTO.SummonerDTO;

public interface RiotService {
	SummonerDTO getSummonerByName(String summoner) throws JSONException;
}
