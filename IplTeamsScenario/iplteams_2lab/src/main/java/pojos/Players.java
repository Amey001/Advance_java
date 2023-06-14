package pojos;

import java.sql.Date;

public class Players {
	private int id;
	private String firstname;
	private String lastname;
	private Date dob;
	private double battingAavg;
	private int wicketsTaken;
	private int team_id;
		
	public Players() {
	
	}
	
	public Players(int id, String firstname, String lastname, Date dob, double battingAavg, int wicketsTaken,
			int team_id) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.battingAavg = battingAavg;
		this.wicketsTaken = wicketsTaken;
		this.team_id = team_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public double getBattingAavg() {
		return battingAavg;
	}
	public void setBattingAavg(double battingAavg) {
		this.battingAavg = battingAavg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	@Override
	public String toString() {
		return "Players [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", battingAavg=" + battingAavg + ", wicketsTaken=" + wicketsTaken + ", team_id=" + team_id + "]";
	}
	
		
}
