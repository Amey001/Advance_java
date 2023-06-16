package pojos;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stud_id")
	private Integer studentid;
	@Column(name="first_name",length = 20)
	private String firstname;
	@Column(name="last_name",length = 20)
	private String lastname;
	@Column(name="email",length = 50,unique = true)
	private String email;
	@Column(name="pass",length = 50,nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name="course",length = 50)
	private Course course;
	@Column(name="dob",length = 30,nullable = false)
	private LocalDate dob;
	
	public Student(String firstname, String lastname, String email, String password, Course course,
			LocalDate dob) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.course = course;
		this.dob = dob;
	}
	
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + ", course=" + course + ", dob=" + dob + "]";
	}
	
	
	
	
}
