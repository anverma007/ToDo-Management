package com.mindtree.todomanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private long id;
	private String userName;
	private Date targetDate;
	
	@Size(min = 10, message = "Enter at least 10 Characters...")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo(String user, String desc, Date targetDate, boolean isDone) {
		super();
		this.userName = user;
	    this.description = desc;
	    this.targetDate = targetDate;
	}

}
