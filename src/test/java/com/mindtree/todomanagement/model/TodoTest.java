package com.mindtree.todomanagement.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;


public class TodoTest {

	Todo todo;
	
	@Before
	public void setup() {
		todo = new Todo();
		todo.setDescription("About todo");
		todo.setId(1);
		todo.setUserName("Alok");;
	}
	
	@Test
	public void getIdTest() {
		long id = todo.getId();
		assertNotNull(id);
	}
	@Test
	public void getDescriptionTest() {
		String dec = todo.getDescription();
		assertNotNull(dec);
	}
	
	@Test
	public void getUserNameTest() {
		String name = todo.getUserName();
		assertNotNull(name);
	}
}
