package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;
import pojos.Player;
import pojos.Team;

public class PlayerDaoimpl implements PlayerDao {

	@Override
	public String addPlayerToteam(Player newPlayer, long teamid) {
		String mesg = "adding p failed!!!!!!!!!!!";
		Team team=new Team();
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			team=session.get(Team.class, teamid);
			if(team!=null)
			{
				team.addPlayer(newPlayer);
			}
						
			tx.commit(); 
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

}
