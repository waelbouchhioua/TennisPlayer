package com.atelier.tennis.statestiques.servie;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.atelier.tennis.statestiques.model.Players;

public interface TennisPlayerService {

	List<Players> getAllPlayersSortedByRank();

	ResponseEntity<Players> getPlayerById(Long id) throws Exception;

	String getCountryRatio();

	double getAverageIMC();

	double getMedianHeight();

	void loadData();

}
