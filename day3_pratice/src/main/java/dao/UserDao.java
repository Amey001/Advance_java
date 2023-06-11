package dao;
import java.sql.Date;
import java.sql.SQLException;

import pojo.User;

public interface UserDao {
	
	User authentiateuser(String email,String password) throws SQLException;
	String updateVotingStatus(int voterid) throws SQLException;
	String addusers(String fname,String lname,String email,String password,Date dob) throws SQLException;

}
