package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book extends BaseEntity{
	
//	id,title(unique), price + ?????
	@Column(length = 30,unique = true)
	private String title;
	@Column(length = 20)
	private double price;
	
	@ManyToOne
	private Author bookauthor;

	public Book() {
		super();
	}

	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(Author bookauthor) {
		this.bookauthor = bookauthor;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
	
}
