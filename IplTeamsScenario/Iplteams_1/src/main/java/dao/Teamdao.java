package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Teams;

public interface Teamdao {
	List<Teams> allteams() throws SQLException ;

}
