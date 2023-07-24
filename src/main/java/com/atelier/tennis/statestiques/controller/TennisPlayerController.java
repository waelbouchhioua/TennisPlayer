package com.atelier.tennis.statestiques.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atelier.tennis.statestiques.model.Players;
import com.atelier.tennis.statestiques.servie.TennisPlayerService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class TennisPlayerController {
	@Autowired (required = true)
	public  TennisPlayerService tenisPlayerService;
	  private List<Players> players = new ArrayList<>();
	//  Crée un endpoint qui retourne les joueurs. La liste doit être triée du meilleur au moins bon.
	  @GetMapping("/players")
	    public List<Players> getAllPlayersSortedByRank() {
		
	        return tenisPlayerService.getAllPlayersSortedByRank();
	    }
	  
	  // Endpoint pour retourner les informations d'un joueur par son ID
	    @GetMapping("/players/{id}")
	    public ResponseEntity<Players> getPlayerById(@PathVariable Long id) throws Exception {
	    	
	    	 return tenisPlayerService.getPlayerById(id);
	    }
	    
	    
	    ///- Pays qui a le plus grand ratio de parties gagnées
	    @GetMapping("/countries/ratio")
	    public String getCountryRatio() {
	    	
	    	 return tenisPlayerService.getCountryRatio();
	    }
	    //- IMC moyen de tous les joueurs
	    @GetMapping("/players/imc")
	    public double getAverageIMC() {
	    	
	    	 return tenisPlayerService.getAverageIMC();
	    }
	    
	 //   - La médiane de la taille des joueurs
	    @GetMapping("/players/median")
	    public double getMedianHeight() {
	    	return tenisPlayerService.getMedianHeight();
	    }
	 // Chargez les données JSON à partir d'un fichier )
	    @PostConstruct
	    public void loadData() {
	    	tenisPlayerService.loadData(); 
	    }
	    
	    
}
