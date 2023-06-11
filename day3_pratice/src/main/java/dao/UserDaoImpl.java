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
		pst2=cn.prepareStatement("update users set status=1 where id=?");
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
	public String updateVotingStatus(int voterid) throws SQLException {
		pst2.setInt(1, voterid);
		int count=pst2.executeUpdate();
		if(count==1)
		{
			return "voted Successfully !!!";
		}
		else {
			return " failed Voting !!";
		}
	}
	
	public void Cleanup() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		
		closeConnection();
		System.out.println("userdao cleaned up successfully !!!");
	}
}
