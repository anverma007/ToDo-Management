package com.mindtree.todomanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.todomanagement.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

	 List<Todo> findByUserName(String user);
}
