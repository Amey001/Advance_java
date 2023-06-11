package dao;

import static utils.Dbutils.openConnection;
import static utils.Dbutils.closeConnection;

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
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		System.out.println("candidatedao impl successfully ");
		
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
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		pst2.setInt(1, candidateId);
		int updatedcount=pst2.executeUpdate();
		if(updatedcount==1)
		{
			return " voter Count updated Successfully !!!";
		}
		else {
			return " failed incrementing count !!";
		}
	}


	public void Cleanup() throws SQLException
	{
		if(pst1 != null)
		{
			pst1.close();
		}
		if(pst2 != null)
		{
			pst2.close();
		}
		closeConnection();
		System.out.println("candidate dao cleaned up Succesffully !!");	
	}
}
