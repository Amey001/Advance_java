package dao;
import java.sql.SQLException;

import pojo.User;

public interface UserDao {
	
	User authentiateuser(String email,String password) throws SQLException;
	String updateVotingStatus(int voterid) throws SQLException;

}
