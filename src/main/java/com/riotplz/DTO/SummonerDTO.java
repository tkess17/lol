package com.riotplz.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SummonerDTO {
	
	private String id;
	private String accountId;
	private String puuid;
	private String name;
	private String profileIconId;
	private String revisionDate;
	private String summonerLevel;

}
