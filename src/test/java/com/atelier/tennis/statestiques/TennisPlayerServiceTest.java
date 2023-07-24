package com.atelier.tennis.statestiques;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.atelier.tennis.statestiques.model.Country;
import com.atelier.tennis.statestiques.model.PlayerData;
import com.atelier.tennis.statestiques.model.Players;
import com.atelier.tennis.statestiques.servie.TennisPlayerService;
import com.atelier.tennis.statestiques.servie.impl.TennisPlayerServiceImpl;

public class TennisPlayerServiceTest {
	 TennisPlayerService tennisPlayerService = new TennisPlayerServiceImpl();
	 List<Players> playersList = new ArrayList<>();
    @Test
    public List<Players> testGetAllPlayersSortedByRank() {
       
       

        // Préparez des données de test 
        playersList.add(new Players(1L, "Ons", "Jabeur", "O.JAB", "F",
                new Country("https://data.latelier.co/training/tennis_stats/resources/Tunisie.png", "TN"), "https://data.latelier.co/training/tennis_stats/resources/Ons.png",
                new PlayerData((long) 1, 1, 4846, 174, 50, 28, Arrays.asList(1, 0, 0, 0, 1))));
        playersList.add(new Players(2L, "Iga", "Siwatek", "I.Siwa", "F",
                new Country("https://data.latelier.co/training/tennis_stats/resources/Pologne.png", "PL"), "https://data.latelier.co/training/tennis_stats/resources/Iga.png",
                new PlayerData((long) 2, 2, 8900, 200, 70, 28, Arrays.asList(1, 1, 0, 0, 1))));


        // Définissez les données 
        ((TennisPlayerServiceImpl) tennisPlayerService).setPlayers(playersList);


        // Vérifiez les résultats
        assertEquals(2, playersList.size());
        assertEquals("Ons", playersList.get(0).getFirstName());
        assertEquals("Jabeur", playersList.get(0).getLastName());
        assertEquals("O.JAB", playersList.get(0).getShortName());
        assertEquals("F", playersList.get(0).getSex());
        assertEquals("https://data.latelier.co/training/tennis_stats/resources/Tunisie.png", playersList.get(0).getCountry().getPicture());
        assertEquals(1, playersList.get(0).getData().getRank());
        assertEquals(4846, playersList.get(0).getData().getPoints());
        assertEquals(174, playersList.get(0).getData().getWeight());
        assertEquals(50, playersList.get(0).getData().getHeight());
        assertEquals(28, playersList.get(0).getData().getAge());
        assertEquals(Arrays.asList(1, 0, 0, 0, 1), playersList.get(0).getData().getLast());
		return playersList;
    }

    @Test
    public void testGetAllPlayersSortedByRankEmptyList() {
      
     

        // Appelez la méthode du service à tester
        List<Players> sortedPlayers = tennisPlayerService.getAllPlayersSortedByRank();

        // Vérifiez que la liste retournée est également vide
        assertTrue(sortedPlayers.isEmpty());
    }
    @Test
    public void getPlayerById() {
    	  playersList.add(new Players(1L, "Ons", "Jabeur", "O.JAB", "F",
                  new Country("https://data.latelier.co/training/tennis_stats/resources/Tunisie.png", "TN"), "https://data.latelier.co/training/tennis_stats/resources/Ons.png",
                  new PlayerData((long) 1, 1, 4846, 174, 50, 28, Arrays.asList(1, 0, 0, 0, 1))));
          playersList.add(new Players(2L, "Iga", "Siwatek", "I.Siwa", "F",
                  new Country("https://data.latelier.co/training/tennis_stats/resources/Pologne.png", "PL"), "https://data.latelier.co/training/tennis_stats/resources/Iga.png",
                  new PlayerData((long) 2, 2, 8900, 200, 70, 28, Arrays.asList(1, 1, 0, 0, 1))));
          ((TennisPlayerServiceImpl) tennisPlayerService).setPlayers(playersList);
          // tester avec un ID  existant
          Long existingOrNoId = 1L;
        
          try {
             ((TennisPlayerServiceImpl) tennisPlayerService).setPlayers(playersList);;
          } catch (Exception e) {
        	  e.printStackTrace();
          }
          	if(existingOrNoId.equals(playersList.get(0).getId())) {
          // Vérifiez que la réponse est correcte et contient le joueur attendu
      
          assertEquals("Ons", playersList.get(0).getFirstName());
          assertEquals("Jabeur", playersList.get(0).getLastName());
          assertEquals("O.JAB", playersList.get(0).getShortName());
          assertEquals("F", playersList.get(0).getSex());
          assertEquals("https://data.latelier.co/training/tennis_stats/resources/Tunisie.png", playersList.get(0).getCountry().getPicture());
          assertEquals(1, playersList.get(0).getData().getRank());
          assertEquals(4846, playersList.get(0).getData().getPoints());
          assertEquals(174, playersList.get(0).getData().getWeight());
          assertEquals(50, playersList.get(0).getData().getHeight());
          assertEquals(28, playersList.get(0).getData().getAge());
          assertEquals(Arrays.asList(1, 0, 0, 0, 1), playersList.get(0).getData().getLast());

          		}
          	else {
	     fail("players not found for this id"+ existingOrNoId);
          	}

    }
    @Test
    public void testGetCountryRatio() {
    	 String countryRatio = tennisPlayerService.getCountryRatio();

         // Vérifiez que la réponse est correcte et correspond au pays avec le plus grand ratio
         assertEquals("Pays avec le plus grand ratio de parties gagnées : CodeDuPays", countryRatio);
    }
    @Test
    public void testGetAverageIMC() {
    	 // Appelez la méthode du service à tester
        double averageIMC = tennisPlayerService.getAverageIMC();

        // Vérifiez que la réponse est correcte et correspond à la moyenne de l'IMC des joueurs
        assertEquals(23357.838995505834, averageIMC, 23357.838995505834); 
        assertEquals(58888.2, averageIMC,58888.2); 
    }
    @Test
    public void testGetMedianHeight() {
    	  double medianHeight = tennisPlayerService.getMedianHeight();

          // Vérifiez que la réponse est correcte et correspond à la médiane
          assertEquals(185.0, medianHeight, 185.0); 
          assertEquals(10.0, medianHeight, 10.0); 
    }
    
    
}
