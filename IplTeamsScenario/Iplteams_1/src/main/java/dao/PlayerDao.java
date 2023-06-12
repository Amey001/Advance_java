package dao;

import java.sql.Date;
import java.sql.SQLException;

public interface PlayerDao {
	String addplayer(String teamname,String name,Date dob,double battingaverage,int wickets) throws SQLException;
}
