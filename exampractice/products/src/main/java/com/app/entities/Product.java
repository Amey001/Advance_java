package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product extends BaseEntity{
	//pname,pprice,pcategory
	
	@Column(name = "name",length = 20,unique = true)
	private String name;
	
	private double price;
	
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "cat")
	private Category cat;
	
}
