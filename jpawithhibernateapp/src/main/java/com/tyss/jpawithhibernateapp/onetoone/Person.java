package com.tyss.jpawithhibernateapp.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;



@Data
@Entity
@Table(name="person")
public class Person {
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vid")//foriegn key
	private VoterCard voterCard;
	
	

}
