package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public Team getTeamdetails(long id) {
		Team team=new Team();
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			team=session.get(Team.class, id);								
			tx.commit(); 
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public String addnewteam(Team team) {
		String mesg = "team add failed !!!";
		
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
				// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(team);
										
			tx.commit(); 
			mesg=" added team successfull !!!";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		
		return mesg;
	}

	
	@Override
	public List<Team> getallteams() { 
			String jpql = "select new pojos.Team(id,abbreviation) from Team t";
			List<Team> teamlist=null;
			// 1 get session from SF
			Session session = getFactory().getCurrentSession();
					// 2. begin a tx
			Transaction tx = session.beginTransaction();
			try {
				teamlist=session.createQuery(jpql,Team.class)						
					.getResultList();
											
				tx.commit(); 
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}
		return teamlist ;
	}



	
}
