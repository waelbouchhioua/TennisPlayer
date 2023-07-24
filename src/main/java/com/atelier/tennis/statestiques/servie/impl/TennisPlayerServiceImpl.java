package com.atelier.tennis.statestiques.servie.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atelier.tennis.statestiques.model.PlayerData;
import com.atelier.tennis.statestiques.model.Players;
import com.atelier.tennis.statestiques.servie.TennisPlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class TennisPlayerServiceImpl implements TennisPlayerService {
	 private List<Players> players = new ArrayList<>();
	  @Override
	  public List<Players> getAllPlayersSortedByRank() {
		  if (players.isEmpty()) {
	            loadData();
	        }
	        return players.stream()
	                .sorted(Comparator.comparingInt(p -> p.getData().getRank()))
	                .collect(Collectors.toList());
	    }
	  @Override
	  public ResponseEntity<Players> getPlayerById( Long id) throws Exception {
	    	 if (players.isEmpty()) {
	             loadData();
	         }
	        // Recherchez le joueur par ID dans la liste 
	        Players player = players.stream()
	                .filter(p -> p.getId().equals(id))
	                .findFirst()
	                .orElseThrow(() -> new Exception("players not found for this id :: " + id));

	        if (player != null) {
	            return ResponseEntity.ok(player);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	  @Override
	  public String getCountryRatio() {
	    	 if (players.isEmpty()) {
	             loadData();
	         }
	        Map<String, Double> winRatioByCountry = players.stream()
	                .collect(Collectors.groupingBy(
	                        player -> player.getCountry().getCode(),
	                        Collectors.averagingDouble(player -> player.getData().getLast().stream().mapToInt(i -> i).average().orElse(0.0))
	                ));

	        String countryWithHighestWinRatio = Collections.max(winRatioByCountry.entrySet(), Map.Entry.comparingByValue()).getKey();
	        return "Pays avec le plus grand ratio de parties gagnées : " + countryWithHighestWinRatio;
	    }
	    //- IMC moyen de tous les joueurs
	  @Override
	    public double getAverageIMC() {
	    	 if (players.isEmpty()) {
	             loadData();
	         }
	        double average_IMC = players.stream()
	                .mapToDouble(player -> {
	                    double heightInMeters = player.getData().getHeight() / 100.0;
	                    return player.getData().getWeight() / (heightInMeters * heightInMeters);
	                })
	                .average()
	                .orElse(0.0);

	        return average_IMC;
	    }
	    
	 //   - La médiane de la taille des joueurs
	  @Override
	    public double getMedianHeight() {
		  if (players.isEmpty()) {
	             loadData();
	         }
	        List<Integer> heights = players.stream()
	                .map(player -> player.getData().getHeight())
	                .sorted()
	                .collect(Collectors.toList());

	        int size = heights.size();
	        if (size % 2 == 0) {
	            return (heights.get(size / 2 - 1) + heights.get(size / 2)) / 2.0;
	        } else {
	            return heights.get(size / 2);
	        }
	    }
	  @Override
	    public void loadData() {
	        try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            InputStream inputStream = getClass().getResourceAsStream("/headtohead.json");
	            PlayerData playerData = objectMapper.readValue(inputStream, PlayerData.class);
	            players = playerData.getPlayers();
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	    }
	public void setPlayers(List<Players> playersList) {
		this.players=playersList;
		
	}
}
