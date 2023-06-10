package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Candidate;

public interface CandidateDao {
	
	List<Candidate> allcandidatelist() throws SQLException;
	
	String incrementCandidateVotes(int candidated) throws SQLException;
	

}
