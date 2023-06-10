package dao;

import static utils.Dbutils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Candidate;

public class CandidatedaoImpl implements CandidateDao{
	private Connection cn;
	private PreparedStatement pst1,pst2;
	
	public CandidatedaoImpl() throws SQLException
	{
		cn=openConnection();
		pst1=cn.prepareStatement("select * from candidates");
//		pst2=cn.prepareStatement("");
		
	}
	
	@Override
	public List<Candidate> allcandidatelist() throws SQLException {
		
		List<Candidate> candidatelist=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
			{
				candidatelist.add(new Candidate(rst.getInt(1), rst.getString(2),rst.getString(3), rst.getInt(4)));
			}
			return candidatelist;
		}
		
	}

	@Override
	public String incrementCandidateVotes(int candidateId) {
		return null;
	}
	

}
