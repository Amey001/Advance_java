package com.app.entitries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "heros")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreType
public class Hero extends BaseIntity {
	@Column(name = "first_name", length = 20)
	private String firstname;
	@Column(name = "last_name", length = 20)
	private String lastname;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "passsword")
	private String password;
	@Column(name = "adress", length = 20)
	private String address;
	@Column(name = "age", length = 20)
	private int age;

	@OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Movie> movie = new ArrayList<>();
}
