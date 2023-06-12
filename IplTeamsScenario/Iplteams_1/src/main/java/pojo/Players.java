package pojo;

import java.sql.Date;

public class Players {
	private int id;
	private String name;
	private Date dob;
	private double battingAverage;
	private int wickets;
	public Players(int id, String name, Date dob, double battingAverage, int wickets) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.battingAverage = battingAverage;
		this.wickets = wickets;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(float battingAverage) {
		this.battingAverage = battingAverage;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", dob=" + dob + ", battingAverage=" + battingAverage
				+ ", wickets=" + wickets + "]";
	}
	
	

}
