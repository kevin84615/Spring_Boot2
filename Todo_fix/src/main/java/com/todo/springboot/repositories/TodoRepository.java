package com.todo.springboot.repositories;

import com.todo.springboot.TodoData;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoData, Long> {
	public Optional<TodoData> findById(Long todoID);
}