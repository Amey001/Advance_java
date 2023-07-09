package com.app.entitries;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@MappedSuperclass
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BaseIntity 
{
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
}
