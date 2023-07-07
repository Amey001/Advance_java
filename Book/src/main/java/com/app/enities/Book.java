package com.app.enities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="book")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEnity{
	
	@Column(unique = true)
	private String name;
	private Integer price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Author authorname;
	
	

}
