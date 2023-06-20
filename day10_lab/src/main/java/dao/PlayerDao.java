package dao;

import pojos.Player;

public interface PlayerDao {
	//add a method to add new Player to the team
	String addPlayerToteam(Player newPlayer,long teamid); //get the team check for null and simply add the players

}
