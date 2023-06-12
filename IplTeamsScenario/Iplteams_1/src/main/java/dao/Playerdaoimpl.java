package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static utils.DButils.openConnection;
import static utils.DButils.closeConnection;

public class Playerdaoimpl implements PlayerDao {
	private Connection cn;
	private PreparedStatement pst1;
	
	public Playerdaoimpl() throws SQLException
	{ 
		cn=openConnection();
		pst1=cn.prepareStatement("insert into players values(deafult,	)");
		
	}
	

	@Override
	public String addplayer(String teamname, String name, Date dob, double battingaverage, int wickets)
			throws SQLException {
		
		return null;
	}

}
