package com.app.enities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author extends BaseEnity{
	@Column(unique = true)
	private String Authorname;
	
	private int age;
	
	private String address;
	
	private String email;
	
	@OneToMany(mappedBy = "authorname",cascade = CascadeType.ALL)
	private List<Book> booklist=new ArrayList<>();
}
