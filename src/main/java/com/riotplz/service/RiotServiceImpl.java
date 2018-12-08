package com.riotplz.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.riotplz.DTO.SummonerDTO;
import com.riotplz.service.HTTPService;

@Service
public class RiotServiceImpl implements RiotService {

	@Value("${lol.api.key}")
	String apiKey;

	private static final String SUMMONER_V4_URL = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	private static final String LEAGUE_V4_URL = "https://na1.api.riotgames.com/lol/league/v4/positions/by-summoner/";
	private static final String MATCHLIST_V4_URL = "https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/";
	private static final String MATCH_V4_URL = "https://na1.api.riotgames.com/lol/match/v4/matches/";

	@Override
	public SummonerDTO getSummonerByName(String summoner) throws JSONException {

		String url = String.format("%s%s?api_key=%s", SUMMONER_V4_URL, summoner, apiKey);
		System.out.println(url);

		HTTPService httpRequest = new HTTPService();
		String summonerResponse = httpRequest.getRequestContents(url);

		//Return null if summoner not found
		if (summonerResponse == null) {
			return null;
		}

		//Get summoner info
        JSONObject summonerInfo = new JSONObject(summonerResponse);
        String id = summonerInfo.getString("id");
        String name = summonerInfo.getString("name");
        String summonerLevel = summonerInfo.getString("summonerLevel");
        String accountId = summonerInfo.getString("accountId");
        String profileIconId = summonerInfo.getString("profileIconId");
        String puuid = summonerInfo.getString("puuid");
        String revisionDate = summonerInfo.getString("revisionDate");
        
		SummonerDTO result = new SummonerDTO(id, accountId, puuid, name, profileIconId, revisionDate, summonerLevel);
		
		return result;

	}

}
