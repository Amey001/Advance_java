package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.openmbean.OpenDataException;

import static utils.Dbutils.openConnection;
import static utils.Dbutils.closeConnection;

import pojo.User;

public class UserDaoImpl implements UserDao{
	private Connection cn;
	private PreparedStatement pst1,pst2;
	
	public UserDaoImpl() throws SQLException
	{	
		cn=openConnection();
		pst1=cn.prepareStatement("select * from users where email=? and password=?");
		System.out.println("User dao created !!");		
	}

	@Override
	public User authentiateuser(String email,String password) throws SQLException {
		
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
			{
//				int id,String firstName,String lastName,String email,String password,Date dob,
//				boolean votingStatus, String role
				return new User(rst.getInt(1), rst.getString(2),rst.getString(3), email, password, rst.getDate(6), rst.getBoolean(7),rst.getString(8));
			}
		}
		
		return null;
	}

	@Override
	public String updateVotingStatus(int voterid) {
		
		return null;
	}
}
