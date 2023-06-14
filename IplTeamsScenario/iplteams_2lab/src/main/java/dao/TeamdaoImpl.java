package dao;

import static utils.Dbutils.closeConnection;
import static utils.Dbutils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Teams;

public class TeamdaoImpl implements TeamDao{
	private Connection cn;
	private PreparedStatement pst1;
	
	public TeamdaoImpl() throws SQLException
	{
		cn=openConnection();
		pst1=cn.prepareStatement("select team_id,abbrevation from teams");	
		System.out.println("team dao created !!!");
	}
	
	@Override
	public List<Teams> getSelectedDetails() throws SQLException {
		List<Teams> teams=new ArrayList<>(); 
			
		try (ResultSet rst=pst1.executeQuery()){
			while(rst.next())
			{
				teams.add(new Teams(rst.getInt(1), rst.getString(2)));	//as per the result set column order
			}
			return teams;
		}
		
	}
	
	public void cleanup() throws SQLException
	{
		if(pst1!=null)
			pst1.close();
		closeConnection();
		
	}

}
