package com.atelier.tennis.statestiques.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerData  {

	  

	    private int rank;
	    private int points;
	    private int weight;
	    private int height;
	    private int age;
	    private List<Integer> last;
	    private List<Players> players;

		public PlayerData(List<Players> players) {
			super();
			this.players = players;
		}


		public void setPlayers(List<Players> players) {
			this.players = players;
		}


		public PlayerData(Long id, int rank, int points, int weight, int height, int age, List<Integer> last) {
		super();
		
		this.rank = rank;
		this.points = points;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.last = last;
	}

		
		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public int getPoints() {
			return points;
		}

		public void setPoints(int points) {
			this.points = points;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public List<Integer> getLast() {
			return last;
		}

		public void setLast(List<Integer> last) {
			this.last = last;
		}


		public List<Players> getPlayers() {
			// TODO Auto-generated method stub
			return players;
		}
		 
	    public PlayerData() {
	    }
	    
}
