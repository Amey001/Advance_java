package pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="author")
public class Author extends BaseEntity {
//	:id first name ,last name , email(unique) , pwd + ???????
	
	@Column(name="first_name",length=20)
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	@Column(length = 40)
	private String email;
	@Column(length = 40)
	private String password;
	@OneToMany(mappedBy = "bookauthor",cascade = CascadeType.ALL)
	private List<Book> booklist;
	
	
	public Author() {
		super();
	}

	public Author(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public String addnewBook(Book b)
	{
		booklist.add(b);
		b.setBookauthor(this);
		
		return " new book added successfully";
	}
	
	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
	}
	

}
