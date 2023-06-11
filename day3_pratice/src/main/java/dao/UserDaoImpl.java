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
	private PreparedStatement pst1,pst2,pst3;
	
	public UserDaoImpl() throws SQLException
	{	
		cn=openConnection();
		pst1=cn.prepareStatement("select * from users where email=? and password=?");
		pst2=cn.prepareStatement("update users set status=1 where id=?");
		pst3=cn.prepareStatement("insert into users values(default,?,?,?,?,?,0,'voter')");
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
	public String addusers(String fname,String lname,String email,String password,Date dob1) throws SQLException {
		pst3.setString(2,fname);
		pst3.setString(3, lname);
		pst3.setString(4, email);
		pst3.setString(5, password);
		pst3.setDate(6, dob1);
		System.out.println("at line 54 !!! of userdao !!");
		int insertcount=pst3.executeUpdate();
		if(insertcount==1)
			return "data inserted successfully";
		return " failed to add data";
		
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
