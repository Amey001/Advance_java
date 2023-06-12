package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import static utils.DButils.openConnection;
import static utils.DButils.closeConnection;

import pojo.Teams;

public class TeamDaoimpl implements Teamdao {
	private Connection cn;
	private PreparedStatement pst1;
	
	public TeamDaoimpl() throws SQLException
	{
		cn=openConnection();
		pst1=cn.prepareStatement("select * from iplteams");
	}

	@Override
	public List<Teams> allteams() throws SQLException {
		List<Teams> teamlist=new ArrayList<>();
		
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
			{
				teamlist.add(new Teams(rst.getInt(1),rst.getString(2)));
			}
			return teamlist;
		}
		
	}

}
