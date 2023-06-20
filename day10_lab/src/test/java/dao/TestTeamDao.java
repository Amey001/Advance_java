package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Team;
import utils.HibernateUtils;

class TestTeamDao {
private static TeamDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		HibernateUtils.getFactory();
		dao=new TeamDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		HibernateUtils.getFactory().close();
	}
//
//	@Test
//	void test() {
//		//create team instance :: hard coded details
//		Team newteam=new Team("Kolkata knight Riders", "KKR","owner1",35, 70, 7);
//		//invoke dao's method
//		String mesg=dao.addnewteam(newteam);
//		System.out.println(" mesg :: "+ mesg);
//		//assert :: if 
//		assertEquals(1, newteam.getId());
//	}

	@Test
	void testGetAllTeams()
	{
		List<Team> teams=dao.getallteams();
		teams.forEach(a->System.out.println("id :: "+a.getId()+" abbrevation"+a.getAbbreviation()));
		assertEquals(2, teams.size());
	}
}
