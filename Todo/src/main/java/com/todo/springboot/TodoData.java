package com.todo.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="todo")

public class TodoData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotNull
	private long todoID;

	@Column(length = 50, nullable = false)
	private String userID;

	@Column(length = 200, nullable = true)
	private String todo_text;

	@Column(nullable = true)
	private String created_date;

	@Column(nullable = true)
	private String upload_date;

	public long getTodoID() {
		return todoID;
	}
	public void setTodoID(long todoID) {
		this.todoID = todoID;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTodoText() {
		return todo_text;
	}
	public void setTodoText(String todoText) {
		this.todo_text = todoText;
	}

	public String getCreatedDate() {
		return created_date;
	}
	public void setCreatedDate(String createdDate) {
		this.created_date = createdDate;
	}

	public String getUploadDate() {
		return upload_date;
	}
	public void setUploadDate(String uploadDate) {
		this.upload_date = uploadDate;
	}
}