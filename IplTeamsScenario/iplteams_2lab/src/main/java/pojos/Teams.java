package pojos;

public class Teams {
//	id , name, abbrevation,owner,max_age,batting_avg,wickets_taken
	private int id;
	private String name;
	private String abbrevation;
	private String owner;
	private int max_age;
	private double batting_avg;
	private int wickets_taken;
		
	public Teams() {
		
	}
	
	public Teams(int id,String abbrevation) {
		super();
		this.id = id;
		this.abbrevation = abbrevation;
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
	public String getabbrevation() {
		return abbrevation;
	}
	public void setabbrevation(String abbrevation) {
		abbrevation = abbrevation;
	}
	public String getowner() {
		return owner;
	}
	public void setowner(String owner) {
		owner = owner;
	}
	public int getMax_age() {
		return max_age;
	}
	public void setMax_age(int max_age) {
		this.max_age = max_age;
	}
	public double getBatting_avg() {
		return batting_avg;
	}
	public void setBatting_avg(double batting_avg) {
		this.batting_avg = batting_avg;
	}
	public int getWickets_taken() {
		return wickets_taken;
	}
	public void setWickets_taken(int wickets_taken) {
		this.wickets_taken = wickets_taken;
	}
	@Override
	public String toString() {
		return "Teams [id=" + id + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner + ", max_age="
				+ max_age + ", batting_avg=" + batting_avg + ", wickets_taken=" + wickets_taken + "]";
	}
	
	
	

}
