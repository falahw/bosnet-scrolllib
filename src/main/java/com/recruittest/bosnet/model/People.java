package com.recruittest.bosnet.model;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bosnet_people")
public class People {

	@Id
	@GeneratedValue(generator = "people-id", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "people-id", strategy = "com.recruittest.bosnet.model.PeopleIdGenerator")
	@Column(name = "people_id")
	private String id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd") //@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate birthday;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "People [id=" + id + ", fullName=" + fullName + ", birthday=" + birthday + "]";
	}
}
