package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {

	String addnewteam(Team team);
	//add a method to lift id and abbrevation from all the teams
	 List<Team> getallteams(); //hint ctor expression 
	 Team getTeamdetails(long id);
}
